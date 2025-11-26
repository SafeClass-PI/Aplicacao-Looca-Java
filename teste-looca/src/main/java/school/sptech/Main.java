package school.sptech;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import school.sptech.bd.BancoDados;
import school.sptech.repository.SlackService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static final int ID_COMPONENTE_UPLOAD = 9;
    private static final int ID_COMPONENTE_DOWNLOAD = 10;

    private static final String SLACK_TOKEN = (System.getenv("SlackToken"));
    private static final String SLACK_CANAL = "#canal-teste-alerta";

    public static void main(String[] args) throws InterruptedException, SQLException {
        Looca looca = new Looca();
        BancoDados banco = new BancoDados();
        SlackService slack = new SlackService(SLACK_TOKEN);

        slack.enviarAlerta(SLACK_CANAL, "✅ Captura de Upload e Download sem criticidades!");

        RedeInterface rede = looca.getRede().getGrupoDeInterfaces()
                .getInterfaces()
                .stream()
                .filter(r -> r.getBytesEnviados() > 0 || r.getBytesRecebidos() > 0)
                .findFirst()
                .orElse(null);

        if (rede == null) {
            System.out.println("Nenhuma interface de rede ativa encontrada.");
            return;
        }

        long bytesEnviadosAnterior = rede.getBytesEnviados();
        long bytesRecebidosAnterior = rede.getBytesRecebidos();

        try (Connection conexao = banco.conectar()) {
            long intervalo = 5000;

            while (true) {
                Thread.sleep(intervalo);

                long bytesEnviadosAtual = rede.getBytesEnviados();
                long bytesRecebidosAtual = rede.getBytesRecebidos();

                double mbpsEnviados = ((bytesEnviadosAtual - bytesEnviadosAnterior) * 8.0) / 1_000_000 / (intervalo / 1000.0);
                double mbpsRecebidos = ((bytesRecebidosAtual - bytesRecebidosAnterior) * 8.0) / 1_000_000 / (intervalo / 1000.0);

                System.out.printf("Enviados: %.2f Mbps | Recebidos: %.2f Mbps%n", mbpsEnviados, mbpsRecebidos);

                int idCapturaUpload = inserirCaptura(conexao, ID_COMPONENTE_UPLOAD, mbpsEnviados);
                int idCapturaDownload = inserirCaptura(conexao, ID_COMPONENTE_DOWNLOAD, mbpsRecebidos);

                verificarParametroEAlerta(conexao, ID_COMPONENTE_UPLOAD, mbpsEnviados, idCapturaUpload, slack);
                verificarParametroEAlerta(conexao, ID_COMPONENTE_DOWNLOAD, mbpsRecebidos, idCapturaDownload, slack);

                bytesEnviadosAnterior = bytesEnviadosAtual;
                bytesRecebidosAnterior = bytesRecebidosAtual;
            }
        }
    }

    private static int inserirCaptura(Connection conexao, int fkComponente, double registro) {
        String sql = "INSERT INTO Captura(fkComponente, registro) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, fkComponente);
            stmt.setDouble(2, registro);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir captura: " + e.getMessage());
        }
        return -1;
    }

    private static void verificarParametroEAlerta(Connection conexao, int fkComponente, double registro, int fkCaptura, SlackService slack) {
        String sql = "SELECT minimo, maximo, idParametro FROM Parametro WHERE fkComponente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, fkComponente);
            ResultSet rs = stmt.executeQuery();

            boolean dentroParametro = false;
            int fkParametro = -1;

            while (rs.next()) {
                double minimo = rs.getDouble("minimo");
                double maximo = rs.getDouble("maximo");

                if (registro >= minimo && registro <= maximo) {
                    dentroParametro = true;
                    break;
                } else {
                    fkParametro = rs.getInt("idParametro");
                }
            }

            if (!dentroParametro && fkParametro != -1) {
                String mensagem = String.format("⚠ Componente %d fora do parâmetro: %.2f Mbps", fkComponente, registro);
                inserirAlerta(conexao, fkCaptura, mensagem, fkParametro);
                System.out.println(mensagem);
                slack.enviarAlerta(SLACK_CANAL, mensagem);
            } else {
                System.out.println("✅ Componente " + fkComponente + " dentro do parâmetro.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao verificar parâmetros: " + e.getMessage());
        }
    }

    private static void inserirAlerta(Connection conexao, int fkCaptura, String mensagem, int fkParametro) {
        String sql = "INSERT INTO Alerta(fkParametro, fkCaptura, mensagem, enviado) VALUES (?, ?, ?, 0)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, fkParametro);
            stmt.setInt(2, fkCaptura);
            stmt.setString(3, mensagem);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir alerta: " + e.getMessage());
        }
    }
}
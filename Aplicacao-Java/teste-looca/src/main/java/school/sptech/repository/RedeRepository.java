package school.sptech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import school.sptech.BancoDados;

/**
 * Repositório responsável por salvar os dados de rede no banco de dados.
 */
public class RedeRepository {

    private final BancoDados bancoDados;
    private int idComponenteRede;

    public RedeRepository() {
        this.bancoDados = new BancoDados();
        this.idComponenteRede = 4; // ID fixo do componente de rede conforme o banco de dados
    }

    /**
     * Salva os dados de velocidade de download e upload no banco de dados.
     *
     * @param velocidadeDownloadMbps Velocidade de download em Mbps
     * @param velocidadeUploadMbps   Velocidade de upload em Mbps
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados
     */
    public void salvarVelocidadeRede(double velocidadeDownloadMbps, double velocidadeUploadMbps) throws SQLException {
        try (Connection conexao = bancoDados.conectar()) {
            String sql = "INSERT INTO captura (fkComponente, velocidadeDownload, velocidadeUpload) VALUES (?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idComponenteRede);
            ps.setDouble(2, velocidadeDownloadMbps);
            ps.setDouble(3, velocidadeUploadMbps);
            ps.executeUpdate();
        }
    }

    /**
     * Método main para executar o monitoramento de rede diretamente deste arquivo.
     *
     * @param args Argumentos da linha de comando (não utilizados)
     * @throws InterruptedException Se o thread for interrompido durante o sleep
     * @throws SQLException         Se ocorrer um erro ao acessar o banco de dados
     */
    public static void main(String[] args) throws InterruptedException, SQLException {
        Looca looca = new Looca();
        RedeRepository redeRepository = new RedeRepository();

        System.out.println("Monitorando velocidade de rede (Download/Upload em Mbps) a cada 5 segundos...");
        System.out.println("Pressione CTRL+C para parar.\n");

        // Filtra a primeira interface com algum tráfego (ativa)
        RedeInterface rede = looca.getRede().getGrupoDeInterfaces()
                .getInterfaces()
                .stream()
                .filter(i -> i.getBytesRecebidos() > 0 || i.getBytesEnviados() > 0)
                .findFirst()
                .orElse(null);

        if (rede == null) {
            System.out.println("Nenhuma interface de rede ativa encontrada.");
            return;
        }

        // Inicializa variáveis para cálculo de velocidade
        long bytesEnviadosAnterior = rede.getBytesEnviados();
        long bytesRecebidosAnterior = rede.getBytesRecebidos();
        long tempoInicial = System.currentTimeMillis();

        while (true) {
            // Aguarda 5 segundos para a próxima medição
            Thread.sleep(5000);

            // Captura velocidades de rede
            double velocidadeDownloadMbps = obterVelocidadeDownload(rede, bytesRecebidosAnterior, tempoInicial);
            double velocidadeUploadMbps = obterVelocidadeUpload(rede, bytesEnviadosAnterior, tempoInicial);

            // Exibe as velocidades no console
            System.out.printf("↓ Download: %.2f Mbps | ↑ Upload: %.2f Mbps%n",
                    velocidadeDownloadMbps, velocidadeUploadMbps);

            // Salva no banco usando o repositório
            redeRepository.salvarVelocidadeRede(velocidadeDownloadMbps, velocidadeUploadMbps);

            // Atualiza valores para próxima medição
            bytesEnviadosAnterior = rede.getBytesEnviados();
            bytesRecebidosAnterior = rede.getBytesRecebidos();
            tempoInicial = System.currentTimeMillis();
        }
    }

    /**
     * Obtém a velocidade de download atual em Mbps.
     *
     * @param rede                   Interface de rede para obter os dados
     * @param bytesRecebidosAnterior Bytes recebidos na medição anterior
     * @param tempoInicial           Tempo da medição anterior em milissegundos
     * @return Velocidade de download em Mbps
     */
    private static double obterVelocidadeDownload(RedeInterface rede, long bytesRecebidosAnterior, long tempoInicial) {
        long bytesRecebidosAtual = rede.getBytesRecebidos();
        long tempoAtual = System.currentTimeMillis();
        double segundosDecorridos = (tempoAtual - tempoInicial) / 1000.0;

        // Evita divisão por zero
        if (segundosDecorridos <= 0) {
            return 0.0;
        }

        long bytesRecebidosDelta = bytesRecebidosAtual - bytesRecebidosAnterior;
        return (bytesRecebidosDelta * 8) / (segundosDecorridos * 1_000);
    }

    /**
     * Obtém a velocidade de upload atual em Mbps.
     *
     * @param rede                  Interface de rede para obter os dados
     * @param bytesEnviadosAnterior Bytes enviados na medição anterior
     * @param tempoInicial          Tempo da medição anterior em milissegundos
     * @return Velocidade de upload em Mbps
     */
    private static double obterVelocidadeUpload(RedeInterface rede, long bytesEnviadosAnterior, long tempoInicial) {
        long bytesEnviadosAtual = rede.getBytesEnviados();
        long tempoAtual = System.currentTimeMillis();
        double segundosDecorridos = (tempoAtual - tempoInicial) / 1000.0;

        // Evita divisão por zero
        if (segundosDecorridos <= 0) {
            return 0.0;
        }

        long bytesEnviadosDelta = bytesEnviadosAtual - bytesEnviadosAnterior;
        return (bytesEnviadosDelta * 8) / (segundosDecorridos * 1_000);
    }
}

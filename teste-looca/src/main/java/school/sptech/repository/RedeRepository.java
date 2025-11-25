package school.sptech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import school.sptech.bd.BancoDados;

public class RedeRepository {

    public final BancoDados bancoDados;
    private final int componenteUpload = 4;
    private final int componenteDownload = 5;

    public RedeRepository() {
        this.bancoDados = new BancoDados();
    }

    public int getComponenteUpload() {
        return componenteUpload;
    }

    public int getComponenteDownload() {
        return componenteDownload;
    }

    public String getNomeComponente(int idComponente) {
        String sql = "SELECT nome FROM Componente WHERE idComponente = ?";
        try (Connection conn = bancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idComponente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getString("nome");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Desconhecido";
    }

    // -----------------------------------------
    // Ajuste: Captura não tem fkMaquina no banco
    // -----------------------------------------
    public void registrarLeitura(int idComponente, double valor) {
        String sql = "INSERT INTO Captura (registro, fkComponente) VALUES (?, ?)";
        try (Connection conn = bancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, valor);
            stmt.setInt(2, idComponente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO ao salvar captura.");
            e.printStackTrace();
        }
    }

    public double getUltimaCaptura(int idComponente) {
        String sql = "SELECT registro FROM Captura WHERE fkComponente = ? ORDER BY idCaptura DESC LIMIT 1";
        try (Connection conn = bancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idComponente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getDouble("registro");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static class Parametro {
        public double minimo;
        public double maximo;
        public String sala;
        public int maquina;
        public String ip;
        public double capacidade;
        public String sistemaOperacional;
        public String canalSlack;
    }

    public Parametro getParametroComponente(int idComponente) {
        String sql = """
            SELECT
                p.minimo, p.maximo,
                s.nome AS sala,
                m.idMaquina AS maquina,
                m.ip,
                c.capacidade,
                m.sistemaOperacional,
                e.idSlack AS canalSlack
            FROM Parametro p
            JOIN Componente c ON p.fkComponente = c.idComponente
            JOIN Maquina m ON c.fkMaquina = m.idMaquina
            JOIN Sala s ON m.fkSala = s.idSala
            JOIN Escola e ON s.fkEscola = e.idEscola
            WHERE c.idComponente = ?
        """;

        Parametro p = new Parametro();

        try (Connection conn = bancoDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idComponente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.minimo = rs.getDouble("minimo");
                p.maximo = rs.getDouble("maximo");
                p.sala = rs.getString("sala");
                p.maquina = rs.getInt("maquina");
                p.ip = rs.getString("ip");
                p.capacidade = rs.getDouble("capacidade");
                p.sistemaOperacional = rs.getString("sistemaOperacional");
                p.canalSlack = rs.getString("canalSlack");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }
}

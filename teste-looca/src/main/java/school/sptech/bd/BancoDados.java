package school.sptech.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    private static final String URL = "jdbc:mysql://54.204.112.127:3306/safeclass?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "urubu100";

    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado no JAR!", e);
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
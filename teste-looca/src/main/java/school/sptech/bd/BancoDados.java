package school.sptech.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    private static final String URL =  "jdbc:mysql://54.204.112.127:3306/safeclass?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root"; // Usuário do MySQL
    private static final String SENHA = "urubu100"; // Senha do MySQL

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

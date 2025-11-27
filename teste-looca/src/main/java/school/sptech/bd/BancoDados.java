package school.sptech.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    private static final String URL = "jdbc:mysql://localhost:3306/safeclass";
    private static final String USUARIO = "root"; // Usuário do MySQL
    private static final String SENHA = "SUA_SENHA"; // Senha do MySQL

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

package laboral.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static final String DB_NAME = "sistema_nominas";
    private static final String CONN_URL = "jdbc:mariadb://localhost:3306/" + DB_NAME;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Carga manualmente la clase del driver de MariaDB en la memoria de la JVM.
            Class.forName("org.mariadb.jdbc.Driver");

            // Intenta establecer la conexión con la base de datos utilizando la URL
            conn = DriverManager.getConnection(CONN_URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
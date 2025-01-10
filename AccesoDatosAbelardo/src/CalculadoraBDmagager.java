import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CalculadoraBDmagager {
    private int port = 3306;
    private Connection conn;
    private String user = "root";
    private String password = "";
    private String dataBase = "calculadora";

    public Connection connectDataBase() {
        try {
            String connParams = "jdbc:mysql://localhost:" + port + dataBase;
            System.out.println("CADENA DE CONNEXIÓN ===> " + connParams);
            conn = DriverManager.getConnection(connParams, user, password);

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}



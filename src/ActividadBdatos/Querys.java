package ActividadBdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Querys {

    private Connection conn = null;
    private int port = 3306;
    private String user = "root";
    private String password = "";
    private String dataBase = "/gestion_usuarios";


    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public Querys() {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + password + dataBase);

            if (conn != null) {
                System.out.println("[ESTAMOS CONECTADOS A LA BASE DE DATOS]" + dataBase);
            } else {
                System.err.println("[ERROR]: No logramos conectarnos a la base de datos " + dataBase);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

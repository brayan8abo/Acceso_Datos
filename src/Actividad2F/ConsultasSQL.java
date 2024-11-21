package Actividad2F;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConsultasSQL {
	private int port = 3306;
	private Connection conn = null;
	private String user = "root";
	private String password = "";
	private String dataBase = "/gestion_usuarios";

	public void setConn(Connection conn) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + password + dataBase);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}

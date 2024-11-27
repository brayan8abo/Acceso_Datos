package Actividad2F;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class ConsultasSQL {
	private int port = 3306;
	private Connection conn;
	private String user = "root";
	private String password = "";
	private String dataBase = "/gestion_usuarios";

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

	public void insertUser(User user) {
		/*Scanner leer = new Scanner(System.in);
		System.out.println("Bienvenido, vamos a crear un usuario nuevo\n");
		System.out.println("Ingresa el nombre de usuario");
		String userInput = leer.nextLine();
		System.out.println("Ingresa tu contraseña");
		String passInput = leer.nextLine();

		User insertUser = new User(userInput, passInput);
		Services.users.add(insertUser);*/
		try {
			PreparedStatement ps = conn.prepareStatement("insert into usuarios (id_user, password, type_user, active, hora_fecha_ultimo_acceso_correcto, hora_fecha_ultimo_erroneo) values (?,?,?,?,NOW(),?)");
			ps.setString(1, user.getId_user());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getType_user());
			ps.setBoolean(4, user.isActive());
			//ps.setString(5, ""+new Date().getTime());
			ps.setString(5, null);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}



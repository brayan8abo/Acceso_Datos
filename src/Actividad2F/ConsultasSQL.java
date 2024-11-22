package Actividad2F;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsultasSQL {
	private int port = 3306;
	private Connection conn;
	private String user = "root";
	private String password = "";
	private String dataBase = "/gestion_usuarios";

	public void connectDataBase(Connection conn) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + password + dataBase);

			if (conn != null) {
				System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertUser(User user) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Bienvenido, vamos a crear un usuario nuevo\n");
		System.out.println("Ingresa el nombre de usuario");
		String userInput = leer.nextLine();
		System.out.println("Ingresa tu contraseña");
		String passInput = leer.nextLine();

		User insertUser = new User(userInput, passInput);
		Services.users.add(insertUser);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into usuarios (id_user,password,type_user,isActive,ultAccesoCorrecto,ultAccesoIncorrecto)values (?,?,?,?,?,?)");
			ps.setString(1, insertUser.getId_user());
			ps.setString(2, insertUser.getPassword());
			ps.setString(3, insertUser.getType_user());
			ps.setBoolean(4, insertUser.isActive());
			ps.setObject(5, null);
			ps.setObject(6, null);
			ps.executeUpdate();
			leer.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

}



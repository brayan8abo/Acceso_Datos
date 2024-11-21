package Actividad2F;

import java.time.LocalDate;
import java.util.ArrayList;

public class servicios {

	static ArrayList<User> users = new ArrayList<User>();

	public static boolean registrarUser(String id_user, String password, String type_user) {
		try {
			if (id_user.length() < 5 || password.length() < 5) {
				System.err.println("[ERROR]: La contraseña y/o el usuario deben superar los 5 caracteres");
				return false;
			}
			if (!type_user.equalsIgnoreCase("admin") && !type_user.equalsIgnoreCase("usuario_consulta")) {
				System.err.println("[ERROR]: Tipo de usuario no válido");
				return false;
			}
			String passwordMD5 = HexTransform.bytesToHex(password.getBytes());
			users.add(new User(id_user, passwordMD5, type_user, true));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean loginUser(String id_user, String password) {
		try {
			User user = id_user == null ? null : null;
			for (User listUser : users) {
				if (listUser.getId_user().equals(id_user)) {
					user = listUser;
					break;
				}

			}
			if (user == null || !user.isActive()) {
				System.err.println("[ERROR]: El usuario no existe o está inactivo");
				return false;
			}
			String passwordMD5 = HexTransform.bytesToHex(password.getBytes());
			if (user.getPassword().equals(passwordMD5)) {
				user.setUltAccesoCorrecto(LocalDate.now());
				user.setUltAccesoIncorrecto(null);
				System.out.println("Bienvenido," + id_user + "[" + user.getType_user() + "]");
				return true;
			} else {
				user.setUltAccesoIncorrecto(LocalDate.now());
				System.err.println("[ERROR]: Contraseña incorrecta");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}


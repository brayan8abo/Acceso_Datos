package Actividad2F;

import java.util.Scanner;

public class GestionUsuarios {


	private static User user = new User();

	public static void main(String[] args) {
		menuPrincipal();


	}

	public static void menuPrincipal() {
		Scanner leer = new Scanner(System.in);
		int opcion;
		do {
			//menu con opciones para gestionar usuarios
			System.out.println("<< MENÚ GESTIÓN USUARIOS >>\n");
			System.out.println("1). Registrar usuario\n");
			System.out.println("2). Iniciar sesión\n");
			System.out.println("3). Salir\n");
			System.out.println("Elige una opción: ");
			opcion = leer.nextInt();
			leer.nextLine(); //limpiamos el buffer

			// Connexión a la DB
			ConsultasSQL sql = new ConsultasSQL();
			sql.connectDataBase();

			switch (opcion) {
				// REGISTRO DEL USUARIO EN EL SISTEMA
				case 1:
					System.out.println("Ingresa tu ID de usuario");
					String id_user = leer.nextLine();

					System.out.println("Ingresa tu contraseña");
					String password = leer.nextLine();

					System.out.println("¿Qué tipo de usuario eres? [Admin/usuario_consulta]");
					String type_user = leer.nextLine();

					User user = Services.registrarUser(id_user, password, type_user);
					if (user != null) {
						// Se da de alta el user en la db
						sql.insertUser(user);
						System.out.println("Usuario registrado con exito\n");
					} else {
						System.err.println("[ERROR]: No se pudo registrar el usuario");
					}
					break;

				// LOGIN DEL USUARIO
				case 2:
					System.out.println("Ingresa tu ID de usuario");
					String loginUser = leer.nextLine();

					System.out.println("Ingresa tu contraseña");
					String loginPassword = leer.nextLine();

					if (Services.loginUser(loginUser, loginPassword)) {
						System.out.println("INICIANDO SESIÓN...");
					} else {
						System.err.println("[ERROR]: No se pudo iniciar sesión");
					}
					break;
				case 3:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.err.println("Opción no válida");
			}

		} while (opcion != 3);
		leer.close();
	}
}


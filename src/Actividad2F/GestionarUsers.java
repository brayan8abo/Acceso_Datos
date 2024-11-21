package Actividad2F;



import java.util.ArrayList;

public static void menuPrincipal(Querys querys) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("<<< BIENVENIDO AL SISTEMA >>>");
    System.out.println("Ingresa tu usuario:");
    String idUsuario = scanner.nextLine();

    System.out.println("Ingresa tu contraseña:");
    String contraseña = scanner.nextLine();

    User usuario = querys.autenticarUsuario(idUsuario, contraseña);

    if (usuario != null) {
        if (usuario.getActive()) {
            if (usuario.getType_user().equals("admin")) {
                mostrarMenuAdmin(querys);
            } else {
                mostrarMenuUsuarioConsulta();
            }
        } else {
            System.out.println("[ERROR]: El usuario está inactivo");
        }
    }
}

private static void mostrarMenuAdmin(Querys querys) {
    System.out.println("<<< MENÚ ADMINISTRADOR >>>");
    System.out.println("1. Agregar usuario");
    System.out.println("2. Salir");
    Scanner scanner = new Scanner(System.in);

    int opcion = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer

    if (opcion == 1) {
        System.out.println("Ingrese el ID del nuevo usuario:");
        String idUsuario = scanner.nextLine();

        System.out.println("Ingrese la contraseña:");
        String contraseña = scanner.nextLine();

        System.out.println("Ingrese el tipo de usuario (admin/usuario_consulta):");
        String tipoUsuario = scanner.nextLine();

        if (querys.agregarUsuario(idUsuario, contraseña, tipoUsuario)) {
            System.out.println("Usuario agregado correctamente.");
        } else {
            System.err.println("[ERROR]: No se pudo agregar al usuario.");
        }
    }
}

public void main() {
}


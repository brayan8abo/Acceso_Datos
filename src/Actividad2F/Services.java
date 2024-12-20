package Actividad2F;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.ArrayList;

public class Services {

    static ArrayList<User> users = new ArrayList<User>();

    public static Actividad2F.User registrarUser(String id_user, String password, String type_user) {
        try {
            if (id_user.length() < 5 || password.length() < 5) {
                System.err.println("[ERROR]: La contraseña y/o el usuario deben superar los 5 caracteres");
                return null;
            }
            if (!type_user.equalsIgnoreCase("admin") && !type_user.equalsIgnoreCase("usuario_consulta")) {
                System.err.println("[ERROR]: Tipo de usuario no válido");
                return null;
            }

            //codigo proporcionado por profesor para gestionar el HASH, hacemos uso de el para hacer la correcta validación de la password y convertirla
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theMD5Digest = md.digest(bytesOfMessage);
            String passwordMD5 = HexTransform.bytesToHex(theMD5Digest);

            User u = new User(id_user, passwordMD5, type_user, true);
            users.add(u);
            System.out.println("ESTOY AL FINAL DE SERVICES.REGISTRARUSER");
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean loginUser(String id_user, String password) {
        try {
            User user = null;
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


            password = password.trim(); // Eliminar espacios adicionales, para evitar fallos
            //codigo proporcionado por profesor para gestionar el HASH, hacemos uso de el para hacer la correcta validacion de la password y convertirla
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theMD5digest = md.digest(bytesOfMessage);
            String strMD5digest = HexTransform.bytesToHex(theMD5digest); // Convertir a hex

            /*TODO:hacemos pruebas de que las contraseñas almacenadas y pasadas sean iguales*/
            ////
//			System.out.println("Hash de la contraseña ingresada: " + strMD5digest);
//			System.out.println("Hash de la contraseña almacenada: " + user.getPassword());
            ////


            if (user.getPassword().equals(strMD5digest)) {
                user.setUltAccesoCorrecto(LocalDate.now());
                user.setUltAccesoIncorrecto(null);
                System.out.println("\tBienvenido, " + id_user + " [" + user.getType_user() + "]\n");

				ConsultasSQL sql = new ConsultasSQL();
                // Establezco la connexión con DB
				sql.connectDataBase();
                // Registro el último acceso correcto/incorrecto del usuario al system con su timestamp
				//sql.insertUser(user); // Llamada al nuevo método de inserción

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

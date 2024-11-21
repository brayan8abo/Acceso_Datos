package ActividadBdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Actividad1_AccesoDatos.EquipoBaloncesto.menu;

public class GestionarUsers {
    public static void main(String[] args) {

        ArrayList<User> usuarios = new ArrayList<>();

        usuarios.add(new User("Brayan", "12345", "Admin"));
        usuarios.add(new User("Maria", "password", "User"));
        menuPrincipal(usuarios);
    }

    public static void menuPrincipal(ArrayList<User> usuarios) {
        User user = new User();
        user.identificacion(usuarios);
    }
}

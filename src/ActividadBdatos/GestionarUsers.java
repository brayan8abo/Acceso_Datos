package ActividadBdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionarUsers {

    private Connection conexion;

    public GestionarUsers(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean validateUser(String id_user, String password) throws Exception {
        String hashPassword = User.generarPasswordMD5(password);
        String query = "SELECT * from users where id_user = ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, id_user);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (!rs.getBoolean("active")) {
                    System.out.println("Usuario inactivo");
                    return false;
                }
                if (rs.getString("password").equals(hashPassword)) {
                    System.out.println("Correcto, iniciando sesión");
                    registrarHoraYFechaCorrecto(id_user);
                    mostrarMenu(rs.getString("type_user"));
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta ");
                }
            }
            return false;
        }


        private void registrarHoraYFechaCorrecto (String id_user) throws SQLException {
            String updateSQL = "Update usuario set hora_fecha_ultimo_acceso_correcto = NOW() WHERE id_user =?";

        }


    }
}

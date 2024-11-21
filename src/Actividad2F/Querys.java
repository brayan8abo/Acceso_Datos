package Actividad2F;




import java.security.MessageDigest;
import java.sql.*;

public class Querys {

    private Connection conn;
    private int port = 3306;
    private String user = "root";
    private String password = "";
    private String database = "gestion_usuarios";

    public Querys() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database, user, password);

            if (conn != null) {
                System.out.println("[CONECTADO A LA BASE DE DATOS]: " + database);
            } else {
                System.err.println("[ERROR]: No se pudo conectar a la base de datos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public boolean agregarUsuario(String idUsuario, String contraseña, String tipoUsuario) {
        if (idUsuario.length() < 5 || contraseña.length() < 5) {
            System.err.println("[ERROR]: El usuario y la contraseña deben tener al menos 5 caracteres");
            return false;
        }

        try {
            String sql = "INSERT INTO usuarios (id_usuario, contraseña_hash, tipo_usuario) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idUsuario);
            ps.setString(2, HexTransform.bytesToHex(MessageDigest.getInstance("MD5").digest(contraseña.getBytes("UTF-8"))));
            ps.setString(3, tipoUsuario);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User autenticarUsuario(String idUsuario, String contraseña) {
        try {
            String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashAlmacenado = rs.getString("contraseña_hash");
                String hashIngresado = HexTransform.bytesToHex(MessageDigest.getInstance("MD5").digest(contraseña.getBytes("UTF-8")));

                if (hashAlmacenado.equals(hashIngresado)) {
                    actualizarUltimoAccesoCorrecto(rs.getInt("id"));
                    return new User(
                            rs.getInt("id"),
                            rs.getString("id_usuario"),
                            null, // No devolvemos la contraseña
                            null, // Hash no necesario
                            rs.getString("ultimo_acceso_correcto"),
                            rs.getString("ultimo_acceso_incorrecto"),
                            rs.getString("tipo_usuario"),
                            rs.getBoolean("activo")
                    );
                } else {
                    actualizarUltimoAccesoIncorrecto(rs.getInt("id"));
                    System.out.println("[ERROR]: Contraseña incorrecta");
                }
            } else {
                System.out.println("[ERROR]: Usuario no encontrado o inactivo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void actualizarUltimoAccesoCorrecto(int idUsuario) {
        try {
            String sql = "UPDATE usuarios SET ultimo_acceso_correcto = NOW() WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarUltimoAccesoIncorrecto(int idUsuario) {
        try {
            String sql = "UPDATE usuarios SET ultimo_acceso_incorrecto = NOW() WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

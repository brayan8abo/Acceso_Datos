package AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDeDatosSociosApp {
    public static void main(String[] args) {

        insertSQL();
        update();
        delete();

    }

    public static void insertSQL() {
        int puerto = 3306;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + puerto + "/club_socios", "root", "");

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");

                String query = "insert into socios (nombre,apellidos,dni,domicilio,localidad,tipo_socio,fecha_alta,fecha_baja,paga_ult_recibo,anotaciones)values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, "Brayan Stiven");
                preparedStatement.setString(2, "Ochoa");
                preparedStatement.setString(3, "Z0141021j");
                preparedStatement.setString(4, "Calle Pravia 8");
                preparedStatement.setString(5, "Madrid");
                preparedStatement.setString(6, "A");
                preparedStatement.setString(7, "2010-11-25");
                preparedStatement.setString(8, null);
                preparedStatement.setString(9, "S");
                preparedStatement.setString(10, "Se dio de baja:/");

                System.out.println("CONSULTA ====> " + preparedStatement.toString());
                int conteo = preparedStatement.executeUpdate();
                System.out.println("Se insertaron: " + conteo + " registros.");


            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosSociosApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(BaseDeDatosSociosApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void update() {

        int puerto = 3306;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + puerto + "/club_socios", "root", "");

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");

                String updateQuery = "UPDATE socios SET domicilio = ? WHERE id_socio = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
                preparedStatement.setString(1, "Dirección Correcta");
                preparedStatement.setInt(2, 1);


                System.out.println("CONSULTA ====> " + preparedStatement.toString());
                int conteo = preparedStatement.executeUpdate();
                System.out.println("Se actualizaron: " + conteo + " registros.");


            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosSociosApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BaseDeDatosSociosApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void delete() {
        int puerto = 3306;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + puerto + "/club_socios", "root", "");

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");

                String deleteQuery = "DELETE FROM socios WHERE id_socio =?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, 16);

                System.out.println("CONSULTA ====> " + preparedStatement.toString());
                int conteo = preparedStatement.executeUpdate();
                System.out.println("Se eliminó: " + conteo + " registro.");

            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatosSociosApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

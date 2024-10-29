package AccesoADatos;

import java.sql.*;


public class BaseDeDatos {
    public static void main(String[] args) {

        int puerto = 3306;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + puerto + "/club_socios", "root", "");

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");

                String query = "insert into socios (nombre,apellidos,dni,domicilio,localidad,tipo_socio,fecha_alta,fecha_baja,paga_ult_recibo,anotaciones)values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, "Brayan");
                preparedStatement.setString(2, "Ochoa");
                preparedStatement.setString(3, "z0141021j");
                preparedStatement.setString(4, "Calle 123, 456");
                preparedStatement.setString(5, "Madrid");
                preparedStatement.setString(6, "A");
                preparedStatement.setString(7, "2010-11-25");
                preparedStatement.setString(8, "2022-11-25");
                preparedStatement.setString(9, "S");
                preparedStatement.setString(10, "Se dio de baja:/");

                System.out.println("CONSULTA ====> " + preparedStatement.toString());
                int conteo = preparedStatement.executeUpdate();
                System.out.println("Se insertaron: " + conteo + " registros.");

                conn.close();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}

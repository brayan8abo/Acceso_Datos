package PrimeraClase;

import java.sql.*;
import java.util.Scanner;

public class AchivoSumaBD {

    // Configuración de la base de datos
    static final String dataBase = "jdbc:mysql://localhost:3306/calculadora";
    static final String user = "root";
    static final String pass = "";
    static Scanner leer = new Scanner(System.in);

    public static void sumar() {
        try (Connection conn = DriverManager.getConnection(dataBase, user, pass)) {
            System.out.println("Conexión a la base de datos establecida");

            // Consulta para obtener el valor actual
            String consulta = "SELECT numero FROM sumas WHERE id = ?"; // Cambia "suma" por tu tabla y asegúrate de que existe
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            int valorActual = 0;
            if (rs.next()) {
                valorActual = rs.getInt("valor");
            }

            // Pedimos el número al usuario y realizamos la suma
            System.out.println("Ingresa un número para sumar:");
            int numero = leer.nextInt();
            valorActual += numero;

            System.out.println("La suma total es: " + valorActual);

            // Actualizamos el valor en la base de datos
            String actualizacion = "UPDATE sumas SET numero = ? WHERE id = 1";
            PreparedStatement pstmt = conn.prepareStatement(actualizacion);
            pstmt.setInt(1, valorActual);
            pstmt.executeUpdate();
            System.out.println("Valor actualizado en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
        }
    }

    public static void guardar() {
        try (Connection conn = DriverManager.getConnection(dataBase, user, pass)) {
            System.out.println("Conexión a la base de datos establecida.");

            // Pedimos un número al usuario
            System.out.println("Ingresa un número para guardar en la base de datos:");
            int numero = leer.nextInt();

            // Actualizamos el valor directamente en la base de datos
            String consulta = "SELECT numero FROM sumas WHERE id = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            int valorActual = 0;
            if (rs.next()) {
                valorActual = rs.getInt("valor");
            }

            valorActual += numero;

            String actualizacion = "UPDATE sumas SET total = ? WHERE id =?";
            PreparedStatement pstmt = conn.prepareStatement(actualizacion);
            pstmt.setInt(1, valorActual);
            pstmt.executeUpdate();

            System.out.println("Nuevo valor guardado en la base de datos: " + valorActual);

        } catch (SQLException e) {
            System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        sumar();
        guardar();
        primeraPrueba.menu();
    }
}



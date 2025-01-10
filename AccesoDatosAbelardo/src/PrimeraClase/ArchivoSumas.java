package PrimeraClase;

import java.io.*;
import java.util.Scanner;

public class ArchivoSumas {

    // Ruta del archivo
    static File archivo = new File("suma.txt");
    static FileWriter escritor = null;
    static FileReader lector = null;
    static Scanner scanner = new Scanner(System.in);

    public static void sumar() {
        if (!archivo.exists()) {
            try {
                // Si el archivo no existe, lo creamos
                archivo.createNewFile();
                escritor = new FileWriter(archivo);
                escritor.write(0);
                escritor.close();
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }

        try {
            // Leemos el contenido actual del archivo
            lector = new FileReader(archivo);
            int contenidoArchivo = lector.read();
            System.out.println("Ingresa un número para sumar:");
            int numero = scanner.nextInt();
            contenidoArchivo += numero;
            System.out.println("La suma total del archivo es: " + contenidoArchivo);
            lector.close();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void guardar() {
        try {
            // Leemos el archivo
            lector = new FileReader(archivo);
            int contenidoArchivo = lector.read();
            System.out.println("Ingresa un número para guardar en el archivo:");
            int numero = scanner.nextInt();
            contenidoArchivo += numero;
            System.out.println("Nuevo valor en el archivo: " + contenidoArchivo);
            lector.close();

            // Escribimos el nuevo valor en el archivo
            escritor = new FileWriter(archivo);
            escritor.write(contenidoArchivo);
            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }
    }
}

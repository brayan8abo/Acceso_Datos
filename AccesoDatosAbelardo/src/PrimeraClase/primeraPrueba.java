package PrimeraClase;

import java.util.Scanner;

public class primeraPrueba {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }
    public static void menu() {

        int opcion = 0;
        do {
            System.out.println("1. Sumar\n2. Guardar en memoria\n3. Salir\n");
            System.out.println("Ingresa una de las opciones disponibles:");
            opcion = leer.nextInt();


            switch (opcion) {
                case 1:
                    ArchivoSumas.sumar();
                    break;
                case 2:
                    ArchivoSumas.guardar();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 3);
    }
}



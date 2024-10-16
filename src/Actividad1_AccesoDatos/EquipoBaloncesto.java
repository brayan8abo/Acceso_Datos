package Actividad1_AccesoDatos;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipoBaloncesto {
    /**
     * Realizar un programa en Java que permita gestionar los datosd e un equipo de baloncesto.
     * Crea un DAO y el correspondiente DTO. La aplicación contara con un menu para las siguientes opciones:
     * CRUD (Create, Read, Update, Delete),una opcion para generar un volcado de fichero CSV con los datos de los jugadores, y opcion para salir del programa.
     */
    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        Scanner leer = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador ;

        int opcion = 0;

        do {
            System.out.println("1. Insertar un nuevo jugador.\n2. Mostrar todos los jugadores.\n3. Buscar jugador por nombre.\n4. Eliminar jugador.\5. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Insertar nuevo jugador");
                    jugador=Metodos.insertarJugador();
                    jugadores.add(jugador);
                    //el metodo te devuelve un objeto jugador y luego lo añado a la lista vale, te enteras?
                    // NO!
                    break;
                case 2:
                    System.out.println("Mostrar todos los jugadores");
                    break;
                case 3:
                    System.out.println("Buscar jugador por nombre");
                    break;
                case 4:
                    System.out.println("Eliminar jugador");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;

            }
            leer.nextLine(); // Limpia el buffer de entrada para que el scanner no siga leyendo caracteres en la próxima iteración del bucle.
        } while (opcion != 5);
    }
}

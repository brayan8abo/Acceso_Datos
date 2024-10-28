package Actividad1_AccesoDatos;


import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EquipoBaloncesto {

    // Realizar un programa en java que permita gestionar los datos de un equipo de baloncesto.
    // Crea un DAO y el DTO correspondiente
    //La app contará con un menu para seleccionar la funcionalidad entre los casos de uso CRUD,
    // una opción para generar un volcado a
    //fichero CSV de los datos de los jugadores, y una opción para salir.

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {


        JugadorDAO.generarFicheroIDS();
        JugadorDAO.generarFicheroJugadores();
        ArrayList<JugadorDTO> arrayJugadores = JugadorDAO.meterJugadoresDesdeFicheroEnArrayList();
        Scanner sc = new Scanner(System.in);

        int op = -1;

        do {


            System.out.println("1. Dar de alta jugador\n2. Mostrar todos los jugadores\n3. Insertar jugadores desde fichero.\n4. Salir");
            System.out.println("Ingrese  opción deseada1: ");

            try {
                op = sc.nextInt();


                switch (op) {
                    case 1:
                        System.out.println("Insertar nuevo jugador");
                        JugadorDAO.crearJugador();
                        break;
                    case 2:
                        System.out.println("Mostrar todos los jugadores");
                        JugadorDAO.leerJugadoresFichero();
                        break;
                    case 3:
                        System.out.println("Buscar jugador por nombre");
                        arrayJugadores = JugadorDAO.meterJugadoresDesdeFicheroEnArrayList();
                        break;
                    case 4:
                        System.out.println("Eliminar jugador");
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion invalida");

                }
            } catch (InputMismatchException e) {
                System.out.println("opcion invalida");
                op = -1;
            } finally {
                sc.nextLine();


            }


        } while (op != 0);

    }
}
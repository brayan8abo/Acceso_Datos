package Actividad1_AccesoDatos;

import java.util.Scanner;

public class Metodos {


    public static Jugador insertarJugador() {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa el nombre del jugador");
        String nombre = leer.nextLine();
        System.out.println("Ingresa el apellido del jugador");
        String apellido = leer.nextLine();
        System.out.println("Ingresa el equipo al que pertenece el jugador");
        String equipo = leer.nextLine();
        System.out.println("Ingresa el número de camisa del jugador");
        int numeroCamisa = leer.nextInt();
        leer.nextLine(); // Limpia el buffer
        System.out.println("Ingresa la posición del jugador");
        String posicion = leer.nextLine();
        System.out.println("Ingresa el DNI del jugador");
        String dni = leer.nextLine();
        System.out.println("Esta activo el jugador? (true/false)");
        boolean activo = leer.nextBoolean();
        leer.nextLine(); // Limpia el buffer
        System.out.println("Ingresa la estatura del jugador");
        double estatura = leer.nextDouble();
        System.out.println("Ingresa el peso del jugador");
        double peso = leer.nextFloat();

        Jugador jugador = new Jugador(nombre, apellido, equipo, numeroCamisa, posicion, dni, activo, estatura, peso);
        return jugador;
    }
}

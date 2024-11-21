package Actividad1_AccesoDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorDAO {


    public static void crearJugador() {
        JugadorDTO jugador = null;
        Scanner leer = new Scanner(System.in);


        String nombre = "";
        String apellidos = "";
        int edad = 0;
        int dorsal = 0;
        String posicion = "";
        float estatura = 0;
        float peso = 0;
        boolean activo = true;


        System.out.println("Introduce el nombre del jugador");
        nombre = leer.nextLine();
        System.out.println("Introduce el apellido del jugador");
        apellidos = leer.nextLine();
        System.out.println("Introduce la edad del jugador:");
        edad = leer.nextInt();

        System.out.println("Introduce el dorsal del jugador:");
        dorsal = leer.nextInt();
        leer.nextLine();
        System.out.println("Introduce la posicion donde juega el jugador:");
        posicion = leer.nextLine();
        System.out.println("Introduce la estatura del jugador:");
        estatura = leer.nextFloat();
        System.out.println("Introduce el peso del jugador:");
        peso = leer.nextFloat();
        leer.nextLine();
        System.out.println("Introduce si el jugador esta activo: [TRUE / FALSE]");
        activo = leer.nextBoolean();
        leer.nextLine();
        int id = JugadorDAO.generarIDDesdeFichero();

        jugador = new JugadorDTO(id, nombre, apellidos, edad, dorsal, posicion, estatura, peso, activo);


        if (JugadorDAO.insertarJugadorFichero(jugador)) {

            System.out.println("Jugador insertado correctamente en el fichero : jugadores.csv");
        } else {
            System.out.println("OCURRIO UN PROBLEMA AL INSERTAR EL JUGADOR EN EL FICHERO : jugadores.csv");
        }


    }

    public static void generarFicheroJugadores() {

        FileWriter fw = null;
        try {
            File archivo = new File("jugadores.csv");
            if (!archivo.exists()) {

                fw = new FileWriter("jugadores.csv");
            } else {
                fw = new FileWriter("jugadores.csv", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void generarFicheroIDS() {

        FileWriter fw = null;
        try {
            File archivo = new File("IDS.txt");
            if (!archivo.exists()) {

                fw = new FileWriter("IDS.txt");
                fw.write(0 + "\n");
            } else {
                fw = new FileWriter("IDS.txt", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String generarStringJugador(JugadorDTO jugador) {

        String jugadorString = String.valueOf(jugador.getIdJugador());

        jugadorString += " " + jugador.getNombre();

        jugadorString += " " + jugador.getApellidos();

        jugadorString += " " + jugador.getEdad();

        jugadorString += " " + jugador.getDorsal();

        jugadorString += " " + jugador.getPosicion();

        jugadorString += " " + jugador.getEstatura();

        jugadorString += " " + jugador.getPeso();

        jugadorString += " 101010" + jugador.isActivo();

        return jugadorString;

    }

    public static boolean insertarJugadorFichero(JugadorDTO jugador) {
        FileWriter fw = null;
        boolean insertado = false;
        try {
            fw = new FileWriter("jugadores.csv", true);
            fw.write(JugadorDAO.generarStringJugador(jugador) + "\n");
            insertado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                insertado = false;
            }
        }

        return insertado;
    }

    public static int generarIDDesdeFichero() {
        int id;

        FileWriter fw = null;
        FileReader fr = null;
        try {

            fr = new FileReader("IDS.txt");
            BufferedReader br = new BufferedReader(fr);
            id = Integer.parseInt(br.readLine());
            id++;
            fw = new FileWriter("IDS.txt");
            fw.write(id + "\n");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;


    }

    public static void leerJugadoresFichero() {
        FileReader fr = null;
        try {
            fr = new FileReader("jugadores.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<JugadorDTO> meterJugadoresDesdeFicheroEnArrayList() {

        JugadorDTO jugador = null;
        ArrayList<JugadorDTO> arrayJugadores = new ArrayList<JugadorDTO>();
        FileReader fr = null;
        try {
            fr = new FileReader("jugadores.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split("\\*");


                jugador = new JugadorDTO(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), datos[5], Float.valueOf(datos[7]), Float.valueOf(datos[8]), Boolean.parseBoolean(datos[9]));

                System.out.println(jugador.toString());


                arrayJugadores.add(jugador);
                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("JUGADORES CARGADOS CORRECTAMENTE EN EL SISTEMA");
        return arrayJugadores;

    }

}
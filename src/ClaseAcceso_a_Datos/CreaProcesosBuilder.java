//package Acceso_Datos.src.ClaseAcceso_a_Datos;
//package ClaseAcceso_a_Datos;
import java.io.File;
import java.io.IOException;

public class CreaProcesosBuilder {
    public static void main(String[] args) {
//        ProcessBuilder builder = new ProcessBuilder("cmd /c dir");

//        String params[] = {"notepad.exe", "pruebas.txt"};

//        ProcessBuilder builder1 = new ProcessBuilder(params);
        ProcessBuilder builder1 = new ProcessBuilder("notepad.exe", "nota.txt");

        try {
//            for(int i = 0; i < 3; i++) {
            builder1.directory(new File("C:\\Users\\ALUMNO CCC - TARDE\\IdeaProjects\\Acceso_Datos"));
            Process processInit = builder1.start();

            int codeRetunr = processInit.waitFor();
            System.out.println("El proceso finalizó con codigo: " + codeRetunr);
//            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package ClaseAcceso_a_Datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreaProceso {
    public static void main(String[] args) {
        try {

            String[] parametros = {"cmd", "/c dir"};// nombre del archivo de notas que va aca?
//            Process process = Runtime.getRuntime().exec("notepad.exe notas.txt");//ejecuta notepadd, y se le pasa el nombre del archivo de notas
            Process process = Runtime.getRuntime().exec("cmd /c dir .");

            // leo la salida del proceso creado y muestro por pantalla
            BufferedReader breader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("SALIDA DEL SUB-PROCESO\n");

            String line;
            do {

                line = breader.readLine();
                System.out.println(line);
            } while (!breader.readLine().isEmpty());


//            process.destroy(); // Cierra el proceso hijo

            int retValue = process.waitFor();// INSTRUCCION BLOQUEANTE, no consume recursos del sistema operativo
            System.out.println("El proceso termino con código: " + retValue);
        } catch (IOException e) {
            Logger.getLogger(CreaProceso.class.getName()).log(Level.SEVERE, null, e);
        } catch (InterruptedException e) {
            Logger.getLogger(CreaProceso.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

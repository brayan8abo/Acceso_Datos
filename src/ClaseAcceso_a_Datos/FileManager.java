package ClaseAcceso_a_Datos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    public boolean copiaFicheros(String rutaOrigen, String rutaDestino) {
        /**
         * @rutaOrigen: Ruta del fichero origen
         * @rutaDestino: Ruta del fichero destino
         * return <true> si se ha copiado correctamente, <false> en caso contrario, o ocurriese algun error
         */

        /**
         * Crear objetos File para los ficheros origen y destino para realizar la copia
         */
        File archivoOrigen = new File(rutaOrigen);
        File archivoDestino = new File(rutaDestino);

        //Flujos de bites para la copia

        try {
            FileOutputStream fos = new FileOutputStream(archivoDestino); //el que envia los datos
            FileInputStream fis = new FileInputStream(archivoOrigen); // el que recibe los datos

            byte[] byteLeidos = fis.readAllBytes(); //Leer todos los bytes del fichero origen
            fos.write(byteLeidos); //Escribir los bytes leidos al fichero destino

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            // Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return false;

        } catch (IOException e) {
            // Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace(); // me imprime el volcado de pila, LOS ERRORES QUE SE PUEDEN ESTAR PRODUCIENDO EN EL CODIDO
            return false;
        }

        return true;
    }

}



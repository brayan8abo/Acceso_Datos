//package Acceso_Datos.src.ClaseAcceso_a_Datos;
package ClaseAcceso_a_Datos;

import java.io.FileWriter;
import java.io.IOException;

public class FileManagerCaracteres {

    public static void escribeMensajeFichero(String rutaFichero, String contenido) {

        FileWriter fw = null;
        try {
            fw = new FileWriter(rutaFichero);
            fw.write(contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


}

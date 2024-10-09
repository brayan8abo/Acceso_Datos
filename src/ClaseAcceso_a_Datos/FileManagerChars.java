package ClaseAcceso_a_Datos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManagerChars {

    public static void escribeMensajeFichero(String rutaFichero, String mensaje) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\ALUMNO CCC - TARDE\\IdeaProjects\\Acceso_Datos\\fcihero_ej.txt");
            fw.write(mensaje);
        } catch (IOException e) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
}

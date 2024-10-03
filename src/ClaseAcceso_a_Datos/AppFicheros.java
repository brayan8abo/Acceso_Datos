package ClaseAcceso_a_Datos;


import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.logging.Logger;

public class AppFicheros {
    public static void main(String[] args) throws IOException {

        File fichero = new File("fichero_ej.txt");
        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");

            try {
                //SI EL FICHERO NO EXISTE SE CREARA
                fichero.createNewFile();
            } catch (Exception e) {

            }
        }

        try {
            String canPath = fichero.getAbsolutePath();
            String path = fichero.getAbsolutePath();

            System.out.println("\t=== RUTAS DEL FICHERO ===");
            System.out.println(canPath + "\n"+ path);
        } catch (Exception e) {
            Logger.getLogger(AppFicheros.class.getName()).severe("Error: " + e.getMessage());

        }


    }
}

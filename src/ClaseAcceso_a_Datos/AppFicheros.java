package ClaseAcceso_a_Datos;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;

public class AppFicheros {

    public static void main(String[] args) {
        File fichero = new File("fichero_ej.txt");
        if (!fichero.exists()) {
            System.out.println("EL FICHERO NO EXISTE");
            try {
                //si el fichero no existe, lo creamos
                fichero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // CREACION DEL DIRECTORIO
        File directorio = new File("DIRECTORIO_PRUEBA");
        if (!directorio.exists()) {
            System.out.println("CREANDO DIR " + directorio.getAbsolutePath());
            if (!directorio.mkdir()) {
                System.err.println("FALLO LA CREACION DEL DIRECTORIO " + directorio.getAbsolutePath());
            } else {
                System.out.println("\t DIRECTORIO CREADO");
            }
        } else { // YA EXISTE
            // para ver la hora y fecha en la que se modifico

            long time_stamp = directorio.lastModified();
            Date date = new Date(time_stamp);
            String pattern = "MM-dd-yyyy HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            System.out.println("El directorio fue modificado por última vez: " + simpleDateFormat.format(date));
            //System.out.println("El directorio fue modificado por última vez: " + date);
        }

        //CONSULTO LA RUTA ABSOLUTA
        try {
            String canPath = fichero.getCanonicalPath();
            String path = fichero.getCanonicalPath();

            System.out.println("\t===== RUTAS DEL FICHERO =====");
            System.out.println(canPath + "\n" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //LISTAR EL CONTENIDO DE UN DIRECTORIO
        File fich = new File("C:\\Users\\ALUMNO CCC - TARDE\\IdeaProjects\\Acceso_Datos");


//            File[] directorios = fich.listFiles();
//            for (File f : directorios) {
//                System.out.println("directorio: " + f.getName());
//            }

        // optra forma de hacerlo
//        String [] nombres = fich.list();
//        for (String nombre : nombres){
//            System.out.println("directorio: " + nombre);  // split te devuelte un String de cadenas
//        }

        FileManager fm = new FileManager();

        System.out.println("INICIO COPIA DE ARCHIVO");
        String nombreArchivo = "el_quijote.txt";
        String nombreCopia = "el_quijote_copia.txt";
        if (fm.copiaFicheros(nombreArchivo, nombreCopia)) {
            File f = new File("BrayanCopia1.txt", "Stiven.txt");
            System.out.println("Archivo copiado a: " + f.getAbsolutePath());
        } else {
            System.out.println("Error al copiar el archivo");
        }
//        fm.copiaFicheros("brayan1.txt", "brayan1.json");
    }


}

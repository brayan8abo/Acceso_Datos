package ClaseAcceso_a_Datos;

import java.io.File;


    public class ListarDirectorio {
        public static void main(String[] args) {


            File directorio = new File("C:\\Users\\ALUMNO CCC - TARDE\\Documents");

            if (directorio.exists()){
                File [] archivos = directorio.listFiles();
                System.out.println("Directorios---");
                for (int i = 0; i < archivos.length; i++) {

                    System.out.println(archivos[i].getName());
                }


            }
            else {
                System.err.println("El directorio no existe");
            }


            //COPIAR FICHEROS


            FileManager fileManager = new FileManager();
            fileManager.copiaFicheros("brayan.txt", "brayan_copia.txt");




        }
    }

package Acceso_Datos.src.Entidades;

import java.io.*;
import java.util.ArrayList;

public class FileManager2 {
    public void guardarProductos(String ruta, ArrayList<Producto> productoArrayList) {
//        public void guardarProductos(String ruta, Producto p)

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(ruta));

//            oos.writeObject(p);
            oos.writeObject(productoArrayList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Accedo al fichero cuya ruta es indicada anteriormente (por parametros) y devuelvo un objeto de tipo <Producto>
     *
     * @param ruta
     * @return
     */
//    public Producto cargaProductos(String ruta) {
    public ArrayList<Producto> cargaProductos(String ruta) {
        ArrayList<Producto> productos = null;
        ObjectInputStream ois = null; //entrada del fichero
//        Producto p = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(ruta));

//            p = (Producto) ois.readObject(); //leo el objeto del fichero

            productos = (ArrayList<Producto>) ois.readObject(); //leo el objeto del fichero
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productos; //devuelvo el objeto leido del fichero

//        return p;
    }

}
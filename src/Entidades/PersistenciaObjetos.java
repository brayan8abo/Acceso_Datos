//package Acceso_Datos.src.Entidades;

//package Entidades;
import java.util.ArrayList;

public class PersistenciaObjetos {
    public static void main(String[] args) {

        String ruta = "productos.dat";

        FileManager2 fm = new FileManager2();
        Producto p1 = new Producto(1, 1, "PISTOLA", "DELICUENCIA", "Tipo 1", 10, 10.0f, true);
        Producto p2 = new Producto(2, 2, "cuchillo", "matar", "Tipo 1", 10, 10.0f, true);
//        fm.guardarProdcutos(ruta, p);

        ArrayList<Producto> productsArrays = new ArrayList<Producto>();
        productsArrays.add(p1);
        productsArrays.add(p2);

        fm.guardarProductos(ruta, productsArrays);


//        Producto p = fm.cargaProductos(ruta); //mostrar los datos del producto que se ha cargado (para probar la persistencia en disco físico, es necesario tener el fichero en la misma car)

        productsArrays = fm.cargaProductos(ruta);

        for (int i = 0; i < productsArrays.size(); i++) {
            System.out.println(productsArrays.get(i).toString());
        } //mostrar los datos del producto que se ha cargado (para probar la persistencia en disco físico, es necesario tener el fichero en la misma)


        System.out.println("El Producto cargado es: " + p1);
        System.out.println("El Producto cargado es: " + p2);

    }
}

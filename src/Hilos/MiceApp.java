package Hilos;

public class MiceApp {
    public static void main(String[] args) {
        //instancia de la clase Mouse, y lanzamos la ejecución del hilo asociado

        Mouse mickey = new Mouse();
        Mouse minnie = new Mouse();
        mickey.setName("Mickey");
        minnie.setName("Minnie");
        mickey.start();//lanzamos el hilo de mickey para que comience a correr
        minnie.start();
    }

}

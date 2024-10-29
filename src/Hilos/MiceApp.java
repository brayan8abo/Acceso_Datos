package Hilos;

public class MiceApp {
    public static void main(String[] args) {

        //instancia de la clase Mouse, y lanzamos la ejecución del hilo asociado
        Mouse mickey = new Mouse();
        Mouse minnie = new Mouse();
        mickey.setName("Mickey");
        minnie.setName("Minnie");

        //lanzamos el hilo de mickey para que comience a correr
        mickey.start();
        minnie.start();

        try {
            System.out.println("Espero a que termine MICKEY");
            mickey.join(); // hace que espere y deja bloqueado al padre hasta que MICKEY termine
            System.out.println("Soy el creador y MICKEY terminó!");

            if (minnie.isAlive()) {
                System.out.println("Minnie sigue ejecuntándose...");
            } else {
                System.out.println("Minnie terminó!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

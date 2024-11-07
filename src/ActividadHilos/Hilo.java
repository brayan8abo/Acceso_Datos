package ActividadHilos;

import java.util.Random;

public class Hilo implements Runnable {


    private static boolean arrayFinished[];
    //private static int numHilos;


    public Hilo(int numHilos) {
        if (arrayFinished == null) {
            System.out.println("SOY EL CONSTRUCTOR - SOLO ME EJECUTARÉ UNA VEZ");
            arrayFinished = new boolean[numHilos];


            //inicializa a false los elementos del array
            for (int i = 0; i < numHilos; i++) {
                arrayFinished[i] = false;
            }
        }

    }

    public static boolean[] getArrayFinished() {
        return arrayFinished;
    }

    @Override
    public void run() {
        String id = Thread.currentThread().getName();
        System.out.println("Hilo: [" + id + "] ===> Voy a dormir...");
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 3 * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo: [" + id + "] ===> Ha dormido...");


        //publico anuncio que he terminado
        arrayFinished[Integer.parseInt(id)] = true;
    }
}

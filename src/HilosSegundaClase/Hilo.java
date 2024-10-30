package HilosSegundaClase;

import java.util.Random;

public class Hilo implements Runnable {

    @Override
    public void run() {
        System.out.println("Soy el hilo: " + Thread.currentThread().getId());

    }
}

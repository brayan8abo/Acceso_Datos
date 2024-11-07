package HilosSegundaClase;

import java.util.Random;

public class Hilo implements Runnable {

    @Override
    public void run() {
        System.out.println("Soy el hilo: " + Thread.currentThread().getId());

    }

    public boolean isFinished() {
        Random random = new Random();
        return random.nextBoolean();
        // Devuelve un valor aleatorio (true o false) para simular que el hilo ha terminado
    }
}

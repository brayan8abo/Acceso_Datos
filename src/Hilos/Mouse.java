package Hilos;

import java.util.Random;

public class Mouse extends Thread {//hace uso de la case Thread para crear un hilo

    @Override
    public void run() {//metodo principal del hilo, que esta sobreescrito en la clase Thread, metodo mas importante del hilo

        Random random = new Random();
//        this.comer(random.nextInt(5) * 1000);

        this.comer(random.nextInt(5000)); //me devuleve un número aleatorio entre 0 y 4999


    }

    /*
     * Este método simula la acción de comer en un hilo, pausando el hilo durante el tiempo especificado en ms (milisegundos)
     * @param ms tiempo en milisegundos que el hilo va a estar pausado
     * @see Thread#sleep(long)
     * @see Thread#currentThread()
     */
    public void comer(long ms) {//

        String nameThread = Thread.currentThread().getName();//obtiene el nombre del hilo o el id

        System.out.println("Soy " + nameThread + " y voy a comer durante " + ms + " milisegundos...  :)  ");

        try {
            Thread.sleep(ms); //pausa el hilo durante el tiempo especificado en ms (milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(nameThread + ", Terminó de comer!");
    }

}
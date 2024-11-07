package ActividadHilos;

import HilosSegundaClase.Hilo;

public class HiloPadre {

    /*/
    Implementar un programa donde tengamos 5 hilos, donde se ejecute y el padre espere que se
    ejecuten los hijos, y guardar en un arraylist de booleans y luego verificar que todos han terminado y crear un metodo anuncion fin comprobando el arraylist

     */

    private int NUM_HILOS = 5;

    public static void main(String[] args) {
        HiloPadre hiloPadre = new HiloPadre();
        hiloPadre.start();

    }

    private void start() {

                // Creo los hilos
        Hilo[] hijos = new Hilo[NUM_HILOS];
        for (int i = 0; i < NUM_HILOS; i++) {
            hijos[i] = new Hilo(i);
            hijos[i].start();
        }

        // Espero que todos los hilos terminen
        for (int i = 0; i < NUM_HILOS; i++) {
            try {
                hijos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verifico que todos los hilos hayan terminado
        boolean todosTerminaron = true;
        for (Hilo hilo : hijos) {
            if (!hilo.isFinished()) {
                todosTerminaron = false;
                break;
            }
        }   // for

        // Anuncio que todos los hilos han terminado
        if (todosTerminaron) {
            System.out.println("Todos los hilos han terminado.");
        } else {
            System.out.println("Algun hilo no ha terminado.");
        }
    }
}



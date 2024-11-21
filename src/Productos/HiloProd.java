/*package Productos;

import java.util.Random;

public class HiloProd extends Thread {
    public HiloProd() {

    }

    public void run() {
        ListaEnteros listaEnteros = ProdConsExample.getListaEnteros();
        int[] arrayEnteros = listaEnteros.getArray();
        ListaEnteros monitor = ProdConsExample.getMonitor();

        boolean primeraVez = true;

        for (; ; ) {

            if (!primeraVez) {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            } else {
                primeraVez = false;
            }
            if (listaEnteros.tam < ListaEntero.MAX_TAM) {
                arrayEnteros {
                    listaEnteros.tam] =80;
                    listaEnteros.tam++;

                    System.out.println("Añado un elemento");
                    ProdConsExample.mostrarListaEnteros();

                }

                try {
                    int milisecs = Math.abs(new Random().nextInt(1500));
                    System.out.println("Milisec que dormiras: " + milisecs);

                    sleep(milisecs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (listaEnteros) {
                listaEnteros.notify();
            }
        }
    }
}
*/
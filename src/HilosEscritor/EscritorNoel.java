package HilosEscritor;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EscritorNoel implements Runnable {

    /**
     * Los hilos que se instancien a partir de esta clase
     * escribiran en un fichero llamado libro.txt, 50 veces cada hilo.
     * <p>
     * Cada vez que se ejecute un hilo escribira una linea con el siguiente formato:
     * [yyyy-mm-dd hh:mm:ss] Soy el hilo { nombreDelHilo}
     * <p>
     * fw.flush() para forzar la escritura de los datos.
     *
     * @author Noel
     */

    private String nombreDelHilo;

    public void Escritor(String nombreDelHilo) {
        this.nombreDelHilo = nombreDelHilo;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            this.escribir();
            // escribir(true);
        }
    }

    private void escribir() {
        FileWriter fw = null;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(now);
        try {
            fw = new FileWriter("libro.txt", true);
            fw.write("[" + date + "] Soy el hilo " + this.nombreDelHilo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void escribir(boolean dormir) {
        FileWriter fw = null;
        Random random = new Random();
        long ms = random.nextInt(1000);

        if (dormir) {


            try {
                fw = new FileWriter("libro.txt", true);
                fw.write("[" + new java.util.Date() + "] Soy el hilo " + this.nombreDelHilo + "\n");

                try {
                    Thread.sleep(ms);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

package ActividadHilos;

public class AnuncioFin {
    public static void main(String[] args) {

        int numHilos = 6;

        Thread arrayHilos[] = new Thread[numHilos];


        for (int i = 0; i < 6; i++) {
            Hilo hilo = new Hilo(numHilos);
            arrayHilos[i] = new Thread(hilo);
            arrayHilos[i].setName("" + i);
            arrayHilos[i].start();
        }

        boolean[] arrayFinished = Hilo.getArrayFinished();
        boolean todosTerminaron = false;
        int countFinish = 0;
        while (countFinish < 6) {
            for (int i = 0; i < 6; i++) {
                if (arrayFinished[i] == false) {
//                    break;
                } else {
                    countFinish++;
                    todosTerminaron = true;
                }
            }
            if (countFinish == 6) {
                break;

            }
        }
        countFinish = 0;
        System.out.println("terminaron todos los hilos");
    }
}

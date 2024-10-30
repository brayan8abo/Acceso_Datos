package HilosSegundaClase;

public class HilosApp2 {
    public static void main(String[] args) {

        Hilo arrayHilos[] = new Hilo[3];//creo un array de 3 hilos
//        String listaCalificacions [] = new String[60]; //creo un array de 60 calificaciones
//        double listaCalific [] = new double[60]; //creo un array de 60 calificaciones


        for (int i = 0; i < arrayHilos.length; i++) {
            arrayHilos[i] = new Hilo();//instacio el array de hilos
            new Thread(arrayHilos[i]).start();  //lanzo el hilo
        }


    }
}

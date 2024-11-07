package HilosEscritor;

public class EscritorAPP {
    public static void main(String[] args) {
        //crear 5 hilos y lanzarlos

        Thread[] arrayHilos = new Thread[5];
        for (Thread numeroHilos : arrayHilos) {
            numeroHilos = new Thread(new Escritor());
            numeroHilos.start();

        }


//        Escritor escritor = new Escritor("archivo.txt");
//        escritor.run();

    }
}


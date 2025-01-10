package HilosExamen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new Thread(new HiloMostrarCero());
        Thread h2 = new Thread(new HiloMostrarUno());


        System.out.println(h1.getName()+
                "\n" +h2.getName());
        h1.start();


    }

}

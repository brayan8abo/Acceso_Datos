package ActividadJoyeria;

public class Joyeria {
    private static final int MAX_BLUE = 210;
    private static final int MAX_WHT = 180;

    //se declaran con valores diferentes para que salte la excepcion, ya que anteriormente teniamos 210 azules y 180 blancas, ahora asi da error por que no se alcanzan a coger todas la perlas suficientes
//	private static final int MAX_BLUE = 40;
//	private static final int MAX_WHT = 30;

    public static void main(String[] args) {
        // inicializar los cestos con suficientes perlas
        Cesto cestoBlanco = new Cesto(MAX_WHT);
        Cesto cestoAzul = new Cesto(MAX_BLUE);

        // crear collares con un bucle que se instancia en 20 indices
        Collar[] collares = new Collar[20];
        for (int i = 0; i < collares.length; i++) {
            collares[i] = new Collar();
        }

        // crear y arrancar empleados, tambien se instancian 5 indices de empleados
        Empleado[] empleados = new Empleado[5];
        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Empleado(cestoBlanco, cestoAzul, collares[i]);
            empleados[i].start();
        }

        // esperar a que todos los hilos terminen
        for (Empleado empleado : empleados) {
            try {
                // espera a que el hilo termine, con el join esperamos que se ejecute y luego empiece el otro hilo para su ejecución
                empleado.join();
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido: " + e.getMessage());
            }
        }

// contador para tener una cuenta de collares terminados
        int collaresCompletos = 0;
        for (Collar completados : collares) {
            if (completados.estaCompleto()) {
                collaresCompletos++;
            }
        }

        // imprimir resultados de los collares ya terminados
        System.out.println("Número de collares fabricados: " + collaresCompletos);
    }
}

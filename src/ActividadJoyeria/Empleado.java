package ActividadJoyeria;

public class Empleado extends Thread {

    private Cesto cesto;;
    private Collar collar;

    public Empleado(Cesto cestoBlanco, Cesto cestoAzul, Collar collar) {
        this.cesto = cestoBlanco;
        this.collar = collar;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Verificar si ya no hay más perlas en ambos cestos
                if (!cesto.isMaterialsLeft()) {
                    System.out.println(Thread.currentThread().getName() + " [ERROR]: No hay más perlas para seguir ensamblando el collar.");
                    break; // Sale del bucle while si no hay más materiales
                }

                // Bucle para insertar perlas en el collar (máximo 20 por collar)
                for (int i = 0; i < 20; i++) {
                    if (!cesto.isMaterialsLeft()) {
                        System.out.println(Thread.currentThread().getName() + " [ERROR]: No hay suficientes perlas para completar el collar.");
                        break; // Sale del bucle for si no hay más perlas
                    }

                    Perla  perlas = cesto.cogerPerla("Azul");
                    Perla  perlas2 = cesto.cogerPerla("Blanca");




                    // Insertar perlas en el collar
                    collar.insertarPerla(cesto.cogerPerla("Blanco").getColor());
                    collar.insertarPerla(cesto.cogerPerla("Azul").getColor());

                }

                // Informar que se ha completado el collar
                System.out.println("Collar completo ensamblado por " + Thread.currentThread().getName());
            }
        } catch (NoMaterialsLeft e) {
            System.err.println(e.getMessage());
        }
    }
}


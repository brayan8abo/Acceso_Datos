package ActividadPerlas;

import java.util.ArrayList;

public class Joyería {
    public static void main(String[] args) {
        Cesto cesto = new Cesto(Cesto.MAX_WHT, Cesto.MAX_BLUE);
        ArrayList<Collar> collaresFabricados = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();

        for (int i = 0; i < 5; i++) {//iniciamos 5 hilos
            Empleado empleado = new Empleado(cesto, collaresFabricados);
            empleados.add(empleado);
            empleado.start();
        }

        while (true) {
            boolean terminado = true;
            for (Empleado empleado : empleados) {
                if (empleado.isAlive()) {
                    terminado = false;
                    break;
                }
            }
            if (terminado) break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir resultados
        System.out.println("Los collares que se fabricaron fueron: " + collaresFabricados.size());
    }
}

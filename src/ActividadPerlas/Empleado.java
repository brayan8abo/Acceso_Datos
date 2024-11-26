package ActividadPerlas;

import java.util.ArrayList;


public class Empleado extends Thread {
    private final Cesto cesto;
    private final ArrayList<Collar> collaresListos;

    public Empleado(Cesto cesto, ArrayList<Collar> collaresFabricados) {
        this.cesto = cesto;
        this.collaresListos = collaresFabricados;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Collar collar = new Collar();
                for (int i = 0; i < Collar.MAX_PERLAS; i++) {
                    String color = (i % 2 == 0) ? "blanco" : "azul";
                    Perla perla = cesto.recuperarPerla(color);
                    collar.ponerPerla(perla);
                }
                synchronized (collaresListos) {
                    collaresListos.add(collar);
                }
            }
        } catch (NoMaterialsLeft e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


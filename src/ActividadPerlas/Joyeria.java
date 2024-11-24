package ActividadPerlas;

public class Joyeria {
	private static final int MAX_BLUE = 210;
	private static final int MAX_WHT = 180;

	public static void main(String[] args) {
		Cesto cestoBlanco = new Cesto(MAX_WHT);
		Cesto cestoAzul = new Cesto(MAX_BLUE);

		Collar[] collares = new Collar[5];
		for (int i = 0; i < collares.length; i++) {
			collares[i] = new Collar();
		}

		Empleado[] empleados = new Empleado[5];
		for (int i = 0; i < empleados.length; i++) {
			empleados[i] = new Empleado(cestoBlanco, cestoAzul, collares[i]);
		}

		for (Empleado empleado : empleados) {
			empleado.start();
		}

		while (true) {
			boolean todosTerminados = true;
			for (Empleado empleado : empleados) {
				if (empleado.isAlive()) {
					todosTerminados = false;
					break;
				}
			}

			if (todosTerminados) {
				break;
			}

			try {
				Thread.sleep(1000); // Espera de 1 segundo entre comprobaciones
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int collaresCompletos = 0;
		for (Collar collar : collares) {
			if (collar.estaCompleto()) {
				collaresCompletos++;
			}
		}

		System.out.println("Número total de collares completos fabricados: " + collaresCompletos);
	}
}

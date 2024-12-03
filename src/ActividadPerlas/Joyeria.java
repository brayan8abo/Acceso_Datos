package ActividadPerlas;

public class Joyeria {
	private static final int MAX_BLUE = 210;
	private static final int MAX_WHT = 180;

		public static void main(String[] args) {
			// Inicializar los cestos
			Cesto cestoBlanco = new Cesto(MAX_WHT);
			Cesto cestoAzul = new Cesto(MAX_BLUE);

			// Crear collares
			Collar[] collares = new Collar[5];
			for (int i = 0; i < collares.length; i++) {
				collares[i] = new Collar();
			}

			// Crear y arrancar empleados
			Empleado[] empleados = new Empleado[5];
			for (int i = 0; i < empleados.length; i++) {
				empleados[i] = new Empleado(cestoBlanco, cestoAzul, collares[i]);
				empleados[i].start(); // Inicia el hilo del empleado
			}

			// Esperar a que todos los hilos terminen
			for (Empleado empleado : empleados) {
				try {
					empleado.join(); // Bloquea hasta que el hilo termine
				} catch (InterruptedException e) {
					System.err.println("Hilo interrumpido: " + e.getMessage());
				}
			}

			// Contar collares completos
			int collaresCompletos = 0;
			for (Collar collar : collares) {
				if (collar.estaCompleto()) {
					collaresCompletos++;
				}
			}

			// Imprimir resultados
			System.out.println("Número total de collares completos fabricados: " + collaresCompletos);
		}
	}


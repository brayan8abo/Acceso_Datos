package ActividadPerlas;

public class Joyeria {
//	private static final int MAX_BLUE = 210;
//	private static final int MAX_WHT = 180;

	private static final int MAX_BLUE = 40;
	private static final int MAX_WHT = 30;


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

			// esperar a que todos los hilos terminen
			for (Empleado empleado : empleados) {
				try {
					// espera a que el hilo termine
					empleado.join();

				} catch (InterruptedException e) {
					System.err.println("Hilo interrumpido: " + e.getMessage());
				}
			}

			// contador para tener una cuenta de collares terminados
			int collaresCompletos = 0;
			for (Collar collar : collares) {
				if (collar.estaCompleto()) {
					collaresCompletos++;
				}
			}

			// imprimir resultados de los collares ya terminados
			System.out.println("Número de collares fabricados: " + collaresCompletos);
		}
	}


package ActividadPerlas;

public class Collar {
	private final int capacidad = 20;
	private int perlasInsertadas = 0;

	public synchronized void insertarPerla(String color) throws NoMaterialsLeft {
		if (perlasInsertadas >= capacidad) {
			throw new NoMaterialsLeft("No se pueden añadir más perlas al collar, ya está completo.");
		}
		perlasInsertadas++;
		System.out.println("Se insertó una perla de color " + color + " en el collar. Total: " + perlasInsertadas);
	}

	public synchronized boolean estaCompleto() {
		return perlasInsertadas == capacidad;
	}
}



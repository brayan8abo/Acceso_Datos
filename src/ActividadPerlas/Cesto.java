package ActividadPerlas;

import java.util.concurrent.atomic.AtomicInteger;

public class Cesto {
	private int perlas; // Reemplaza AtomicInteger por int

	public Cesto(int cantidadInicial) {
		this.perlas = cantidadInicial;
	}

	public synchronized Perla cogerPerla(String color) throws NoMaterialsLeft {
		if (!isMaterialsLeft()) {
			throw new NoMaterialsLeft("Se acabaron las perlas de color " + color);
		}
		perlas--; // Decrementar el contador de forma segura
		return new Perla(color);
	}

	public synchronized boolean isMaterialsLeft() {
		return perlas > 0; // Comprobar si quedan perlas
	}
}



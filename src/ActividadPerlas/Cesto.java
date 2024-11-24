package ActividadPerlas;

import java.util.concurrent.atomic.AtomicInteger;

public class Cesto {
	private final AtomicInteger perlas;

	public Cesto(int cantidadInicial) {
		this.perlas = new AtomicInteger(cantidadInicial);
	}

	public synchronized Perla cogerPerla(String color) throws NoMaterialsLeft {
		if (!isMaterialsLeft()) {
			throw new NoMaterialsLeft("Se acabaron las perlas de color " + color);
		}
		perlas.decrementAndGet();
		return new Perla(color);
	}

	public boolean isMaterialsLeft() {
		return perlas.get() > 0;
	}
}


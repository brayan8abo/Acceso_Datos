package ActividadPerlas;

import java.util.ArrayList;
import java.util.List;

public class Collar {
	private final ArrayList<Perla> perlas = new ArrayList<>();
	public static final int MAX_PERLAS = 20;

	public synchronized void ponerPerla(Perla perla) throws Exception {
		if (perlas.size() < MAX_PERLAS) {
			perlas.add(perla);
		} else {
			throw new Exception("El collar ya está completo");
		}
	}

	public boolean isCompleto() {
		return perlas.size() == MAX_PERLAS;
	}
}

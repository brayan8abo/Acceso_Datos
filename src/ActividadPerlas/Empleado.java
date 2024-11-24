package ActividadPerlas;

public class Empleado implements Runnable {
	private final Cesto cestoBlanco;
	private final Cesto cestoAzul;
	private final Collar collar;

	public Empleado(Cesto cestoBlanco, Cesto cestoAzul, Collar collar) {
		this.cestoBlanco = cestoBlanco;
		this.cestoAzul = cestoAzul;
		this.collar = collar;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) { // 10 perlas de cada color para un collar mixto
				collar.insertarPerla(cestoBlanco.cogerPerla("Blanco").getColor());
				collar.insertarPerla(cestoAzul.cogerPerla("Azul").getColor());
			}
			System.out.println("Collar completo ensamblado por " + Thread.currentThread().getName());
		} catch (NoMaterialsLeft e) {
			System.err.println(e.getMessage());
		}
	}

	public void start() {
	}

	public boolean isAlive() {
		return false;
	}
}

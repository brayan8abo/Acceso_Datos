package ActividadJoyeria;

public class Empleado extends Thread {

	private  Cesto cestoBlanco;
	private  Cesto cestoAzul;
	private  Collar collar;

	public Empleado(Cesto cestoBlanco, Cesto cestoAzul, Collar collar) {
		this.cestoBlanco = cestoBlanco;
		this.cestoAzul = cestoAzul;
		this.collar = collar;
	}

	@Override
	public void run() {
		try {
			//bucle para recorrer el las perlas que usa un collar mixto de perlas (azul y blancas)
			for (int i = 0; i < 20; i++) {
				collar.insertarPerla(cestoBlanco.cogerPerla("Blanco").getColor());
				collar.insertarPerla(cestoAzul.cogerPerla("Azul").getColor());
			}
			//recuperamos el nombre del hilo que termino un collar
			System.out.println("Collar completo ensamblado por " + Thread.currentThread().getName());
		} catch (NoMaterialsLeft e) {
			System.err.println(e.getMessage());
		}
	}
}


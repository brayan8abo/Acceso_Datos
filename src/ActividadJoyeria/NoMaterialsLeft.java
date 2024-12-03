package ActividadJoyeria;

// excepcion que recibe como mensaje el que se le esta dando en el throws
	class NoMaterialsLeft extends Exception {
		public NoMaterialsLeft(String mensaje) {
			super(mensaje);
		}
	}

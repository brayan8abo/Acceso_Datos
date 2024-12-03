package ActividadPerlas;

public class Collar {
//	private final int capacidad = 20;
	private int perlasInsertadas = 0;

	//probamos con otro valor de capacidad para comprobar la excepcion
	private final int capacidad = 10;

	public synchronized void insertarPerla(String color) throws NoMaterialsLeft {
		if (perlasInsertadas >= capacidad) {
			throw new NoMaterialsLeft("[ERROR]: No se pueden añadir más perlas al collar");
		}
		perlasInsertadas++;
		//System.out.println("Se puso una perla de color: " + color + " en el collar\n. Total de perlas puestas: " + perlasInsertadas\n);
	}

	public synchronized boolean estaCompleto() {
		return perlasInsertadas == capacidad;
	}
}



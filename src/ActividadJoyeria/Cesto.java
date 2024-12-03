package ActividadJoyeria;

public class Cesto {
	private int perlas;

	public Cesto(int cantidadInicial) {
		this.perlas = cantidadInicial;
	}

	//metodo sincronizado que devuelve una perla y va restado a la cantidad de perlas que tenemos dispobles
	public synchronized Perla cogerPerla(String color) throws NoMaterialsLeft {
		if (!isMaterialsLeft()) {
			throw new NoMaterialsLeft("Se acabaron las perlas de color " + color);
		}
		//vamos restando las perlas
		perlas--;
		return new Perla(color);
	}
//metodo para comprobar si quedan mas perlas en los cestos
	public synchronized boolean isMaterialsLeft() {
		return perlas > 0;

	}
}



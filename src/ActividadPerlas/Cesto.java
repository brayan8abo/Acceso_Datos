package ActividadPerlas;

public class Cesto {
    private int perlasBlancas;
    private int perlasAzules;

    public static final int MAX_BLUE = 210;
    public static final int MAX_WHT = 180;

    public Cesto(int perlasBlancas, int perlasAzules) {
        this.perlasBlancas = perlasBlancas;
        this.perlasAzules = perlasAzules;
    }

    public synchronized Perla recuperarPerla(String color) throws NoMaterialsLeft {
        if (color.equals("blanco") && perlasBlancas > 0) {
            perlasBlancas--;
            return new Perla("blanco");
        } else if (color.equals("azul") && perlasAzules > 0) {
            perlasAzules--;
            return new Perla("azul");
        } else {
            throw new NoMaterialsLeft("Ya no quedan más perlas de: " + color);
        }
    }

    public synchronized boolean isMaterialsLeft() {
        return perlasBlancas > 0 || perlasAzules > 0;
    }
}




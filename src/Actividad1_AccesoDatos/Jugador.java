package Actividad1_AccesoDatos;

public class Jugador {
    String nombre;
    String apellido;
    String equipo;
    int numeroCamisa;
    String posicion;
    String DNI;
    boolean activo;
    double estatura;
    double peso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    // Constructor

    public Jugador(String nombre, String apellido, String equipo, int numeroCamisa, String posicion, String DNI, boolean activo, double estatura, float peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
        this.numeroCamisa = numeroCamisa;
        this.posicion = posicion;
        this.DNI = DNI;
        this.activo = activo;
        this.estatura = estatura;
        this.peso = peso;
    }


    public Jugador(String nombre, String apellido, String equipo, int numeroCamisa, String posicion, String dni, boolean activo, double estatura, double peso) {
        this.nombre = "Prueba";
        this.apellido = "A Prueba";
        this.equipo = "E Prueba";
        this.numeroCamisa = 0;
        this.posicion = "P prueba";
        this.DNI = "DNI prueba";
        this.activo = true;
        this.estatura = 1.95;
        this.peso = 115;
    }

    // toString
    @Override
    public String toString() {
        return "Jugador: " + " nombre: " + nombre + ", apellido: " + apellido + ", equipo: " + equipo + ", numeroCamisa: " + numeroCamisa + ", posicion: " + posicion + ", DNI: " + DNI + ", activo: " + activo + ", estatura: " + estatura + ", peso: " + peso + '}';
    }

}

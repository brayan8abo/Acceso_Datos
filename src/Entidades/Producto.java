//package Acceso_Datos.src.Entidades;

//package Entidades;
import java.io.Serializable;

public class Producto implements Serializable {
    private int cod;
    private int codFabricante;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int unidadesStock;
    private float precioSIVA;
    private boolean visibleWeb;


    public Producto(int cod, int codFabricante, String nombre, String descripcion, String tipo, int unidadesStock, float precioSIVA, boolean visibleWeb) {
        this.cod = cod;
        this.codFabricante = codFabricante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.unidadesStock = unidadesStock;
        this.precioSIVA = precioSIVA;
        this.visibleWeb = visibleWeb;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodFabricante() {
        return codFabricante;
    }

    public void setCodFabricante(int codFabricante) {
        this.codFabricante = codFabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUnidadesStock() {
        return unidadesStock;
    }

    public void setUnidadesStock(int unidadesStock) {
        this.unidadesStock = unidadesStock;
    }

    public float getPrecioSIVA() {
        return precioSIVA;
    }

    public void setPrecioSIVA(float precioSIVA) {
        this.precioSIVA = precioSIVA;
    }

    public boolean isVisibleWeb() {
        return visibleWeb;
    }

    public void setVisibleWeb(boolean visibleWeb) {
        this.visibleWeb = visibleWeb;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cod=" + cod +
                ", codFabricante=" + codFabricante +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", unidadesStock=" + unidadesStock +
                ", precioSIVA=" + precioSIVA +
                ", visibleWeb=" + visibleWeb +
                '}';
    }
}

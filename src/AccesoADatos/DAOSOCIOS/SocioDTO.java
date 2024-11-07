package AccesoADatos.DAOSOCIOS;

import java.util.Arrays;

public class SocioDTO {

    private long id_socio;
    private String nombre;
    private String apellidos;
    private String dni;
    private String domicilio;
    private String localidad;
    private char tipo_socio;
    private String fecha_alta;
    private String fecha_baja;
    private String paga_ult_recibo;
    private byte[] anotaciones;

    // getters and setters


    public long getId_socio() {
        return id_socio;
    }

    public void setId_socio(long id_socio) {
        this.id_socio = id_socio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public char getTipo_socio() {
        return tipo_socio;
    }

    public void setTipo_socio(char tipo_socio) {
        this.tipo_socio = tipo_socio;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getPaga_ult_recibo() {
        return paga_ult_recibo;
    }

    public void setPaga_ult_recibo(String paga_ult_recibo) {
        this.paga_ult_recibo = paga_ult_recibo;
    }

    public byte[] getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(byte[] anotaciones) {
        this.anotaciones = anotaciones;
    }

    @Override
    public String toString() {
        return "SocioDTO{" +
                "id_socio=" + id_socio +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", localidad='" + localidad + '\'' +
                ", tipo_socio=" + tipo_socio +
                ", fecha_alta='" + fecha_alta + '\'' +
                ", fecha_baja='" + fecha_baja + '\'' +
                ", paga_ult_recibo='" + paga_ult_recibo + '\'' +
                ", anotaciones=" + Arrays.toString(anotaciones) +
                '}';
    }
}

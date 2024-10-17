//package Acceso_Datos.src.ClaseAcceso_a_Datos;
//package ClaseAcceso_a_Datos;

import java.io.IOException;

public class ApagarPc {
    public static void main(String[] args) {
        try {
            String command = "shutdown -s -t 0";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

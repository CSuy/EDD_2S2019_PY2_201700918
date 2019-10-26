package edd_proyecto2;

import java.util.Base64;


public class EDD_Proyecto2 {
    
    public static void main(String[] args) {
        System.out.println("Prueba de base64");
        String cadena = "ESTRUCTURA DE DATOS SECCION A 0919";
        String encoder = Base64.getEncoder().encodeToString(cadena.getBytes());
        System.out.println("Este es el resultado del encoder: " + encoder);
        byte[] encode_base64 = Base64.getDecoder().decode(encoder);
        String cadena1 = new String(encode_base64);
        System.out.println("Esto es el contenido de encoder: " + cadena1);
    }
    
}

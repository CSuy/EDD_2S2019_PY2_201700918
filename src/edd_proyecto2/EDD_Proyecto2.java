package edd_proyecto2;

import Aplicacion.Inicio_Sesion;
import Estructuras.TablaHash;
import java.security.NoSuchAlgorithmException;
import static java.time.Clock.system;
import java.util.Base64;
import java.util.Scanner;


public class EDD_Proyecto2 {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /*System.out.println("Prueba de base64");
        String cadena = "ESTRUCTURA DE DATOS SECCION A 0919";
        String encoder = Base64.getEncoder().encodeToString(cadena.getBytes());
        System.out.println("Este es el resultado del encoder: " + encoder);
        byte[] encode_base64 = Base64.getDecoder().decode(encoder);
        String cadena1 = new String(encode_base64);
        System.out.println("Esto es el contenido de encoder: " + cadena1);
        String cadena2 = "\"{\"INDEX\": 2, \"TIMESTAMP\": \"02-10-19-::14:30:25\", \"CLASS\": \"Estructuras de datos\", \"DATA\": \"{\"value\":\"201403525-Nery\",\"left\":{\"value\":\"201212963-Andres\",\"left\":{\"value\":\"201005874-Estudiante1\",\"left\":null,\"right\":null},\"right\":{\"value\":\"201313526-Alan\",\"left\":null,\"right\":null}},\"right\":{\"value\":\"201403819-Anne\",\"left\":{\"value\":\"201403624-Fernando\",\"left\":null,\"right\":null},\"right\":{\"value\":\"201602255-Estudiante2\",\"left\":null,\"right\":null}}}\", \"PREVIOUSHASH\": \"fd5f6d5fdfdf232Y232312QW12196255\", \"HASH\": \"55904c5f612680c8a13b86dde7e64b96d5643afb65ae2a27d54b76c9f03a93ec\"}" ;
        SHA256 sha = new SHA256();
        String prueba = sha.toHexString(sha.getSHA(cadena2));
        System.out.println("El Hash es: " + prueba);
        System.out.println(cadena2);*/
        /*Inicio_Sesion i = new Inicio_Sesion();
        i.setVisible(true);*/
        TablaHash t = new TablaHash();
        Scanner n = new Scanner(System.in);
        Scanner n1 = new Scanner(System.in);
        boolean menu = true;
        while (menu == true) {
            System.out.println("Elija 1, 2 o 3");
            int j = n.nextInt();
            switch (j) {
                case 1:
                    System.out.println("Ingrese usuario");
                    String usuario = n1.nextLine();
                    t.Insertar(usuario, "123");
                    System.out.println("La Capacidad es: " +  t.getCapacidad());
                    break;
                case 2:
                    t.imprimir();
                    break;
                case 3:
                    t.Insertar("nombre2", "123");
                    System.out.println(t.getCapacidad());
                    break;
                default:
                    menu = false;
                    break;
            }
        }
        
    }
    
}

package edd_proyecto2;

import Aplicacion.Inicio_Sesion;
import Estructuras.ArbolAVL;
import Estructuras.ArbolAVL1;
import Estructuras.Matriz;
import Estructuras.Pila;
import Estructuras.TablaHash;
import Nodos.Nodo_Hash;
import java.security.NoSuchAlgorithmException;
import static java.time.Clock.system;
import java.util.Base64;
import java.util.Scanner;


public class EDD_Proyecto2 {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Inicio_Sesion i = new Inicio_Sesion();
        i.setVisible(true);
        /*se pudo hacer*/
        /*Matriz a = new Matriz();
        Scanner n = new Scanner(System.in);
        Scanner n1 = new Scanner(System.in);
        Scanner n2 = new Scanner(System.in);
        String carpeta_actual ="";
        String carpeta_nueva = "";
        a.crear_Raiz();
        boolean menu = true;
        while (menu == true) {
            System.out.println("Elija 1, 2 o 3");
            int j = n.nextInt();
            switch (j) {
                case 1:
                    System.out.println("Carpeta Actual");
                    carpeta_actual = n1.nextLine();
                    System.out.println("Nueva Carpeta");
                    carpeta_nueva = n2.nextLine();
                    a.Insertar(carpeta_actual, carpeta_nueva);
                    break;
                case 2:
                    a.Graficar("user1");
                    break;
                case 3:
                    a.Graficar_Grafo("user1");
                    break;
                case 4:
                    
                    break;
                default:
                    menu = false;
                    break;
            }
        }*/
        /*ArbolAVL a = new ArbolAVL(); 
        Scanner n = new Scanner(System.in);
        Scanner n1 = new Scanner(System.in);
        Scanner n2 = new Scanner(System.in);
        boolean menu = true;
        int contador = 10;
        String nombre = "archivo";
        while (menu == true) {
            System.out.println("Elija 1, 2 o 3");
            int j = n.nextInt();
            switch (j) {
                case 1:
                    System.out.println("Se ingreso un archivo al arbol");
                    a.Insertar(nombre+contador, "xD", "hoy", "user1");
                    contador++;
                    break;
                case 2:
                    System.out.println("Generando grafica");
                    a.Graficar("user1");
                    break;
                case 3:
                    System.out.println("ingresa un nombre");
                    String o = n1.nextLine();
                    a.Insertar(o, "xD", "hoy", "user1");
                    System.out.println("Se ingreso un archivo al arbol");
                    break;
                case 4:
                    System.out.println("Escriba el nodo que desea eliminar");
                    String w = n2.nextLine();
                    a.Eliminar(w);
                    break;
                default:
                    menu = false;
                    break;
            }
        }*/
        /*TablaHash t = new TablaHash();
        Scanner n = new Scanner(System.in);
        Scanner n1 = new Scanner(System.in);
        Scanner n2 = new Scanner(System.in);
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
                    System.out.println("Escriba el nombre que va a buscar");
                    String user = n2.nextLine();
                    Nodo_Hash us = t.Buscar(user);
                    if(us != null){
                        System.out.println("Se encontro el usuario: " + us.getUsuario());
                    }else{
                        System.out.println("No Existe el usuario");
                    }
                    break;
                case 4:
                    t.Graficar();
                    break;
                default:
                    menu = false;
                    break;
            }
        }*/
        
    }
    
}

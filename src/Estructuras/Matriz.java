/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.Nodo_Matriz;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author MiriamLeticia
 */
public class Matriz {
    private Nodo_Matriz raiz;
    
    public Matriz(){
        this.raiz = null;
    }
    
    private void insertarC(String nombre, String ruta1){
        Nodo_Matriz aux = this.raiz;
        int contador = 1;
        while(aux.getSiguiente()!=null){
            aux = aux.getSiguiente();
            contador++;
        }
        Nodo_Matriz nuevo = new Nodo_Matriz(nombre,contador,0,ruta1);
        aux.setSiguiente(nuevo);
    }
    
    private void insertarF(String nombre, String ruta1){
        Nodo_Matriz aux = this.raiz;
        int contador = 1;
        while(aux.getAbajo()!=null){
            aux = aux.getAbajo();
            contador++;
        }
        Nodo_Matriz nuevo = new Nodo_Matriz(nombre,0,contador,ruta1);
        aux.setAbajo(nuevo);
    }
    
    public void crear_Raiz(){
        Nodo_Matriz nuevo = new Nodo_Matriz("",0,0,"");
        this.raiz = nuevo;
        Carpeta_Raiz();
    }
    
    private void Carpeta_Raiz(){
        insertarF("/","");
        insertarC("/","");
    }
    
    public void Insertar(String nombre, String C_nueva){
        String raices = "raiz" + nombre;
        String [] datos = raices.split("/");
            String Carpeta_Padre="";
            String carpeta_padre1 = "";
            if(nombre.equals("/")){
                Carpeta_Padre = "/" ;
            }else{
                Carpeta_Padre = datos[datos.length-1];
                if(datos.length == 2){
                    carpeta_padre1 = "/";
                }else{
                    for (int i = 1; i < datos.length - 1 ; i++) {
                        carpeta_padre1 += "/" + datos[i];
                    }
                }
            }
            insertarF(C_nueva,nombre);
            insertarC(C_nueva,nombre);
        if(Carpeta_Padre.equals("/")){
            int x = enX(C_nueva,nombre);
            int y = enY("/","");
            Nodo_Matriz nuevo = new Nodo_Matriz("/" + C_nueva,x,y,nombre);
            InsertarFila(nuevo);
            InsertarColumna(nuevo);
        }else{
            int x = enX(C_nueva,nombre);
            int y = enY(Carpeta_Padre,carpeta_padre1);
            Nodo_Matriz nuevo = new Nodo_Matriz(Carpeta_Padre + "/" + C_nueva,x,y,nombre);
            InsertarFila(nuevo);
            InsertarColumna(nuevo);
        }
        
    }
    
    private void InsertarFila(Nodo_Matriz nuevo){
        Nodo_Matriz aux = this.raiz;
        Nodo_Matriz x = aux;
        int x1 = nuevo.getX();
        while(aux!=null){
            if(aux.getY() == nuevo.getY()){
                while(aux.getSiguiente()!= null){
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
                break;
            }
            aux = aux.getAbajo();
        }
    }
    
    private void InsertarColumna(Nodo_Matriz nuevo){
        Nodo_Matriz aux = this.raiz;
        Nodo_Matriz x = aux;
        while(true){
            if(aux.getX() == nuevo.getX()){
                while(aux.getSiguiente()!= null){
                    aux = aux.getAbajo();
                }
                aux.setAbajo(nuevo);
                break;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public int enX(String nombre, String ruta){
        int contador=0;
        Nodo_Matriz aux = this.raiz;
        while(aux!=null){
            if(aux.getNombre().equals(nombre) && aux.getRutaDeAcceso().equals(ruta)){
                contador = aux.getX();
            }
            aux= aux.getSiguiente();
        }
        return contador;
    }
    
    public int enY(String nombre, String ruta){
        int contador=0;
        Nodo_Matriz aux = this.raiz;
        while(aux!=null){
            if(aux.getNombre().equals(nombre) && aux.getRutaDeAcceso().equals(ruta)){
                contador = aux.getY();
            }
            aux= aux.getAbajo();
        }
        return contador;
    }
    
    public void Graficar(String user){
        try{
            String ruta = "Reportes/Matriz.dot";
            String archivo = "Matriz_" + user + ".jpg";
            String contenido = "digraph guia{ \n node[shape=box] \n rankdir=UD; \n {rank=min; \n";
            contenido += grafica1();
            contenido += "} \n";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            try{
                String cmd = "dot -Tjpg " + ruta + " -o " + "Reportes/" + archivo;
                try {
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException ex) {
                    System.out.println("No se genero a imagen");
                }
            }catch(Exception e){
                System.out.println("No se genero a imagen");
            }
        }catch(IOException x){
            System.out.println("Se produjo un error con el archivo dot");
        }
    }
    
    private String grafica1(){
        String contenido = "";
        Nodo_Matriz aux1 = this.raiz;
        Nodo_Matriz auxC = this.raiz;
        Nodo_Matriz auxF = this.raiz;
        while(auxC!=null){
                contenido += "nodo" + auxC.getX() + auxC.getY() + "[label=\"" + auxC.getNombre() + "\" ,rankdir=LR, group=" + auxC.getX() +"]; \n";
                auxC = auxC.getSiguiente();
            }
        contenido += "} \n";
            while(auxF!=null){
                auxC = auxF;
                contenido += "{rank=same; \n";
                while(auxC!=null){
                    contenido += "nodo" + auxC.getX() + auxC.getY() + "[label=\" " + auxC.getNombre() + "\" , group=" + auxC.getX() +"]; \n";
                    auxC = auxC.getSiguiente();
                }
                contenido += "} \n";
                auxF = auxF.getAbajo();
            }
            auxF = aux1;
            while(auxF!=null){
                auxC = auxF;
                while(auxC.getSiguiente()!=null){
                    contenido += "nodo" + auxC.getX() + auxC.getY() + " -> nodo" + auxC.getSiguiente().getX() + auxC.getSiguiente().getY() + "[dir=both]; \n";
                    auxC = auxC.getSiguiente();
                }
                auxF = auxF.getAbajo();
            }
            auxF = aux1;
            while(auxF!=null){
                auxC = auxF;
                while(auxC.getAbajo()!=null){
                    contenido += "nodo" + auxC.getX() + auxC.getY() + " -> nodo" + auxC.getAbajo().getX() + auxC.getAbajo().getY() + "[dir=both]; \n";
                    auxC = auxC.getAbajo();
                }
                auxF = auxF.getSiguiente();
            }
        return contenido;
    }
    
}

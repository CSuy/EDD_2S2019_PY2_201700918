package Estructuras;

import Nodos.Nodo_Pila;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MiriamLeticia
 */
public class Pila {
    private Nodo_Pila cima;
    private int tam;

    public Pila() {
        this.cima = null;
        this.tam = 0;
    }
    
    public void insertarPila(String razon, String timestap, String user){
        Nodo_Pila nuevo = new Nodo_Pila(razon, timestap, user);
        if(cima == null){
            cima = nuevo;
            tam++;
        }else{
            nuevo.setSiguiente(cima);
            cima = nuevo;
            tam++;
        }
    }
    
    public void graficar(String user){
        try{
            String ruta = "Reportes/bitacora_cambios.dot";
            String archivo = "Bitacora_" + user + ".jpg";
            String contenido = "digraph guia{ \n";
            contenido += "tbl [\n";
            contenido += "shape=plaintext\n";
            contenido += "label=<\n";
            contenido += "<table border='0' cellborder='1' color='blue' cellspacing='0'>\n";
            contenido += "<tr><td></td></tr> \n";
            contenido += Grafica();
            contenido += "\n</table>\n";
            contenido += ">];\n";
            contenido += "}";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            try{
                String cmd = "dot -Tjpg " + ruta + " -o " + "Reportes/"+archivo;
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
    
    private String Grafica(){
        String cuerpo = "";
        Nodo_Pila aux = this.cima;
        int contador = 1;
        while(contador <= tam){
            contador++;
            cuerpo += "<tr><td>" + "Razon:" + aux.getRazon() + " Fecha:" + aux.getFecha() + " Usuario:" + aux.getUsuario() + "</td></tr> \n";
            aux = aux.getSiguiente();
        }
        return cuerpo;
    }

    public Nodo_Pila getCima() {
        return cima;
    }

    public void setCima(Nodo_Pila cima) {
        this.cima = cima;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    
}

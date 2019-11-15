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
    public Nodo_Pila cima;
    public int tam;

    public Pila() {
        this.cima = null;
        this.tam = 0;
    }
    
    public boolean estaVacia(){
        if(cima==null){
            return true;
        }
        return false;
    }
    
    public void insertarPila(String razon, String timestap, String user){
        Nodo_Pila nuevo = new Nodo_Pila(razon, timestap, user);
        if(estaVacia()){
            this.cima = nuevo;
            this.tam ++;
        }else{
            Nodo_Pila aux = cima;
            this.cima = nuevo;
            nuevo.setSiguiente(aux);
            this.tam ++;
        }
    }
    
    public void graficar(){
        try{
            String ruta = "Reportes/bitacora_cambios.dot";
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
                String cmd = "dot -Tjpg " + ruta + " -o " + "Reportes/Bitacora.jpg";
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
        while(contador<tam){
            contador++;
            cuerpo += "<tr><td>" + "Razon:" + aux.getRazon() + " Fecha:" + aux.getFecha() + " Usuario:" + aux.getUsuario() + "</td></tr> \n";
            aux = aux.getSiguiente();
        }
        return cuerpo;
    }
}

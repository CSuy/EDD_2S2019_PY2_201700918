/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.Nodo_AVL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MiriamLeticia
 */
public class ArbolAVL1 {
    private Nodo_AVL root;
    
    public ArbolAVL1(){
        this.root = null;
    }
    
    private int altura(Nodo_AVL raiz){
        int h = 0;
        if(raiz != null){
            int izquierdo = altura(raiz.getIzquierdo());
            int derecho = altura(raiz.getDerecho());
            int max_height = Math.max(izquierdo, izquierdo);
            h = max_height + 1;
        }
        return h;
    }
    
    private int diferencia(Nodo_AVL raiz){
        int l_height = altura(raiz.getIzquierdo());
        int r_height = altura(raiz.getDerecho());
        int b_factor = l_height - r_height;
        if(raiz.getIzquierdo()!= null){
            raiz.getIzquierdo().setAltura(l_height);
        }
        if(raiz.getDerecho() != null){
            raiz.getDerecho().setAltura(r_height);
        }
        return b_factor;
    }
    
    private Nodo_AVL rotacionRR(Nodo_AVL raiz){
        Nodo_AVL aux;
        aux = raiz.getDerecho();
        raiz.setDerecho(aux.getIzquierdo());
        aux.setIzquierdo(raiz);
        System.out.println("Right-Right Rotation");
        return aux;
    }
    
    private Nodo_AVL rotacionLL(Nodo_AVL raiz){
        Nodo_AVL aux;
        aux = raiz.getIzquierdo();
        raiz.setIzquierdo(aux.getDerecho());
        aux.setDerecho(raiz);
        System.out.println("Left-Left Rotation");
        return aux;
    }
    
    private Nodo_AVL rotacionLR(Nodo_AVL raiz){
        Nodo_AVL aux;
        aux = raiz.getIzquierdo();
        raiz.setIzquierdo(rotacionRR(aux));
        System.out.println("Left-Right Rotation");
        return rotacionLL(raiz);
    }
    
    private Nodo_AVL rotacionRL(Nodo_AVL raiz){
        Nodo_AVL aux;
        aux = raiz.getDerecho();
        raiz.setDerecho(rotacionLL(aux));
        System.out.println("Right-Left Rotation");
        return rotacionRR(raiz);
    }
    
    public Nodo_AVL balancear(Nodo_AVL nodo){
        int bal_factor = diferencia(nodo);
        if (bal_factor > 1) {
           if (diferencia(nodo.getIzquierdo()) > 0)
              nodo = rotacionLL(nodo);
           else
              nodo = rotacionLR(nodo);
        } else if (bal_factor < -1) {
           if (diferencia(nodo.getDerecho()) > 0)
              nodo = rotacionRL(nodo);
           else
              nodo= rotacionRR(nodo);
        }
        nodo.setFactor_Equilibrio(bal_factor);
        return nodo;
    }
    
    public Nodo_AVL Insertar(String nombre_archivo, String contenido, String creacion, String propietario){
        Nodo_AVL aux = Insertar_AVL(root,nombre_archivo, contenido, creacion, propietario);
        this.root = aux;
        return this.root;
    }   

    public ArbolAVL1(Nodo_AVL root) {
        this.root = root;
    }

    private Nodo_AVL Insertar_AVL(Nodo_AVL raiz, String nombre_archivo, String contenido, String creacion, String propietario) {
        if(raiz == null){
            raiz = new Nodo_AVL(nombre_archivo, contenido, creacion, propietario);
        }else{
            String nombre1 = nombre_archivo;
            String nombre2 = raiz.getNombre_Archivo();
            int comparador = nombre1.compareTo(nombre2);
            if( comparador < 0){
                Nodo_AVL aux1 = Insertar_AVL(raiz.getIzquierdo(),nombre_archivo, contenido, creacion, propietario);
                raiz.setIzquierdo(aux1);
                balancear(raiz);
            }else{
                Nodo_AVL aux2 = Insertar_AVL(raiz.getDerecho(),nombre_archivo, contenido, creacion, propietario);
                raiz.setDerecho(aux2);
                balancear(raiz);
            }
        }
        return raiz;
    }
    
    public void Graficar(String user){
        Nodo_AVL aux = root;
        String archivo = "ArbolAVL_" + user + ".jpg";
        try{
            String ruta = "Reportes/Arbol_AVL.dot";
            String contenido = "digraph guia{ \n";
            contenido +="node [shape = record, style=filled, fillcolor=seashell2];\n";
            contenido += graficar1(aux);
            contenido += "\n}";
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
        }catch(IOException ex){
            System.out.println("Se produjo un error con el archivo .dot");
        }
    }
    
    private String graficar1(Nodo_AVL raiz){
        String cuerpo="";
        if(raiz != null){
            cuerpo += "\"";
            cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
            cuerpo += "\n Contenido:" + raiz.getContenido();
            cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
            cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
            cuerpo += "\n Creacion:" + raiz.getCreacion();
            cuerpo += "\n Propietario:" + raiz.getUsuario();
            cuerpo += "\"";
            cuerpo += "; \n";
            if(raiz.getIzquierdo() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar1(raiz.getIzquierdo());
            }
            if(raiz.getDerecho() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar1(raiz.getDerecho());
            }
        }
        return cuerpo;
    }

    public Nodo_AVL getRoot() {
        return root;
    }

    public void setRoot(Nodo_AVL root) {
        this.root = root;
    }
    
    
}

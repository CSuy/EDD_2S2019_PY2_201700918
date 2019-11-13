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
public class ArbolAVL {
    private Nodo_AVL root;
    
    public ArbolAVL(){
        this.root = null;
    }
    
    private boolean vacia(){
        return this.root == null;
    }
    
    private int Altura(Nodo_AVL raiz){
        if(raiz == null){
            return 0;
        }
        return raiz.getAltura();
    }
    
    private int Factor_Equilibrio(Nodo_AVL raiz){
        if(raiz == null){
            return 0;
        }
        return Altura(raiz.getIzquierdo()) - Altura(raiz.getDerecho());
    }
    
    private Nodo_AVL rotacionI(Nodo_AVL raiz){
        Nodo_AVL y = raiz.getDerecho();
        Nodo_AVL x = y.getIzquierdo();
        y.setIzquierdo(raiz);
        raiz.setDerecho(x);
        int altura1 = 1 + Math.max(Altura(raiz.getIzquierdo()), Altura(raiz.getDerecho()));
        int altura2 = 1 + Math.max(Altura(y.getIzquierdo()), Altura(y.getDerecho()));
        raiz.setAltura(altura1);
        y.setAltura(altura2);
        int balanceo1 = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo1);
        int balanceo2 = Factor_Equilibrio(y);
        y.setFactor_Equilibrio(balanceo2);
        return y;
    }
    
    private Nodo_AVL rotacionD(Nodo_AVL raiz){
        Nodo_AVL y = raiz.getIzquierdo();
        Nodo_AVL x = y.getDerecho();
        y.setDerecho(raiz);
        raiz.setIzquierdo(x);
        int altura1 = 1 + Math.max(Altura(raiz.getIzquierdo()), Altura(raiz.getDerecho()));
        int altura2 = 1 + Math.max(Altura(y.getIzquierdo()), Altura(y.getDerecho()));
        raiz.setAltura(altura1);
        y.setAltura(altura2);
        int balanceo1 = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo1);
        int balanceo2 = Factor_Equilibrio(y);
        y.setFactor_Equilibrio(balanceo2);
        return y;
    }
    
    public void Insertar(String nombre_archivo, String contenido, String creacion, String propietario){
        Nodo_AVL aux = Insertar_AVL(root,nombre_archivo, contenido, creacion, propietario);
        this.root = aux;
    }
    
    private Nodo_AVL Insertar_AVL(Nodo_AVL raiz, String nombre_archivo, String contenido, String creacion, String propietario){
        if(raiz == null){
            raiz = new Nodo_AVL(nombre_archivo, contenido, creacion, propietario);
        }else{
            String nombre1 = nombre_archivo;
            String nombre2 = raiz.getNombre_Archivo();
            int comparador = nombre1.compareTo(nombre2);
            if( comparador < 0){
                Nodo_AVL aux1 = Insertar_AVL(raiz.getIzquierdo(),nombre_archivo, contenido, creacion, propietario);
                raiz.setIzquierdo(aux1);
            }else{
                Nodo_AVL aux2 = Insertar_AVL(raiz.getDerecho(),nombre_archivo, contenido, creacion, propietario);
                raiz.setDerecho(aux2);
            }
        }
        int balanceo = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo);
        //Casos de Rotacion para AVL
        //Caso 1:
        if(balanceo > 1 && nombre_archivo.compareTo(raiz.getIzquierdo().getContenido()) == -1){
            return rotacionD(raiz);
        }
        if(balanceo < -1 && nombre_archivo.compareTo(raiz.getIzquierdo().getContenido()) == 1){
            return rotacionI(raiz);
        }
        if(balanceo > 1 && nombre_archivo.compareTo(raiz.getIzquierdo().getContenido()) == 1){
            Nodo_AVL aux = rotacionI(raiz.getIzquierdo());
            raiz.setIzquierdo(aux);
            return rotacionD(raiz);
        }
        if(balanceo < -1 && nombre_archivo.compareTo(raiz.getDerecho().getContenido()) == -1){
            Nodo_AVL aux1 = rotacionD(raiz.getDerecho());
            raiz.setDerecho(aux1);
            return rotacionI(raiz);
        }
        return raiz;
    }
    
    public void Graficar(String user){
        Nodo_AVL aux = root;
        String archivo = "ArbolAVL_" + user + ".jpg";
        try{
            String ruta = "Reportes/Arbol_AVL.dot";
            String contenido = "digraph guia{ \n";
            contenido +="node [shape = record];\n";
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
            cuerpo += "Nombre Archivo: " + raiz.getNombre_Archivo();
            cuerpo += "\n Contenido: " + raiz.getContenido();
            cuerpo +=  "\n FE: " + raiz.getFactor_Equilibrio();
            cuerpo += "\n Altura: " + (raiz.getAltura() - 1);
            cuerpo += "\n Creacion: " + raiz.getCreacion();
            cuerpo += "\n Propietario: " + raiz.getUsuario();
            cuerpo += "\"";
            cuerpo += ";";
            if(raiz.getIzquierdo() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo: " + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido: " + raiz.getContenido();
                cuerpo +=  "\n FE: " + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura: " + raiz.getAltura();
                cuerpo += "\n Creacion: " + raiz.getCreacion();
                cuerpo += "\n Propietario: " + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar1(raiz.getIzquierdo());
            }
            if(raiz.getDerecho() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo: " + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido: " + raiz.getContenido();
                cuerpo +=  "\n FE: " + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura: " + raiz.getAltura();
                cuerpo += "\n Creacion: " + raiz.getCreacion();
                cuerpo += "\n Propietario: " + raiz.getUsuario();
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

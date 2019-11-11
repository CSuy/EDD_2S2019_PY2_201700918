/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author MiriamLeticia
 */
public class Nodo_AVL {
    private Nodo_AVL Izquierdo;
    private Nodo_AVL Derecho;
    private String Nombre_Archivo;
    private String Contenido;
    private int Factor_Equilibrio;
    private int Altura;
    private String Creacion;
    private String Usuario;

    public Nodo_AVL(String Nombre_Archivo, String Contenido, String Creacion, String Usuario) {
        this.Nombre_Archivo = Nombre_Archivo;
        this.Contenido = Contenido;
        this.Factor_Equilibrio = 0;
        this.Altura = 1;
        this.Creacion = Creacion;
        this.Usuario = Usuario;
        this.Derecho = null;
        this.Izquierdo = null;
    }


    public Nodo_AVL getIzquierdo() {
        return Izquierdo;
    }

    public void setIzquierdo(Nodo_AVL Izquierdo) {
        this.Izquierdo = Izquierdo;
    }

    public Nodo_AVL getDerecho() {
        return Derecho;
    }

    public void setDerecho(Nodo_AVL Derecho) {
        this.Derecho = Derecho;
    }

    public String getNombre_Archivo() {
        return Nombre_Archivo;
    }

    public void setNombre_Archivo(String Nombre_Archivo) {
        this.Nombre_Archivo = Nombre_Archivo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public int getFactor_Equilibrio() {
        return Factor_Equilibrio;
    }

    public void setFactor_Equilibrio(int Factor_Equilibrio) {
        this.Factor_Equilibrio = Factor_Equilibrio;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int Altura) {
        this.Altura = Altura;
    }

    public String getCreacion() {
        return Creacion;
    }

    public void setCreacion(String Creacion) {
        this.Creacion = Creacion;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    
    
    
}

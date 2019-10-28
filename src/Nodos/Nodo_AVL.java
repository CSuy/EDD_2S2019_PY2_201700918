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
    private String Dato;

    public Nodo_AVL(String Dato) {
        this.Dato = Dato;
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

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }
    
    
}

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
public class Nodo_Matriz {
    private Nodo_Matriz siguiente;
    private Nodo_Matriz abajo;
    private String nombre;
    private int X;
    private int Y;

    public Nodo_Matriz(String nombre, int x, int y) {
        this.nombre = nombre;
        this.siguiente = null;
        this.abajo = null;
        this.X = x;
        this.Y = y;
    }

    public Nodo_Matriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_Matriz siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo_Matriz getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo_Matriz abajo) {
        this.abajo = abajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
    
    
}

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
public class Nodo_Hash {
    private Nodo_Hash Abajo;
    private int Indice;
    private String Contraseña;
    private String Usuario;

    public Nodo_Hash(int Indice, String Contraseña, String Usuario) {
        this.Abajo = null;
        this.Indice = Indice;
        this.Contraseña = Contraseña;
        this.Usuario = Usuario;
    }

    public Nodo_Hash getAbajo() {
        return Abajo;
    }

    public void setAbajo(Nodo_Hash Abajo) {
        this.Abajo = Abajo;
    }

    public int getIndice() {
        return Indice;
    }

    public void setIndice(int Indice) {
        this.Indice = Indice;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
}

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
    private String Usuario;
    private String Contraseña;

    public Nodo_Hash(String Usuario, String Contraseña) {
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }


    public Nodo_Hash getAbajo() {
        return Abajo;
    }

    public void setAbajo(Nodo_Hash Abajo) {
        this.Abajo = Abajo;
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

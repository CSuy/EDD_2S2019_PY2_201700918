/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.Nodo_AVL;

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
    
    public void Insertar(String nombre_archivo, String contenido, String creacion, String propietario){
        Nodo_AVL nuevo = new Nodo_AVL(nombre_archivo, contenido, creacion, propietario);
        Insertar_AVL(nuevo,root);
    }
    
    private void Insertar_AVL(Nodo_AVL nuevo, Nodo_AVL raiz){
        if(vacia() == true){
            raiz = nuevo;
            
        }
    }
    
    

    public Nodo_AVL getRoot() {
        return root;
    }

    public void setRoot(Nodo_AVL root) {
        this.root = root;
    }
    
    
    
}

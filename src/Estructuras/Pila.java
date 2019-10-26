package Estructuras;

import Nodos.Nodo_Pila;

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
    
    public void insertarPila(int valor){
        Nodo_Pila nuevo = new Nodo_Pila(valor);
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
        Grafica(this.cima);
    }
    
    private void Grafica(Nodo_Pila cima1){
        
    }
}

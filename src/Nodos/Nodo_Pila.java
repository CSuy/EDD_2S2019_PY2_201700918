package Nodos;

/**
 *
 * @author MiriamLeticia
 */
public class Nodo_Pila {
    private Nodo_Pila siguiente;
    private int valor;

    public Nodo_Pila(int valor) {
        this.siguiente = null;
        this.valor = valor;
    }

    public Nodo_Pila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_Pila siguiente) {
        this.siguiente = siguiente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}

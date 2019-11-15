package Nodos;

/**
 *
 * @author MiriamLeticia
 */
public class Nodo_Pila {
    private Nodo_Pila siguiente;
    private String razon;
    private String fecha;
    private String usuario;

    public Nodo_Pila(String razon, String fecha, String usuario) {
        this.razon = razon;
        this.fecha = fecha;
        this.usuario = usuario;
        this.siguiente = null;
    }

    public Nodo_Pila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_Pila siguiente) {
        this.siguiente = siguiente;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}

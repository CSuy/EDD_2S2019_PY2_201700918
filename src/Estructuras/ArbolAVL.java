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
    private int inten = 1;
    
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
        int allt = 1 + Math.max(Altura(raiz.getIzquierdo()), Altura(raiz.getDerecho()));
        raiz.setAltura(allt);
        int balanceo = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo);
        int allt1 = 1 + Math.max(Altura(y.getIzquierdo()), Altura(y.getDerecho()));
        y.setAltura(allt1);
        int balanceo1 = Factor_Equilibrio(y);
        y.setFactor_Equilibrio(balanceo1);
        return y;
    }
    
    private Nodo_AVL rotacionD(Nodo_AVL raiz){
        Nodo_AVL y = raiz.getIzquierdo();
        Nodo_AVL x = y.getDerecho();
        y.setDerecho(raiz);
        raiz.setIzquierdo(x);
        int allt = 1 + Math.max(Altura(raiz.getIzquierdo()), Altura(raiz.getDerecho()));
        raiz.setAltura(allt);
        int balanceo = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo);
        int allt1 = 1 + Math.max(Altura(y.getIzquierdo()), Altura(y.getDerecho()));
        y.setAltura(allt1);
        int balanceo1 = Factor_Equilibrio(y);
        y.setFactor_Equilibrio(balanceo1);
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
            //int comparador = nombre1.compareTo(nombre2);
            int comparador = nombre1.compareToIgnoreCase(nombre2);
            if( comparador < 0){
                Nodo_AVL aux1 = Insertar_AVL(raiz.getIzquierdo(),nombre_archivo, contenido, creacion, propietario);
                raiz.setIzquierdo(aux1);
            }else{
                Nodo_AVL aux2 = Insertar_AVL(raiz.getDerecho(),nombre_archivo, contenido, creacion, propietario);
                raiz.setDerecho(aux2);
            }
        }
        int allt = 1 + Math.max(Altura(raiz.getIzquierdo()), Altura(raiz.getDerecho()));
        raiz.setAltura(allt);
        int balanceo = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo);
        if(balanceo < -1){
            if(raiz.getDerecho().getFactor_Equilibrio() == -1){
                return rotacionI(raiz);
            }else{
                Nodo_AVL aux1 = rotacionD(raiz.getDerecho());
                raiz.setDerecho(aux1);
                return rotacionI(raiz);
            }
        }
        if(balanceo > 1){
            if(raiz.getIzquierdo().getFactor_Equilibrio() == 1){
                return rotacionD(raiz);
            }else{
                Nodo_AVL aux1 = rotacionI(raiz.getIzquierdo());
                raiz.setIzquierdo(aux1);
                return rotacionD(raiz);
            }
        }
        return raiz;
    }
    
    public void Graficar(String user){
        Nodo_AVL aux = root;
        String archivo = "ArbolAVL_" + user + ".jpg";
        inten = 0;
        try{
            String ruta = "Reportes/Arbol_AVL.dot";
            String contenido = "digraph guia{ \n";
            contenido +="node [shape = record, style=filled, fillcolor=seashell2];\n";
            contenido += graficar11(aux);
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
            cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
            cuerpo += "\n Contenido:" + raiz.getContenido();
            cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
            cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
            cuerpo += "\n Creacion:" + raiz.getCreacion();
            cuerpo += "\n Propietario:" + raiz.getUsuario();
            cuerpo += "\"";
            cuerpo += "; \n";
            if(raiz.getIzquierdo() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar1(raiz.getIzquierdo());
            }
            if(raiz.getDerecho() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar1(raiz.getDerecho());
            }
        }
        return cuerpo;
    }
 
    private String graficar11(Nodo_AVL raiz){
        String cuerpo="";
        if(raiz != null){
            cuerpo += "\"";
            cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
            cuerpo += "\n Contenido:" + raiz.getContenido();
            cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
            cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
            cuerpo += "\n Creacion:" + raiz.getCreacion();
            cuerpo += "\n Propietario:" + raiz.getUsuario();
            cuerpo += "\"";
            cuerpo += "; \n";
            if(raiz.getIzquierdo() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar11(raiz.getIzquierdo());
            }else if(raiz.getIzquierdo() == null){
                cuerpo += "null" + inten + "[label=\"\", style=invis]; \n";
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> null"+ inten + "[style=invis]; \n";
                inten++;
            }
            if(raiz.getDerecho() != null){
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> \n";
                cuerpo += graficar11(raiz.getDerecho());
            }else if(raiz.getDerecho() == null){
                cuerpo += "null" + inten + "[label=\"\", style=invis]; \n";
                cuerpo += "\"";
                cuerpo += "Nombre Archivo:" + raiz.getNombre_Archivo();
                cuerpo += "\n Contenido:" + raiz.getContenido();
                cuerpo +=  "\n FE:" + raiz.getFactor_Equilibrio();
                cuerpo += "\n Altura:" + (raiz.getAltura() - 1);
                cuerpo += "\n Creacion:" + raiz.getCreacion();
                cuerpo += "\n Propietario:" + raiz.getUsuario();
                cuerpo += "\"";
                cuerpo += "-> null"+ inten + "[style=invis]; \n";
                inten++;
            }
        }
        return cuerpo;
    }
    
    public void Eliminar(String nombre_archivo){
        Nodo_AVL aux = Buscar_Nodo(root, nombre_archivo);
        this.root = aux;
        rebalancear(root);
        Nodo_AVL balanceado1 = rotacion(root);
        this.root = balanceado1;
    }
    
    private Nodo_AVL Buscar_Nodo(Nodo_AVL nodo, String nombre){
        if(nodo!=null){
            if(nodo.getNombre_Archivo().equals(nombre)){
                Nodo_AVL aux = Eliminar_Nodo(nodo);
                nodo = aux;
            }else{
                String nombre1 = nombre;
                String nombre2 = nodo.getNombre_Archivo();
                int comparador = nombre1.compareToIgnoreCase(nombre2);
                if( comparador < 0){
                    Nodo_AVL aux = Buscar_Nodo(nodo.getIzquierdo(), nombre);
                    nodo.setIzquierdo(aux);
                }else{
                    Nodo_AVL aux = Buscar_Nodo(nodo.getDerecho(), nombre);
                    nodo.setDerecho(aux);
                }
            }
        }
        return nodo;
    }
    
    private Nodo_AVL Eliminar_Nodo(Nodo_AVL nodo){
        if(nodo.getIzquierdo() != null && nodo.getDerecho()!=null){
            Nodo_AVL aux = buscar_izquierdo(nodo.getDerecho());
            nodo.setContenido(aux.getContenido());
            nodo.setCreacion(aux.getCreacion());
            nodo.setNombre_Archivo(aux.getNombre_Archivo());
            Nodo_AVL aux1 = Eliminar_Nodo(aux);
            nodo.getDerecho().setIzquierdo(aux1);
            System.out.println("Elimine el nodo con hijos");
        }else if(nodo.getIzquierdo()!= null){
            Nodo_AVL aux = nodo.getIzquierdo();
            nodo.setContenido(aux.getContenido());
            nodo.setCreacion(aux.getCreacion());
            nodo.setNombre_Archivo(aux.getNombre_Archivo());
            aux = Eliminar_Nodo(aux);
            nodo.setIzquierdo(aux);
            System.out.println("Elimine el nodo con izquierdo");
        }else if(nodo.getDerecho()!= null){
            Nodo_AVL aux = nodo.getDerecho();
            nodo.setContenido(aux.getContenido());
            nodo.setCreacion(aux.getCreacion());
            nodo.setNombre_Archivo(aux.getNombre_Archivo());
            aux = Eliminar_Nodo(aux);
            nodo.setDerecho(aux);
            System.out.println("Elimine el nodo con derecho");
        }else{
            nodo = null;
            System.out.println("Elimine el nodo hijo");
        }
        return nodo;
    }
    
    private Nodo_AVL buscar_izquierdo(Nodo_AVL nodo){
        if(nodo!=null){
            if(nodo.getIzquierdo()!= null){
                return buscar_izquierdo(nodo.getIzquierdo());
            }else{
                return nodo;
            }
        }
        return nodo;
    }
    
    public void rebalancear(Nodo_AVL raiz){
        if(raiz.getIzquierdo()!=null){
            rebalancear(raiz.getIzquierdo());
        }
        if(raiz.getDerecho()!=null){
            rebalancear(raiz.getDerecho());
        }
        int allt = 1 + Math.max(Altura(raiz.getIzquierdo()), Altura(raiz.getDerecho()));
        raiz.setAltura(allt);
        int balanceo = Factor_Equilibrio(raiz);
        raiz.setFactor_Equilibrio(balanceo);
    }
    
    public Nodo_AVL rotacion(Nodo_AVL nodo){
        if(nodo.getIzquierdo()!=null){
            Nodo_AVL aux = rotacion(nodo.getIzquierdo());
            nodo.setIzquierdo(aux);
        }
        if(nodo.getDerecho()!=null){
            Nodo_AVL aux1 = rotacion(nodo.getDerecho());
            nodo.setDerecho(aux1);
        }
        if(nodo.getFactor_Equilibrio() < -1){
            if(nodo.getDerecho().getFactor_Equilibrio() <= 0){
                return rotacionI(nodo);
            }else{
                Nodo_AVL aux1 = rotacionD(nodo.getDerecho());
                nodo.setDerecho(aux1);
                return rotacionI(nodo);
            }
        }
        if(nodo.getFactor_Equilibrio() > 1){
            if(nodo.getIzquierdo().getFactor_Equilibrio() >= 0){
                return rotacionD(nodo);
            }else{
                Nodo_AVL aux1 = rotacionI(nodo.getIzquierdo());
                nodo.setIzquierdo(aux1);
                return rotacionD(nodo);
            }
        }        
        return nodo;
    }

    public Nodo_AVL getRoot() {
        return root;
    }

    public void setRoot(Nodo_AVL root) {
        this.root = root;
    }
    
    
    
}

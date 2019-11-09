/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.Nodo_Hash;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MiriamLeticia
 */
public class TablaHash {
    private Nodo_Hash Primero;
    private Nodo_Hash[] Tabla;
    private int Capacidad;
    private int Utilizado;
    
    public TablaHash(){
        this.Utilizado = 0;
        this.Capacidad = 7;
        this.Tabla = new Nodo_Hash[Capacidad];
    }
    
    public void Insertar(String Usuario, String Contraseña){
        int indice = Calculo_Indice(Usuario);
        int indice_aux = indice;
        boolean iguales = false;
        Nodo_Hash nuevo = new Nodo_Hash(Usuario,Contraseña);
        if(indice<this.Capacidad){
            try{
                if(Tabla[indice] == null){
                    Utilizado++;
                    capacidad();
                    Tabla[indice] = nuevo;
                }else{
                    int contador = 1;
                    indice = ReCalculo_Indice(Usuario,contador);
                    Utilizado++;
                    capacidad();
                    while(Tabla[indice] != null){
                        contador = contador + 1;
                        indice = ReCalculo_Indice(Usuario,contador);
                    }
                    Tabla[indice] = nuevo;
                }
            }catch(Exception e){
                
            }
        }
        
    }
    
    public void imprimir(){
        int contador = 0;
        for(Nodo_Hash aux1: Tabla){
            if(aux1 != null){
                System.out.println("Esta ocupando: " + contador + " Esta el usuario: " + aux1.getUsuario());
            }
            contador = contador + 1;
        }
    }
    
    private int nuevo_indice(int numero){
        int nueva_posicion = 0;
        if(numero < Capacidad){
            nueva_posicion = numero;
        }else{
            nueva_posicion = numero - Capacidad;
            nueva_posicion = nuevo_indice(nueva_posicion);
        }
        return nueva_posicion;
    }
    
    private int Calculo_Indice(String nombre){
        char[] Nombre = nombre.toCharArray();
        int divisor=0;
        for (int i = 0; i < Nombre.length; i++) {
            divisor = divisor + (int) Nombre[i];
        }
        int indice_final = divisor % (this.Capacidad);
        System.out.println("Modulo: " + divisor + " Indice: " + indice_final);
        return indice_final;
    }
    
    private int ReCalculo_Indice(String user_name, int intento){
        int nuevo_indice, nuevo, extra = Calculo_Indice(user_name) + intento * intento;
        //nuevo_indice = extra % Capacidad;
        //nuevo_indice = extra;
        nuevo = nuevo_indice(extra);
        return nuevo;
    }
    
    private void capacidad(){
        int aux_capacidad;
        double aux_utilizacion = this.Capacidad*0.75;
        if(Utilizado>aux_utilizacion){
            aux_capacidad = Primo(true);
            this.Capacidad = aux_capacidad;
            this.Utilizado = 0;
            ReInsertar();
        }else{
        }
    }
    
    private int Primo(boolean p){
        int nuevo = 0, limite=1000, cap=this.Capacidad;
        //boolean p = true;
        while(true){
            if(limite-1>cap+1){
                break;
            }else{
                limite = limite + 1000;
            }
        }
        boolean[] primos = new boolean[limite+1];
        for (int i = 0; i < primos.length; i++) {
            primos[i]=true;
        }
        for(int i = 2;i < primos.length; i++){
            for (int j = 2; j*i < primos.length; j++) {
                primos[i*j]=false;
            }
        }
        for (int i = 2; i < primos.length; i++) {
            if(primos[i]==true){
                if(p==true && i>cap){
                    nuevo = i;
                    p=false;
                }
            }
        }
        return nuevo;
    }
    
    private void ReInsertar(){
        Nodo_Hash[] aux = Tabla.clone();
        Tabla = null;
        Tabla = new Nodo_Hash[Capacidad];
        for (Nodo_Hash aux1 : aux) {
            if (aux1 != null) {
                Insertar(aux1.getUsuario(), aux1.getContraseña());
            }
        }
    }
    
    public Nodo_Hash Buscar(String user){
        int indice = Calculo_Indice(user), contador = 0;
        Nodo_Hash encontrado = null;
        int aux = indice;
        if(Utilizado>0){
            if(Tabla[indice]!=null){
                if(Tabla[indice].getUsuario().equals(user)){
                    encontrado = Tabla[indice];
                }else{
                    while(contador<Capacidad){
                        indice = ReCalculo_Indice(user,contador);
                        if(Tabla[indice] != null){
                            if(Tabla[indice].getUsuario().equals(user)){
                                encontrado = Tabla[indice];
                                break;
                            }
                        }else{
                            break;
                        }
                        contador++;
                    }
                }
            }
        }
        return encontrado;
    }
    
    public void Graficar(){
        try{
            String ruta = "Reportes/TablaHash.dot";
            String contenido = "digraph guia{ \n";
            contenido += "tbl [\n";
            contenido += "shape=plaintext\n";
            contenido += "label=<\n";
            contenido += "<table border='0' cellborder='1' color='blue' cellspacing='0'>\n";
            contenido += dotContenido();
            contenido += "\n</table>\n";
            contenido += ">];\n";
            contenido += "}";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            try{
                String cmd = "dot -Tjpg " + ruta + " -o " + "Reportes/TablaHash.jpg";
                try {
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException ex) {
                    System.out.println("No se genero a imagen");
                }
            }catch(Exception e){
                System.out.println("No se genero a imagen");
            }
        }catch(IOException x){
            System.out.println("Se produjo un error con el archivo dot");
        }
    }
    
    private String dotContenido(){
        String cuerpo = "";
        int contador = 0;
        for(Nodo_Hash aux1: Tabla){
            if(aux1 != null){
                cuerpo += "<tr><td>" + contador + "</td><td>Usuario: " + aux1.getUsuario() +" Contraseña: " + aux1.getContraseña() + "</td></tr> \n";
            }else{
                cuerpo += "<tr><td>" + contador + "</td></tr> \n";
            }
            contador = contador + 1;
        }
        return cuerpo;
    }

    public Nodo_Hash getPrimero() {
        return Primero;
    }

    public void setPrimero(Nodo_Hash Primero) {
        this.Primero = Primero;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public int getUtilizado() {
        return Utilizado;
    }

    public void setUtilizado(int Utilizado) {
        this.Utilizado = Utilizado;
    }
    
    public Nodo_Hash[] getTabla() {
        return Tabla;
    }

    public void setTabla(Nodo_Hash[] tabla) {
        this.Tabla = tabla;
    }
}

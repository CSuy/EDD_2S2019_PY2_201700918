/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.Nodo_Hash;

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
        boolean iguales = false;
        Nodo_Hash nuevo = new Nodo_Hash(Usuario,Contraseña);
        if(indice<this.Capacidad){
            if(Tabla[indice] == null){
                Tabla[indice] = nuevo;
                Utilizado++;
                capacidad();
            }else{
                int contador = 1;
                indice = ReCalculo_Indice(indice,contador);
                while(Tabla[indice] != null){
                    contador = contador + 1;
                    indice = ReCalculo_Indice(indice,contador);
                }
                Tabla[indice] = nuevo;
                Utilizado++;
                capacidad();
            }
        }else{
            indice = indice - Capacidad;
            if(Tabla[indice] == null){
                Tabla[indice] = nuevo;
                Utilizado++;
                capacidad();
            }else{
                int contador = 1;
                indice = ReCalculo_Indice(indice,contador);
                while(Tabla[indice] != null){
                    contador = contador + 1;
                    indice = ReCalculo_Indice(indice,contador);
                }
                Tabla[indice] = nuevo;
                Utilizado++;
                capacidad();
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
            nueva_posicion = numero - 7;
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
        int indice_final = divisor % (this.Capacidad - 1);
        System.out.println("Modulo: " + divisor + " Indice: " + indice_final);
        return indice_final;
    }
    
    private int ReCalculo_Indice(int index, int intento){
        int nuevo_indice, nuevo;
        nuevo_indice = index + intento * intento;
        nuevo = nuevo_indice(nuevo_indice);
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

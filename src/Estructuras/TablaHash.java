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
    private int Capacidad;
    private int Utilizado;
    
    public TablaHash(){
        this.Utilizado = 0;
        this.Capacidad = 7;
        this.Primero = null;
    }
    
    public void Insertar(String Usuario, String Contraseña){
        int indice = Calculo_Indice(Usuario);
        boolean iguales = false;
        Nodo_Hash nuevo = new Nodo_Hash(indice,Usuario,Contraseña);
        if(Primero==null){
            Primero = nuevo;
            Utilizado++;
        }else{
            Nodo_Hash aux = Primero;
            while(aux.getAbajo()!=null){
                aux= aux.getAbajo();
            }
            aux.setAbajo(nuevo);
            Utilizado++;
            capacidad();
            System.out.println("capacidad actual: " + Capacidad + " Utilizado: " + Utilizado);
        }
    }
    
    public int Calculo_Indice(String nombre){
        char[] Nombre = nombre.toCharArray();
        int divisor=0;
        for (int i = 0; i < Nombre.length; i++) {
            divisor = divisor + (int) Nombre[i];
        }
        int indice_final = divisor % (this.Capacidad - 1);
        return indice_final;
    }
    
    public void capacidad(){
        int aux_capacidad;
        double aux_utilizacion = this.Capacidad*0.75;
        if(Utilizado>aux_utilizacion){
            System.out.println("Entre: ");
            aux_capacidad = Primo(true);
            this.Capacidad = aux_capacidad;
        }else{
            System.out.println("No entre");
        }
    }
    
    public int Primo(boolean p){
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
    
}

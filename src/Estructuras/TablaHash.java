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
            if(aux.getAbajo() == null){
                
            }else{
                while(aux.getAbajo()!=null){
                    
                }
            }
        }
    }
    
    public int Calculo_Indice(String nombre){
        char[] Nombre = nombre.toCharArray();
        int divisor=0;
        for (int i = 0; i < Nombre.length; i++) {
            divisor = divisor + (int) Nombre[i];
        }
        int indice_final = divisor % this.Capacidad;
        return indice_final;
    }
    
    public void capacidad(){
        int aux_capacidad;
        double aux_utilizacion = this.Capacidad*0.75;
        if(Utilizado>aux_utilizacion){
            aux_capacidad = Primo();
            this.Capacidad = aux_capacidad;
        }
    }
    
    public int Primo(){
        int nuevo = 0, limite=11, cap=this.Capacidad;
        boolean p = true;
        while(true){
            if(limite>cap){
                break;
            }else{
                limite = limite + 10;
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
                if(i>cap && p==true){
                    nuevo = i;
                    p=false;
                }
            }
        }
        return nuevo;
    }
}

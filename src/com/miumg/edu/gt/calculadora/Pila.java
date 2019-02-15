
package com.miumg.edu.gt.calculadora;

/**
 *
 * @author eperezm19
 */
public class Pila {
    private int maximo = 0;
    private int tope = 0;
    private Object pila[];
    
    //Metodo construtor de la Pila
    public Pila(int n){
        this.maximo = n;
        tope = 0;
        pila = new Object[n];           
    }
    
    //Metodo que valida pila llena
    public boolean estaLLena(){
        return tope == maximo;
    }
    
    //Metodo que valida pila vacia
    public boolean estaVacia(){
        return tope == 0;
    }
    
    //Metodo para apilar
    public boolean aplilar(Object dato){
        
        if(estaLLena()){
           return false;
        }
        
        pila[tope]= dato;
        tope++;
        
        return true;
    }
    
    //Metodo para desapilar
    public Object desapilar(){
        
        if(estaVacia()){
            return false;
        }
        tope--;
        return pila[tope];
    }
    
    //para tomar la prioridad que tiene el elmento
    public Object elementoTope(){

        return pila[tope-1];
    }
    
}

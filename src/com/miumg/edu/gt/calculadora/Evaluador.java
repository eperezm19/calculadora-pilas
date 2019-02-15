
package com.miumg.edu.gt.calculadora;

/**
 *
 * @author eperezm19
 */
public class Evaluador {
    
    //Metodo para valuar la expresion 
    public double insertExpresion(String expresion){
        String posfija = convertirExpresion(expresion);
        
        return operarPosfija(posfija);
    }
    
    //Metodo para pasar de expresion infija a posfija
    private String convertirExpresion(String expresionInfija){
        String posfija = "";
        Pila pila = new Pila(100);
        
        for(int i = 0; i < expresionInfija.length(); i++){
            char letra= expresionInfija.charAt(i);
            
            if(esOperador(letra)){

                if(pila.estaVacia()){
                    pila.aplilar(letra);
                }
                else{
                
                    int prioridadExpresion = prioridadEnExpresion(letra);
                    int prioriedadPila = prioridadEnPila((char)pila.elementoTope());
                
                    if(prioridadExpresion > prioriedadPila){
                        pila.aplilar(letra);
                    }
                    else{
                        if(letra == ')'){
                            
                            while((char)pila.elementoTope() != '('){
                                posfija += pila.desapilar();
                               
                            }
                        
                            pila.desapilar();
                        }
                        else{
                            posfija += pila.desapilar();
                            pila.aplilar(letra);
                        }
                    }   
                }
            }
            else{
                posfija += letra;
            }
            
        }
        
        while(!pila.estaVacia()){
            posfija += pila.desapilar();
           
        }
         System.out.println("------------------------------------" + posfija);
        return posfija;
    }
    
    //Metodo para operar la expresion posfija
    private double operarPosfija(String posfija){
        double numero1;
        double numero2;
        double numero3;
        
        Pila pilaposfija = new Pila(100);
        
        for(int i = 0; i < posfija.length(); i++){
            char letra = posfija.charAt(i);
            
            if(!esOperador(letra)){
                double numero = new Double(letra + "");
                pilaposfija.aplilar(numero);
            }
            else{
                numero1 = (double) pilaposfija.desapilar();
                numero2 = (double) pilaposfija.desapilar();
                numero3 = operar(letra, numero1, numero2);
                
                pilaposfija.aplilar(numero3);

            }
        }
        
        return (double) pilaposfija.elementoTope();
    }
  
    //Metodo para saber si es operador 
    public boolean esOperador(char operador){
        
        if(operador == '^' || operador == '*' || operador == '/' 
                || operador == '+' || operador == '-' || operador == '('
                || operador == ')'){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Prioridad de operadores en la expresion
    private int prioridadEnExpresion(char operador){
        
        if(operador == '^'){
            return 4;
        }
        
        if(operador == '*'){
            return 2;
        }
        
        if(operador == '/'){
            return 2;
        }
        
        if(operador == '+'){
            return 1;
        }
        
        if(operador == '-'){
            return 1;
        }
        
        if(operador == '('){
            return 5;
        }
        
        return 0;
    }
    
    //Prioridad de operadores en la pila
    private int prioridadEnPila(char operador){
        
        if(operador == '^'){
            return 3;
        }
        
        if(operador == '*'){
            return 2;
        }
        
        if(operador == '/'){
            return 2;
        }
        
        if(operador == '+'){
            return 1;
        }
        
        if(operador == '-'){
            return 1;
        }
        
        if(operador == '('){
            return 0;
        }
        
        return 0;
    }
    
    //Metodo para realizar operacion
    private double operar(char operador, double numero1, double numero2){
        
        if(operador =='^'){
            return Math.pow(numero1, numero2);
        }
        
        if(operador =='*'){
            return numero1 * numero2;
        }
        
        if(operador =='/'){
            return numero1 /numero2;
        }
        
        if(operador =='+'){
            return numero1 + numero2;
        }
        
        if(operador =='-'){
            return numero1 - numero2;
        }
          
        return 0;
    }
   }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion.pkg4.java;

/**
 *
 * @author Marina
 */
public abstract class Filtro {
    
    protected int revoluciones;
    
    public Filtro(){
        revoluciones=0;
    }
    
    public void setRevoluciones(int incremento){
        revoluciones = incremento;
    }
    
    public abstract int ejecutar(int incrementoVelocidad, Boolean estadoCoche);
}

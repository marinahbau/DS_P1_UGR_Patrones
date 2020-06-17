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
public class CalcularVelocidad extends Filtro{
    
    public CalcularVelocidad(){
        super();
    }

    @Override
    public int ejecutar(int incrementoVelocidad, Boolean estadoCoche) {
        if(!estadoCoche)
            return 0;
        //Vamos a suponer el maximo de RPM en 500 
       if((revoluciones + incrementoVelocidad) > 500){
           revoluciones = 500;
        }
       else{
           revoluciones += incrementoVelocidad;
        }
       return revoluciones;
    }
}

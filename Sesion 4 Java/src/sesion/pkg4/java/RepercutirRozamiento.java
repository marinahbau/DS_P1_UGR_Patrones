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
public class RepercutirRozamiento extends Filtro{
    
    
    public RepercutirRozamiento(){
        super();
    }
    
    @Override
    public int ejecutar(int incrementoVelocidad, Boolean estadoCoche) {
        if(!estadoCoche)
            return 0;
        if(revoluciones-1 < 0)
            return 0;
        return (revoluciones - 1);
    }
}

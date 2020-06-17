/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3.java;

import java.util.Observable;

/**
 *
 * @author Marina
 */
public class ObservableTemperatura extends Observable{
   
    private int temp;
    private String localizacion;
    
    public ObservableTemperatura(int t, String nombre){
        super();
        temp=t;
        localizacion = nombre;
    }
    
    public String getLocalizacion() {
        return localizacion; 
    }
    
    public int getState(){
        return temp;
    }
    
    public void incrementaTemperatura(int incremento){
        temp+=incremento;
        this.setChanged();    //Marcamos que la temperatura ha cambiado y notificamos a todos los observadores de que ha habido un cambio
        this.notifyObservers();
    }
   
    public void setState(int _temp){
        temp=_temp;
    }
}

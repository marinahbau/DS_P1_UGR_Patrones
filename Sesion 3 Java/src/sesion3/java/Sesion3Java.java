/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3.java;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author Marina
 */
public class Sesion3Java extends Thread{

    /**
     * @param args the command line arguments
     */
    ObservableTemperatura observable;
    
    public Sesion3Java(ObservableTemperatura _ob){  //Objeto principal: simulador de temperatura
        observable=_ob;
    }
    
    public void run(){
        Random rand=new Random();
        int temperatura;
        
        while(true){
            temperatura=rand.nextInt(7)-3;
            try {
                Thread.sleep(5000);
            }catch(java.lang.InterruptedException e){
                e.printStackTrace();
            }
            observable.incrementaTemperatura(temperatura);
        }
        
    }
    
    
    public static void main(String[] args) {
        
        ObservableTemperatura miTemperatura= new ObservableTemperatura(35, "undefined");
        Sesion3Java miCliente = new Sesion3Java(miTemperatura);
        pantallaTemperatura miPantalla= new pantallaTemperatura(miTemperatura);
        botonTemperatura miBoton = new botonTemperatura(miTemperatura);
        graficaTemperatura miGrafica = new graficaTemperatura(miTemperatura);
        
        tiempoSatelital miSatelite = new tiempoSatelital();
        
        //Añadimos los observadores al observable
        miTemperatura.addObserver(miBoton);
        miTemperatura.addObserver(miGrafica);
        
        miCliente.start();
        
        miPantalla.setVisible(true);
        miPantalla.hebra.start();
        
        miBoton.setVisible(true);
        miGrafica.setVisible(true);
        
        //Parte opcional-------------------------------------------------------------------
        
        
        ObservableTemperatura tempMadrid = new ObservableTemperatura(19, "Madrid");
        ObservableTemperatura tempCA = new ObservableTemperatura(16, "California");
        ObservableTemperatura tempSdy = new ObservableTemperatura(27, "Sidney");
        
        
        Sesion3Java clienteM = new Sesion3Java(tempMadrid);
        Sesion3Java clienteC = new Sesion3Java(tempCA);
        Sesion3Java clienteS = new Sesion3Java(tempSdy);
        
        tempMadrid.addObserver(miSatelite);
        tempCA.addObserver(miSatelite);
        tempSdy.addObserver(miSatelite);
        
        clienteM.start();
        clienteC.start();
        clienteS.start();
        
        miSatelite.setVisible(true);
      
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3.java;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
/**
 *
 * @author Marina
 */
public class pantallaTemperatura extends JFrame implements Observer, Runnable{
    private static int temperaturaPantalla;
    public ObservableTemperatura sujetoObservable;
    private static JPanel pantalla;
    private static JLabel celsius, farenheit;
    public Thread hebra;
    
    public pantallaTemperatura(ObservableTemperatura ob){
        sujetoObservable=ob;
        temperaturaPantalla=0;
        
        setTitle("Pantalla Temperatura");
        setSize(400,100);
        pantalla = new JPanel();
        getContentPane().add(pantalla);
        
        celsius = new JLabel();
        farenheit = new JLabel();
        
        pantalla.add(celsius);
        pantalla.add(farenheit);
        
        hebra = new Thread(this);
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = (centerPoint.x - windowSize.width / 2) + 500;
        int dy = (centerPoint.y - windowSize.height / 2) - 150;  
        setLocation(dx, dy);
        
    }

    public static void actualiza(){
        celsius.setText("C: "+String.valueOf(temperaturaPantalla));
        int aux = (temperaturaPantalla * 9/5)+32;
        farenheit.setText("F: "+String.valueOf(aux));
    }
    
    @Override
    public void update(Observable o, Object o1) {
    }

    @Override
    public void run() { //Con una hebra implementamos la comunicación pull, la pantalla esta constantemente observando la temperatura y mostrando su valor
        while(true){
            temperaturaPantalla = sujetoObservable.getState();
            actualiza();
        }
    }
    
}

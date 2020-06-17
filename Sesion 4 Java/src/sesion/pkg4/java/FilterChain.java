/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion.pkg4.java;

import java.util.ArrayList;

/**
 *
 * @author Marina
 */
public class FilterChain {
    private ArrayList<Filtro> cadenaFiltros;
    private Salpicadero objetivoSalpicadero; 
    
    public FilterChain(){
        cadenaFiltros = new ArrayList();
        objetivoSalpicadero = new Salpicadero();
    }
    
    public void addFilter(Filtro filtro){
        cadenaFiltros.add(filtro);
    }
    
    public void ejecutar(int incrementoVelocidad, boolean estadoCoche){
        int revoluciones = objetivoSalpicadero.getRevoluciones();
        for(int i=0; i<cadenaFiltros.size(); i++){
            cadenaFiltros.get(i).setRevoluciones(revoluciones);
            revoluciones = cadenaFiltros.get(i).ejecutar(incrementoVelocidad, estadoCoche);
        }
        objetivoSalpicadero.ejecutar(revoluciones, estadoCoche);
    }
}

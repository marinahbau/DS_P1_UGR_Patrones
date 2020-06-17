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
public class FilterManager {
    private FilterChain cadenaFiltros;
    private Filtro filtroVelocidad;
    private Filtro filtroRozamiento;
    
    public FilterManager(){
        
        //Crea la cadena de filtros y la rellena
        cadenaFiltros = new FilterChain();
        
        filtroVelocidad = new CalcularVelocidad();
        filtroRozamiento = new RepercutirRozamiento();
        
        cadenaFiltros.addFilter(filtroVelocidad);
        cadenaFiltros.addFilter(filtroRozamiento);
    }
    
    public void peticionFiltros(int incremento, Boolean estadoCoche){
        cadenaFiltros.ejecutar(incremento, estadoCoche);
    }
   
}

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Carrera {

	protected ArrayList<Bicicleta> bici;
        
        Carrera(ArrayList<Bicicleta> bicis){
            bici=bicis;
           
        }

        abstract public void lanzarCarrera(final int retirada);
        
        
        protected void Ranking(){
            //arraylist auxiliar con todas las distancias recorridas por las bicicletas que participan en una carrera
            ArrayList<Integer> aux = new ArrayList<Integer>();
            
            for(int i=0; i<bici.size(); i++){
                aux.add(bici.get(i).getDistancia());
            }
            
            //Buscamos el TOP 3
            for(int i=0; i<3; i++){
                int max=0;
                int num_bici = -1;
                for(int j=0; j<aux.size(); j++){
                    if(aux.get(j)>max){
                        max = aux.get(j);
                        num_bici = j;
                    }
                }
                aux.set(num_bici, -1); //La bici que va en cabeza ya no se tiene en cuenta para encontrar las siguientes posiciones
                System.out.println("La bici en posicion " + (i+1) + " es " + bici.get(num_bici).getDorsal());
            }
             System.out.println();
        }
}
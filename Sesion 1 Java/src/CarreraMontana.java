
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarreraMontana extends Carrera {

	CarreraMontana(ArrayList<Bicicleta> bicis){
            super(bicis);
        }
        
        public void lanzarCarrera(final int segretirada){
            
            //Calculamos las bicicletas que se retiran
            final int bajas=Math.round((bici.size()*20)/100);
            
            //Lanzamos las bicicletas como hebras a la carrera
            for(int i=0; i<bici.size(); i++){
                bici.get(i).start();
            }
            
            
            boolean carreraCorriendo=true; //Marca si la carrera está o no en marcha
            int segundos=0;
            
                
                        while(carreraCorriendo){
                            try {
                                Thread.sleep(1000); //Dormimos 1 segundo
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarreraMontana.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            segundos++;
                            
                            System.out.println("[MONTAÑA]En el segundo " + segundos + ":");
                            Ranking(); //Informamos de las posiciones actuales
                      
                            
                            //En el momento en que lleguemos al segundo de retirada
                            
                            if(segundos==segretirada){
                            
                                ArrayList<Integer> salidas=new ArrayList<Integer>();
                                for(int i=0; i<bajas; i++){
                                    Random r = new Random();
                                    salidas.add(r.nextInt(bici.size()));
                                    System.out.println("[MONTAÑA]Se retira la bicicleta con dorsal " + salidas.get(i));
                                    for(int j = 0; j < bici.size(); j++) {
                                        if (salidas.get(i) == bici.get(j).getDorsal()){
                                            bici.remove(j);
                                        }
                                    }
                                }
                            
                            }
                            
                            //Se acaba la carrera a los 60 segundos
                            if(segundos==60){
                                carreraCorriendo=false;
                                
                                //RANKING FINAL
                          
                                System.out.println("CARRERA MONTAÑA FINALIZADA. RANKING FINAL: ");
                                Ranking();
                     
                                
                                //Paramos las hebras
                                for(int i=0; i<bici.size(); i++){
                                    bici.get(i).stop();
                                }
                                
                            }
                        
                        }
                
            
          
        }
}

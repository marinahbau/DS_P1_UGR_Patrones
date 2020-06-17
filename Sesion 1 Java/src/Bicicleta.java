public abstract class Bicicleta extends Thread {

	protected int id;
        protected int distancia;
        
    Bicicleta(int _id){
        id=_id;
        distancia=0;
    }
    
    public int getDistancia(){
        return distancia;
    }
    
    public int getDorsal() {
        return id;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                long espera=Math.round(Math.random()*1000);
                //Simulamos una velocidad concreta para esa hebra
                Thread.sleep(espera);
                distancia++;  //tiempo que tarda en recorrer una unidad de distancia
            }
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
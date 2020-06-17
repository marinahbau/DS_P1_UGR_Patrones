
import java.util.ArrayList;
import java.util.Random;


public class Cliente {
    
    //Creamos las dos factorias
    //Llamamos y creamos las carreras segun la factoria que corresponda
    //Rellenamos los arrays de bicis llamando a crearBicicletas segun el tipo de carrera. Se rellena el array de bicicletas con un numero aleatorio de bicicletas
    //UNa vez creadas, llamamos a lanzarCarrera simultaneamente para las dos
    //La clase carrera debe tener un metodo lanzarCarrera para empear el bucle de 60 segundos, su argumento es la factoria del tipo de carrera
    //Cada bicicleta es una hebra distinta
    
    public static void main(String[] args){
        Random rand= new Random();
        
        int nBicicletas= rand.nextInt(17)+3; //Para que haya como mínimo 3 bicicletas
       
        //Creamos las dos factorias
        FactoriaCarrerayBicicleta fMontana= new FactoriaMontana();
        FactoriaCarrerayBicicleta fCarretera= new FactoriaCarretera();
        
        //Creamos dos arrays de bicicletas a traves de las factorias
        ArrayList<Bicicleta> bicismontana= new ArrayList<Bicicleta>();
        ArrayList<Bicicleta> biciscarretera= new ArrayList<Bicicleta>();
        
        //Rellenamos los arrays
        for(int i=0; i<nBicicletas; i++){
            bicismontana.add(fMontana.crearBicicleta(i));
            biciscarretera.add(fCarretera.crearBicicleta(i));
        }
        
        
        //Creamos las carreras a traves de las factorias y les proporcionamos las bicis que participan en cada carrera
        Carrera cMontana= fMontana.crearCarrera(bicismontana);
        Carrera cCarretera= fCarretera.crearCarrera(biciscarretera);
        
        cCarretera.lanzarCarrera(16);
       
        cMontana.lanzarCarrera(16);
    }
    
}
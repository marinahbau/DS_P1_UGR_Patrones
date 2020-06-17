
import java.util.ArrayList;

public class FactoriaMontana extends FactoriaCarrerayBicicleta {

	public Bicicleta crearBicicleta(int n) {
                Bicicleta bici =  new BicicletaMontana(n);
                return bici;
	}

	public Carrera crearCarrera(ArrayList<Bicicleta> bicis) {
		Carrera carrera= new CarreraMontana(bicis);
                return carrera;
	}

}

import java.util.ArrayList;

public class FactoriaCarretera extends FactoriaCarrerayBicicleta {

	public Bicicleta crearBicicleta(int n) {
		Bicicleta bici =  new BicicletaCarretera(n);
                return bici;
	}
        
        public Carrera crearCarrera(ArrayList<Bicicleta> bicis) {
		Carrera carrera= new CarreraCarretera(bicis);
                return carrera;
	}
}
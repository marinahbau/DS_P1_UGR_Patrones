#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"

ComponenteEquipo::ComponenteEquipo(string _nombre, int _precio){
    nombre=_nombre;
    precio=_precio;
}
string ComponenteEquipo::getNombreComponente(){
    return this->nombre;
}

int ComponenteEquipo::getPrecioComponente(){
    return this->precio;
}




//*****************************************************************BUS***********************************************************************

Bus::Bus(string _nombre, int _precio):ComponenteEquipo(_nombre, _precio){
    //cout << "He creado un bus: "<< this->nombre << " " << this->precio << endl;
}

void Bus::accept(VisitanteEquipo *v){
    v->visitarBus(this);
}

//*****************************************************************DISCO***********************************************************************

Disco::Disco(string _nombre, int _precio):ComponenteEquipo(_nombre, _precio){
   // cout << "He creado un disco: "<< this->nombre << " " << this->precio << endl;
}

void Disco::accept(VisitanteEquipo *v){
    v->visitarDisco(this);
}

//*****************************************************************TARJETA***********************************************************************

Tarjeta::Tarjeta(string _nombre, int _precio):ComponenteEquipo(_nombre, _precio){
   // cout << "He creado une tarjete: "<< this->nombre << " " << this->precio << endl;
}

void Tarjeta::accept(VisitanteEquipo *v){
    v->visitarTarjeta(this);
}
//**************************************************************EQUIPO***************************************************************************

Equipo::Equipo(vector<ComponenteEquipo*> _componentes){
    componentes=_componentes;
}

void Equipo::nombraComponentes(){
    for(int i=0; i<componentes.size(); i++){
        cout << componentes[i]->getNombreComponente() << endl;
    }
}
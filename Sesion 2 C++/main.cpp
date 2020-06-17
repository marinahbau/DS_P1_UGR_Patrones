#include <iostream>
#include <vector>
using namespace std;

#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"


int main(){

    //Creamos los vectores de componentes
    vector<ComponenteEquipo*> conjunto1, conjunto2;

    ComponenteEquipo *tarjeta1 = new Tarjeta("tarjeta1", 200);
    ComponenteEquipo *disco1 = new Disco("disco1", 155);
    ComponenteEquipo *bus1 = new Bus("bus1", 600);

    conjunto1.push_back(tarjeta1);
    conjunto1.push_back(disco1);
    conjunto1.push_back(bus1);

    ComponenteEquipo *tarjeta2 = new Tarjeta("tarjeta2", 400);
    ComponenteEquipo *disco2 = new Disco("disco2", 235);
    ComponenteEquipo *bus2 = new Bus("bus2", 50);

    conjunto2.push_back(tarjeta2);
    conjunto2.push_back(disco2);
    conjunto2.push_back(bus2);

    //Creamos dos equipos 
    Equipo e1(conjunto1);
    Equipo e2(conjunto2);

    //Se crean los visitantes
    VisitanteEquipo *vdetalle = new VisitantePrecioDetalle();
    VisitanteEquipo *vprecio = new VisitantePrecio();

    cout << "VISITANTE PRECIO DETALLE: " << endl;

    for(int i=0; i<e1.getComponentes().size();i++){
        e1.getComponentes()[i]->accept(vdetalle);
    }

    for(int i=0; i<e2.getComponentes().size();i++){
        e2.getComponentes()[i]->accept(vdetalle);
    }

    cout << "VISITANTE PRECIO DETALLE: " << endl;

    for(int i=0; i<e1.getComponentes().size();i++){
        e1.getComponentes()[i]->accept(vprecio);
    }
    
    cout << "Precio TOTAL Equipo 1: " << static_cast<VisitantePrecio*>(vprecio)->getPrecioTotal() << endl;
    static_cast<VisitantePrecio*>(vprecio)->resetPrecio();  //Reseteamos el precio para un nuevo ordenador

    for(int i=0; i<e2.getComponentes().size();i++){
        e2.getComponentes()[i]->accept(vprecio);
    }

    cout << "Precio TOTAL Equipo 2: " << static_cast<VisitantePrecio*>(vprecio)->getPrecioTotal() << endl;

   



}
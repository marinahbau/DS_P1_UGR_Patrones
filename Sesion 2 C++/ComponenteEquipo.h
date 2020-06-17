#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

//En este documento tendremos la clase Padre ComponenteEquipo junto con sus hijos Bus, Tarjeta y Disco

//#include "VisitanteEquipo.h"

#include <vector>
#include <iostream>
#include <string>
using namespace std;

class VisitanteEquipo;
class ComponenteEquipo {

    protected:
        string nombre;
        int precio;
    public:
        ComponenteEquipo(string _nombre, int _precio);
        virtual void accept(VisitanteEquipo *v){};
        string getNombreComponente();
        int getPrecioComponente();


};



//************************************************************************************************************************************************

class Bus : public ComponenteEquipo {
    //Hereda nombre y precio de ComponenteEquipo

    public:
        Bus(string _nombre, int _precio);
        virtual void accept(VisitanteEquipo *v);

};

//************************************************************************************************************************************************

class Disco : public ComponenteEquipo {
    //Hereda nombre y precio de ComponenteEquipo

    public:
        Disco(string _nombre, int _precio);
        virtual void accept(VisitanteEquipo *v);
};

//************************************************************************************************************************************************

class Tarjeta : public ComponenteEquipo {
    //Hereda nombre y precio de ComponenteEquipo

    public:
        Tarjeta(string _nombre, int _precio);
        virtual void accept(VisitanteEquipo *v);

};

//************************************************************************************************************************************************

class Equipo{
    private:
        vector<ComponenteEquipo*> componentes;
    public:
        Equipo(vector<ComponenteEquipo*> _componentes);
        void nombraComponentes();
        vector<ComponenteEquipo*> getComponentes(){return componentes;};
};


#endif
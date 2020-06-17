#ifndef VISITANTEEQUIPO_H
#define VISITANTEEQUIPO_H


class Bus;
class Tarjeta;
class Disco;
#include "ComponenteEquipo.h"
#include <iostream>
using namespace std;

class VisitanteEquipo {  //ESTA CLASE ES ABSTRACTA :)
    public:
        VisitanteEquipo();
        virtual void visitarDisco(Disco *d) = 0; //Los metodos virtuales puras DEBEN redefinirse en las clases hijas
        virtual void visitarBus(Bus *b) = 0;
        virtual void visitarTarjeta(Tarjeta *t) = 0;
};

//*************************************************************************************************************************************************

class VisitantePrecioDetalle : public VisitanteEquipo {
    public:
        VisitantePrecioDetalle();
        virtual void visitarDisco(Disco *d);
        virtual void visitarBus(Bus *b); 
        virtual void visitarTarjeta(Tarjeta *t); 

};

//***************************************************************************************************************************************************

class VisitantePrecio : public VisitanteEquipo {
    public:
        VisitantePrecio();
        virtual void visitarDisco(Disco *d);
        virtual void visitarBus(Bus *b); 
        virtual void visitarTarjeta(Tarjeta *t); 
        void resetPrecio();
        double getPrecioTotal();
    private:
        double precioTotal;
};
#endif
#include "VisitanteEquipo.h"

VisitanteEquipo::VisitanteEquipo(){

}

//************************************************************PRECIODETALLE***********************************************************************

VisitantePrecioDetalle::VisitantePrecioDetalle():VisitanteEquipo(){

}

void VisitantePrecioDetalle::visitarDisco(Disco *d){
   
    cout << "Disco: " << endl;
    cout << "   Nombre: " << d->getNombreComponente() << endl;
    cout << "   Precio: " << d->getPrecioComponente() << endl << endl;
}

void VisitantePrecioDetalle::visitarTarjeta(Tarjeta *t){
    
    cout << "Tarjeta: " << endl;
    cout << "   Nombre: " << t->getNombreComponente() << endl;
    cout << "   Precio: " << t->getPrecioComponente() << endl << endl;
}

void VisitantePrecioDetalle::visitarBus(Bus *b){
    
    cout << "Bus: " << endl;
    cout << "   Nombre: " << b->getNombreComponente() << endl;
    cout << "   Precio: " << b->getPrecioComponente() << endl << endl;
}

//************************************************************PRECIO**************************************************************************

VisitantePrecio::VisitantePrecio():VisitanteEquipo(){
    precioTotal=0;
}

void VisitantePrecio::visitarDisco(Disco *d){

    precioTotal+=d->getPrecioComponente();
}

void VisitantePrecio::visitarTarjeta(Tarjeta *t){

    precioTotal+=t->getPrecioComponente();
}

void VisitantePrecio::visitarBus(Bus *b){

    precioTotal+=b->getPrecioComponente();
}

void VisitantePrecio::resetPrecio(){
    precioTotal=0;
}

double VisitantePrecio::getPrecioTotal(){
    return precioTotal;
}
# DS_P1_UGR_Patrones
 Práctica que implementa 4 ejercicios que hacen uso de diferentes patrones de diseño orientados a objetos. Práctica de la asignatura Desarrollo de Software de la Universidad de Granada


## Ejercicio S1E1: Patrón “Factoría Abstracta” y patrón “Método Factoría” en Java (0.6 puntos)
Programa utilizando hebras la simulación de 2 carreras simultáneas con el mismo número inicial (N) de bicicletas. N no se conoce hasta que comienza la carrera. De las carreras de montaña y carretera se retirarán el 20% y el 10% de las bicicletas, respectivamente, antes de terminar. Ambas carreras duran exactamente 60 s. y todas las bicicletas se retiran a la misma vez.
Supondremos que FactoriaCarreraYBicicleta, una interfaz de Java, declara los métodos de fabricación públicos:
- crearCarrera que devuelve un objeto de alguna subclase de la clase abstracta Carrera y 
- crearBicicleta que devuelve un objeto de alguna subclase de la clase abstracta Bicicleta.

La clase Carrera tiene al menos un atributo ArrayList < Bicicleta >, con las bicicletas que participan en la carrera. La clase Bicicleta tiene al menos un identificador único de la bicicleta en una carrera. Las clases factoría específicas heredan de FactoriaCarreraYBicicleta y cada una de ellas se especializa en un tipo de carreras y bicicletas: las carreras y bicicletas de montaña y las carreras y bicicletas de carretera. Por consiguiente, asumimos que tenemos dos clases factoría específicas: FactoriaMontana y FactoriaCarretera, que implementarán cada una de ellas los métodos de fabricación crearCarrera y crearBicicleta.
Por otra parte, las clases Bicicleta y Carrera se debería definir como clases abstractas y especializarse en clases concretas para que la factoría de montaña pueda crear productos BicicletaMontana y CarreraMontana y la factoría de carretera pueda crear productos BicicletaCarretera y CarreraCarretera.
Para programar la simulación de cada bicicleta en cada carrera crearemos hebras en Java.

## Ejercicio S2E1: Visitante básico (0.4 puntos)
Utilizando este patrón (ver Figura 1.1) se pretende recorrer una estructura de componentes que forman un equipo de cómputo (clase Equipo), y desarrollar un programa para generar presupuestos de configuración de un computador simple, que está conformado con los siguientes elementos: Disco, Tarjeta, Bus. El programa mostrará el precio de cada posible configuración de un equipo. Cada componente es una subclase de ComponenteEquipo. Las clases Disco, Tarjeta, Bus extienden a la clase abstracta ComponenteEquipo e implementan todos sus métodos abstractos. La programación del método aceptar(VisitanteEquipove) en cada una de las clases anteriores consistirá en una llamada al método correspondiente de la clase abstracta VisitanteEquipo. Si la implementación fuera en Java, el código siguiente sería correcto:

**public abstract** VisitanteEquipo {
    **public abstract** void VisitarDisco( Disco d ) ;
    **public abstract** void VisitarTarjeta( Tarjeta t ) ;
    **public abstract** void VisitarBus ( Bus b ) ;
}

Debe adaptarse este código a C++, teniendo en cuenta que en C++ no existe una palabra reservada para declarar una clase como abstracta. En C++ una clase es abstracta cuando, o bien tiene declarado un método de ligadura dinámica (virtual) y no se implementa, o bien hereda un método de este tipo y no lo implementa, ambas condiciones.
Las subclases de VisitanteEquipo definirán algoritmos concretos que se aplican sobre la estructura de objetos que se obtiene de instanciar las subclases de ComponenteEquipo. Así, se definirán las siguientes subclases de VisitanteEquipo:

- VisitantePrecio: calcula el coste neto de todas las partes que conforman un determinado equipo (disco+tarjeta+bus), acumulando internamente el costo de cada parte después de visitarla.
- VisitantePrecioDetalle: mostrará los nombres de las partes que componen un equipo y sus precios.

El programa principal (main) se encargará de crear varios equipos y calcular el precio total de cada uno y los precios detallados y nombres de cada componente usando los visitantes adecuados.

## Ejercicio S3E1: Monitorización de datos meteorológicos (GUI y patrón observador) (0,6 puntos)
Programa, utilizando el patrón de diseño Observador (ver Figura 1.2), un programa Simulador simple de simulación de la monitorización de datos meteorológicos. El programa debe crear un sujeto-observable con una temperatura y tres observadores: pantallaTemperatura, botonCambio y gra f icaTemperatura. Cada vez que el sujeto actualiza su temperatura, lo que hace de forma regular (mediante una hebra), deberá notificar el cambio a los observadores que tenga suscritos (graficaTemperatura, botonCambio)
(comunicación push). El observador botonCambio no es un mero observador, sino que también podrá cambiar la temperatura del sujeto a petición del usuario. El observador pantallaTemperatura no está suscrito, sino que se comunicará con el sujeto observable de forma asíncrona (comunicación pull).

## Ejercicio S3E2: Ampliación con información geográfica (opcional) (0,15 puntos)
De forma opcional se puede añadir un cuarto observador: TiempoSatelital, que
muestre la temperatura sobre una posición de un mapa y acceda por suscripción a otros sujetos observables para mostrar las temperaturas en otras posiciones del mapa.

## Ejercicio S4E1: Simulador del movimiento de un vehículo con cambio automático
Queremos representar en el salpicadero de un vehículo (una hebra) los parámetros del movimiento del mismo (velocidad lineal en km/h, distancia recorrida en km y velocidad angular -”revoluciones”- en RPM), calculados a partir de las revoluciones del motor. Queremos además que estas revoluciones sean primero modificadas (filtradas) mediante software independiente a nuestro sistema, capaz de calcular el cambio en las revoluciones como consecuencia (1) del estado del motor (acelerando, frenando, apagando el motor . . .) y (2) del rozamiento.

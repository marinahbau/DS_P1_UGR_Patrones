CXX = g++
CXXFLAGS = -Wall -std=c++17 -g -fsanitize=address
LDFLAGS =  -fsanitize=address

SRC = main.cpp VisitanteEquipo.cpp ComponenteEquipo.cpp
OBJ = $(SRC:.cc=.o)
EXEC = sesion2

all: $(EXEC)

$(EXEC): $(OBJ)
	$(CXX) -o $@ $(OBJ) $(LBLIBS)

clean:
	rm *.o $(EXEC)
package ejer1y2;

class Hexagono extends Poligono{


    Hexagono(Punto[] arrayPuntos){

        super(arrayPuntos);
    }

    double area(){

        Punto[] puntosTriangulo = {puntos[0], puntos[1], puntos[2]};
        Triangulo myTriangulo = new Triangulo(puntosTriangulo);

        return myTriangulo.area() * 6;
    }
}
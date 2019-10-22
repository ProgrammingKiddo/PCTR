package ejer1y2;

class Pentagono extends Poligono{

    Pentagono(Punto[] arrayPuntos){

        super(arrayPuntos);
    }

    double area(){

        Punto[] puntosTriangulo = {puntos[0], puntos[1], puntos[3]};
        Triangulo myTriangulo = new Triangulo(puntosTriangulo);

        return myTriangulo.area() * 5;
    }
}
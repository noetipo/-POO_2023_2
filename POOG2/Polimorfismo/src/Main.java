import clases.Poligono;
import clases.Rectangulo;
import clases.Triangulo;

public class Main {
    public static void main(String[] args) {
        Poligono poligono = new Poligono();
        System.out.println(poligono.calcularArea());
        poligono=new Triangulo(3.0,3.0);
        System.out.println(poligono.calcularArea());
        poligono= new Rectangulo(4.0,4.0);
        System.out.println(poligono.calcularArea());


    }
}
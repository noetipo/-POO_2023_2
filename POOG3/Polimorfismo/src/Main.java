import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {/*
        Poligono poligono = new Poligono();
        System.out.println(poligono.calcularArea());
        poligono = new Triangulo(2.0, 2.0);
        System.out.println(poligono.calcularArea());
        poligono = new Cuadrado(2.0, 2.0);
        System.out.println(poligono.calcularArea());*/
        List<Poligono> poligonos = new ArrayList<>();
        poligonos.add(new Poligono());
        poligonos.add(new Triangulo(3.0, 6.0));
        poligonos.add(new Cuadrado(5.0, 6.0));
        for (Poligono poligono: poligonos) {
            System.out.println(poligono.calcularArea());
        }
    }
}
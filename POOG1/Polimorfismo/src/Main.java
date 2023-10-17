public class Main {
    public static void main(String[] args) {
        Poligono poligono = new Poligono();
        System.out.println(poligono.calcularArea());
        poligono=new Triangulo(2.0,3.0);
        System.out.println(poligono.calcularArea());
        poligono= new Cuadrado(2.0,3.0);
        System.out.println(poligono.calcularArea());
    }
}
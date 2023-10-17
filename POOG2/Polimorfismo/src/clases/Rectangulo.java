package clases;

public class Rectangulo extends Poligono {
    private Double x;
    private Double y;

    public Rectangulo(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Rectangulo(String lados, Double x, Double y) {
        super(lados);
        this.x = x;
        this.y = y;
    }
    @Override
    public String calcularArea() {
        return "El Area del triangulo es: " + (x * y) ;
    }
}

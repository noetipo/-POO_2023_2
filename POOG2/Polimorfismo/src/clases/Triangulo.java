package clases;

public class Triangulo extends Poligono {
    private Double base;
    private Double altura;

    public Triangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(String lados, Double base, Double altura) {
        super(lados);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public String calcularArea() {
        return "El Area del triangulo es: " + (base * altura) / 2;
    }
}

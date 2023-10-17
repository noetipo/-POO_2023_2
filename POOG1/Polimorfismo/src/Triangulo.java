public class Triangulo extends Poligono {
    private Double base;
    private Double altura;

    public Triangulo() {

    }

    public Triangulo(Double base) {
        this.base = base;
    }

    public Triangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(Integer lados, Double base) {
        super(lados);
        this.base = base;
    }

    @Override
    public String calcularArea() {
        return "El area del triangulo es: " + (base * altura) / 2;
    }
}

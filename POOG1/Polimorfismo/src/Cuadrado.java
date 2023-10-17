public class Cuadrado extends Poligono {
    private Double base;
    private Double altura;

    public Cuadrado() {
    }

    public Cuadrado(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Cuadrado(Integer lados, Double base, Double altura) {
        super(lados);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public String calcularArea() {
        return "El area del cuadrado es: " + base * altura;
    }
}

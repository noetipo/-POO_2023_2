public class Triangulo extends Poligono {
    private Double base;
    private Double altura;

    public Triangulo() {

    }

    public Triangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(Integer lados, Double base, Double altura) {
        super(lados);
        this.base = base;
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                ", lados=" + lados +
                '}';
    }

    @Override
    public String calcularArea() {
        return "El area del triangulo es " + (base * altura) / 2;
    }
}

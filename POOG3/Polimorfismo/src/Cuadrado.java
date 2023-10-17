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
        return "Cuadrado{" +
                "base=" + base +
                ", altura=" + altura +
                ", lados=" + lados +
                '}';
    }

    @Override
    public String calcularArea() {
        return "El area del cuadrado es " + base * altura;
    }
}

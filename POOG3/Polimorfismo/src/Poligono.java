public class Poligono {
    protected Integer lados;

    public Poligono() {
    }

    public Poligono(Integer lados) {
        this.lados = lados;
    }

    public Integer getLados() {
        return lados;
    }

    public void setLados(Integer lados) {
        this.lados = lados;
    }

    @Override
    public String toString() {
        return "Poligono{" +
                "lados=" + lados +
                '}';
    }

    public String calcularArea() {
        return "No es posible calcular area";
    }
}

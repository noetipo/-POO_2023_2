package clases;

public class Poligono {
    protected String lados;

    public Poligono() {
    }

    public Poligono(String lados) {
        this.lados = lados;
    }

    public String calcularArea() {
        return "No es posible calcular area en la clase poligono";
    }
}

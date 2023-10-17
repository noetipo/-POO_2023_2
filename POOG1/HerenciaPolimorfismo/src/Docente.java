public class Docente extends Persona {
    private String titulo;
    private String adscritoA;
    private Double sueldo;

    public Docente() {
    }

    public Docente(String titulo, String adscritoA, Double sueldo) {
        this.titulo = titulo;
        this.adscritoA = adscritoA;
        this.sueldo = sueldo;
    }

    public Docente(String dni, String nombre, String apellido, Double estatura, String ocupacion, String titulo, String adscritoA, Double sueldo) {
        super(dni, nombre, apellido, estatura, ocupacion);
        this.titulo = titulo;
        this.adscritoA = adscritoA;
        this.sueldo = sueldo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAdscritoA() {
        return adscritoA;
    }

    public void setAdscritoA(String adscritoA) {
        this.adscritoA = adscritoA;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "titulo='" + titulo + '\'' +
                ", adscritoA='" + adscritoA + '\'' +
                ", sueldo=" + sueldo +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estatura=" + estatura +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }
    public String saludar(){
        return "Hola soy la clase Docente";
    }
}

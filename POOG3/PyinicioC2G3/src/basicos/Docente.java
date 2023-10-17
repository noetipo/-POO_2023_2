package basicos;

public class Docente extends Persona {
    private String profesion;
    private String cargo;

    public Docente() {
    }

    public Docente(String profesion, String cargo) {
        this.profesion = profesion;
        this.cargo = cargo;
    }

    public Docente(String dni, String nombre, String apellido, Double estatura, String ocupacion, String profesion, String cargo) {
        super(dni, nombre, apellido, estatura, ocupacion);
        this.profesion = profesion;
        this.cargo = cargo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "profesion='" + profesion + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estatura=" + estatura +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }

    @Override
    public String saludo() {
        return "Hola desde la clase docente";
    }
}

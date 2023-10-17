package basicos;

public class Estudiante extends Persona {
    private String codigoUniversitario;
    private String carreraUniversitaria;

    public Estudiante() {

    }

    public Estudiante(String codigoUniversitario, String carreraUniversitaria) {
        this.codigoUniversitario = codigoUniversitario;
        this.carreraUniversitaria = carreraUniversitaria;
    }

    public Estudiante(String dni, String nombre, String apellido, Double estatura, String ocupacion, String codigoUniversitario, String carreraUniversitaria) {
        super(dni, nombre, apellido, estatura, ocupacion);
        this.codigoUniversitario = codigoUniversitario;
        this.carreraUniversitaria = carreraUniversitaria;
    }

    public String getCodigoUniversitario() {
        return codigoUniversitario;
    }

    public void setCodigoUniversitario(String codigoUniversitario) {
        this.codigoUniversitario = codigoUniversitario;
    }

    public String getCarreraUniversitaria() {
        return carreraUniversitaria;
    }

    public void setCarreraUniversitaria(String carreraUniversitaria) {
        this.carreraUniversitaria = carreraUniversitaria;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", estatura=" + estatura +
                ", ocupacion='" + ocupacion + '\'' +

                "codigoUniversitario='" + codigoUniversitario + '\'' +
                ", carreraUniversitaria='" + carreraUniversitaria + '\'' +
                '}';
    }

    @Override
    public String saludo() {
        return "Hola desde la clase estudiante";
    }
}

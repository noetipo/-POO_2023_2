package basicos;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private Double estatura;
    private String ocupacion;
    private Integer numeroCelular;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellido, Double estatura, String ocupacion, Integer numeroCelular) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.ocupacion = ocupacion;
        this.numeroCelular = numeroCelular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(Integer numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estatura=" + estatura +
                ", ocupacion='" + ocupacion + '\'' +
                ", numeroCelular=" + numeroCelular +
                '}';
    }
}

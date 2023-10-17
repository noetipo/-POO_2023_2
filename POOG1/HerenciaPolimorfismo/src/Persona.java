public class Persona {
    protected String dni;
    protected String nombre;

    protected String apellido;

    protected Double estatura;
    protected String ocupacion;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellido, Double estatura, String ocupacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.ocupacion = ocupacion;
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

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estatura=" + estatura +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }

    public String saludar() {
        return "Hola soy la clase persona";
    }
}

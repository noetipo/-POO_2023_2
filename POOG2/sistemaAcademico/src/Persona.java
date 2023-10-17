public class Persona {


    public String dni;
    public Double estatura;
    public String nombre;
    public String ocupacion;
    public Persona(String dni, Double estatura, String nombre, String ocupacion) {
        this.dni = dni;
        this.estatura = estatura;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
    }
    public Persona() {
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }


    public Integer caminar() {
        return 0;
    }

    public String presentarse() {
        return "Hola soy Noe";
    }

    public void saludar() {

    }
    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", estatura=" + estatura +
                ", nombre='" + nombre + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }

}

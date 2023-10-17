public class Estudiante extends Persona {
    private String codigoEstudiante;
    private String programaEstudios;
    private String residenciaUniv;

    public Estudiante() {

    }

    public Estudiante(String codigoEstudiante, String programaEstudios, String residenciaUniv) {
        this.codigoEstudiante = codigoEstudiante;
        this.programaEstudios = programaEstudios;
        this.residenciaUniv = residenciaUniv;
    }

    public Estudiante(String dni, String nombre, String apellido, Double estatura, String ocupacion, String codigoEstudiante, String programaEstudios, String residenciaUniv) {
        super(dni, nombre, apellido, estatura, ocupacion);
        this.codigoEstudiante = codigoEstudiante;
        this.programaEstudios = programaEstudios;
        this.residenciaUniv = residenciaUniv;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getProgramaEstudios() {
        return programaEstudios;
    }

    public void setProgramaEstudios(String programaEstudios) {
        this.programaEstudios = programaEstudios;
    }

    public String getResidenciaUniv() {
        return residenciaUniv;
    }

    public void setResidenciaUniv(String residenciaUniv) {
        this.residenciaUniv = residenciaUniv;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigoEstudiante='" + codigoEstudiante + '\'' +
                ", programaEstudios='" + programaEstudios + '\'' +
                ", residenciaUniv='" + residenciaUniv + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estatura=" + estatura +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }

    @Override
    public String saludar() {
        return "Hola soy la clase Estudiante";
    }
}

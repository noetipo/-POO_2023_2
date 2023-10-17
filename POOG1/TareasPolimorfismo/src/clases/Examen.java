package clases;

import java.time.LocalDate;

public class Examen extends Tarea {
    private String curso;
    private Double nota;

    public Examen() {

    }

    public Examen(String curso, Double nota) {
        this.curso = curso;
        this.nota = nota;
    }

    public Examen(Integer id, String titulo, String descripcion, LocalDate fInicio, LocalDate fFin, String curso) {
        super(id, titulo, descripcion, fInicio, fFin);
        this.curso = curso;
        this.nota = 0.0;
    }
}

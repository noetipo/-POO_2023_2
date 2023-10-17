package clases;

import java.time.LocalDate;

public class TareaComun extends Tarea {
    private String curso;
    private String notaTextual;

    public TareaComun() {

    }

    public TareaComun(String curso, String notaTextual) {
        this.curso = curso;
        this.notaTextual = notaTextual;
    }

    public TareaComun(Integer id, String titulo, String descripcion, LocalDate fInicio, LocalDate fFin, String curso, String notaTextual) {
        super(id, titulo, descripcion, fInicio, fFin);
        this.curso = curso;
        this.notaTextual = notaTextual;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNotaTextual() {
        return notaTextual;
    }

    public void setNotaTextual(String notaTextual) {
        this.notaTextual = notaTextual;
    }
}

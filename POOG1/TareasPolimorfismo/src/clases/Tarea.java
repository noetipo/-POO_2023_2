package clases;

import java.time.LocalDate;

public class Tarea {
    protected Integer id;
    protected String titulo;
    protected String descripcion;
    protected LocalDate fInicio;
    protected LocalDate fFin;
    protected Integer estado; //0=  no realizado 1= realizado

    public Tarea() {
    }

    public Tarea(Integer id, String titulo, String descripcion,
                 LocalDate fInicio, LocalDate fFin) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.estado = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFin() {
        return fFin;
    }

    public void setfFin(LocalDate fFin) {
        this.fFin = fFin;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public void setRealizado() {
        this.estado = 1;
    }

    public String getReporte() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                ", estado=" + estado +
                '}';
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                ", estado=" + estado +
                '}';
    }
}

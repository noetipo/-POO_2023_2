package com.example.sistemaventas.modelo.dominio;

import java.util.Date;

public class Producto extends Categoria {
    private Integer idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Date fechaCreacionProducto;
    private Double precio;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Date getFechaCreacionProducto() {
        return fechaCreacionProducto;
    }

    public void setFechaCreacionProducto(Date fechaCreacionProducto) {
        this.fechaCreacionProducto = fechaCreacionProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", fechaCreacionProducto=" + fechaCreacionProducto +
                ", precio=" + precio +
                ", id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}

package com.example.sistemaventas.modelo.dominio;

import java.util.Date;
import java.util.List;

public class Venta extends Cliente {
    private Integer idVenta;
    private String serieVenta;
    private Integer numeroVenta;
    private Double baseImponibleVenta;
    private Double igvVenta;
    private Double totalVenta;
    private Date fechaCreacionVenta;
    private List<VentaDetalle> ventaDetalles;


    public Integer getIdVenta() {
        return idVenta;
    }


    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }


    public String getSerieVenta() {
        return serieVenta;
    }


    public void setSerieVenta(String serieVenta) {
        this.serieVenta = serieVenta;
    }


    public Integer getNumeroVenta() {
        return numeroVenta;
    }


    public void setNumeroVenta(Integer numeroVenta) {
        this.numeroVenta = numeroVenta;
    }


    public Double getBaseImponibleVenta() {
        return baseImponibleVenta;
    }


    public void setBaseImponibleVenta(Double baseImponibleVenta) {
        this.baseImponibleVenta = baseImponibleVenta;
    }


    public Double getIgvVenta() {
        return igvVenta;
    }


    public void setIgvVenta(Double igvVenta) {
        this.igvVenta = igvVenta;
    }


    public Double getTotalVenta() {
        return totalVenta;
    }


    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }


    public Date getFechaCreacionVenta() {
        return fechaCreacionVenta;
    }


    public void setFechaCreacionVenta(Date fechaCreacionVenta) {
        this.fechaCreacionVenta = fechaCreacionVenta;
    }


    public List<VentaDetalle> getVentaDetalles() {
        return ventaDetalles;
    }


    public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }
}

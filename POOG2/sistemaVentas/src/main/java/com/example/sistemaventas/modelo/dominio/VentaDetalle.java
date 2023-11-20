package com.example.sistemaventas.modelo.dominio;

public class VentaDetalle extends Producto {
    private Integer idVentaDetalle;
    private Double cantidadVentaDetalle;
    private Double precioUnitarioVentaDetalle;
    private Double baseImponibleVentaDetalle;
    private Double igvVentaDetalle;
    private Double totalVentaDetalle;


    public Integer getIdVentaDetalle() {
        return idVentaDetalle;
    }


    public void setIdVentaDetalle(Integer idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }


    public Double getCantidadVentaDetalle() {
        return cantidadVentaDetalle;
    }


    public void setCantidadVentaDetalle(Double cantidadVentaDetalle) {
        this.cantidadVentaDetalle = cantidadVentaDetalle;
    }


    public Double getPrecioUnitarioVentaDetalle() {
        return precioUnitarioVentaDetalle;
    }


    public void setPrecioUnitarioVentaDetalle(Double precioUnitarioVentaDetalle) {
        this.precioUnitarioVentaDetalle = precioUnitarioVentaDetalle;
    }


    public Double getBaseImponibleVentaDetalle() {
        return baseImponibleVentaDetalle;
    }


    public void setBaseImponibleVentaDetalle(Double baseImponibleVentaDetalle) {
        this.baseImponibleVentaDetalle = baseImponibleVentaDetalle;
    }


    public Double getIgvVentaDetalle() {
        return igvVentaDetalle;
    }


    public void setIgvVentaDetalle(Double igvVentaDetalle) {
        this.igvVentaDetalle = igvVentaDetalle;
    }


    public Double getTotalVentaDetalle() {
        return totalVentaDetalle;
    }


    public void setTotalVentaDetalle(Double totalVentaDetalle) {
        this.totalVentaDetalle = totalVentaDetalle;
    }


    @Override
    public String toString() {
        return "VentaDetalle{" +
                "idVentaDetalle=" + idVentaDetalle +
                ", cantidadVentaDetalle=" + cantidadVentaDetalle +
                ", precioUnitarioVentaDetalle=" + precioUnitarioVentaDetalle +
                ", baseImponibleVentaDetalle=" + baseImponibleVentaDetalle +
                ", igvVentaDetalle=" + igvVentaDetalle +
                ", totalVentaDetalle=" + totalVentaDetalle +
                '}';
    }
}


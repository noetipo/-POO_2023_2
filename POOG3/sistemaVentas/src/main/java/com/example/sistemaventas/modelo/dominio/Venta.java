package com.example.sistemaventas.modelo.dominio;

import java.util.List;

public class Venta extends Cliente{
    protected  Integer id;
    protected Double pu;
    protected Double bi;
    protected Double igv;
    protected Double total;

    protected List<VentaDetalle> ventaDetalles;
}

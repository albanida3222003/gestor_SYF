package com.unu.beans;

import java.util.Date;

public class Producciones {
    private int idproduccion;
    private Date fechaProduccion;
    private int cantidad;
    private int idEmpleado;
    private int idProducto;
    private int idDetalleSuministro;

    // Constructor con parámetros
    public Producciones(int idproduccion, Date fechaProduccion, int cantidad, int idEmpleado, int idProducto, int idDetalleSuministro) {
        this.idproduccion = idproduccion;
        this.fechaProduccion = fechaProduccion;
        this.cantidad = cantidad;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.idDetalleSuministro = idDetalleSuministro;
    }

    // Constructor vacío
    public Producciones() {
        this(0, null, 0, 0, 0, 0);
    }

    // Métodos getter y setter
    public int getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(int idproduccion) {
        this.idproduccion = idproduccion;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdDetalleSuministro() {
        return idDetalleSuministro;
    }

    public void setIdDetalleSuministro(int idDetalleSuministro) {
        this.idDetalleSuministro = idDetalleSuministro;
    }
}

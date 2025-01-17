package com.unu.beans;

import java.math.BigDecimal;
import java.sql.Date;

public class Ventas {
    private int idventas;
    private Date fecha;
    private int cantidad;
    private BigDecimal precio;
    private BigDecimal totalCoste;  // Calculado automáticamente por la base de datos
    private int idProducto;
    private int idConsumidor;
    private int idEmpleado;

    // Constructor con parámetros
    public Ventas(int idventas, Date fecha, int cantidad, BigDecimal precio, BigDecimal totalCoste, int idProducto, int idConsumidor, int idEmpleado) {
        this.idventas = idventas;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.totalCoste = totalCoste;
        this.idProducto = idProducto;
        this.idConsumidor = idConsumidor;
        this.idEmpleado = idEmpleado;
    }

    // Constructor vacío
    public Ventas() {
        this(0, null, 0, BigDecimal.ZERO, BigDecimal.ZERO, 0, 0, 0);
    }

    // Métodos getter y setter
    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getTotalCoste() {
        return totalCoste;
    }

    public void setTotalCoste(BigDecimal totalCoste) {
        this.totalCoste = totalCoste;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}

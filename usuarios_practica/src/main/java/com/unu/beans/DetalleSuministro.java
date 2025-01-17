package com.unu.beans;

public class DetalleSuministro {
    private int iddetalleSuministro;
    private String tipoProducto;
    private int cantidad;
    private double precio;
    private double totalCoste;
    private int stock;
    private int idProveedor;

    // Constructor completo
    public DetalleSuministro(int iddetalleSuministro, String tipoProducto, int cantidad, double precio, int stock, int idProveedor) {
        this.iddetalleSuministro = iddetalleSuministro;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.totalCoste = cantidad * precio;  // Calcular total coste
        this.stock = stock;
        this.idProveedor = idProveedor;
    }

    // Constructor vacío
    public DetalleSuministro() {
        this(0, "", 0, 0.0, 0, 0);
    }

    // Getters y Setters
    public int getIddetalleSuministro() {
        return iddetalleSuministro;
    }

    public void setIddetalleSuministro(int iddetalleSuministro) {
        this.iddetalleSuministro = iddetalleSuministro;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.totalCoste = this.cantidad * this.precio;  // Actualizar total coste cuando cambia la cantidad
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        this.totalCoste = this.cantidad * this.precio;  // Actualizar total coste cuando cambia el precio
    }

    public double getTotalCoste() {
        return totalCoste;
    }

    public void setTotalCoste(double totalCoste) {
        this.totalCoste = totalCoste;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}

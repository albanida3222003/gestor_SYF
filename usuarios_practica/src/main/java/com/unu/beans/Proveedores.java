package com.unu.beans;

public class Proveedores {
    private int idproveedor;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    // Constructor con parámetros
    public Proveedores(int idproveedor, String nombre, String correo, String telefono, String direccion) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Constructor vacío
    public Proveedores() {
        this(0, "", "", "", "");
    }

    // Métodos getter y setter
    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

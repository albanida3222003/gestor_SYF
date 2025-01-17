package com.unu.beans;

public class Consumidor {
    private int idconsumidor;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    // Constructor con parámetros
    public Consumidor(int idconsumidor, String nombre, String telefono, String correo, String direccion) {
        this.idconsumidor = idconsumidor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Constructor vacío
    public Consumidor() {
        this(0, "", "", "", "");
    }

    // Métodos getter y setter
    public int getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(int idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

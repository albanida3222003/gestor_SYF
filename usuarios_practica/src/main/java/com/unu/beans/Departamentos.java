package com.unu.beans;

import java.math.BigDecimal;

public class Departamentos {
    private int iddepartamento;
    private String nombre;
    private BigDecimal salario;
    private byte horasSemanales;

    public Departamentos(int iddepartamento, String nombre, BigDecimal salario, byte horasSemanales) {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
        this.salario = salario;
        this.horasSemanales = horasSemanales;
    }

    public Departamentos() {
        this(0, "", BigDecimal.ZERO, (byte) 0);
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public byte getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(byte horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
}
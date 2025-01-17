package com.unu.beans;

import java.sql.Date;

public class Contratos {
    private int idcontrato;
    private Date fechaComienzo;
    private Date fechaFin;
    private String vigencia;
    private int idEmpleado;
    private int idDepartamento;

    // Constructor con parámetros
    public Contratos(int idcontrato, Date fechaComienzo, Date fechaFin, String vigencia, int idEmpleado, int idDepartamento) {
        this.idcontrato = idcontrato;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.vigencia = vigencia;
        this.idEmpleado = idEmpleado;
        this.idDepartamento = idDepartamento;
    }

    // Constructor vacío
    public Contratos() {
        this(0, null, null, "", 0, 0);
    }

    // Métodos getter y setter
    public int getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(int idcontrato) {
        this.idcontrato = idcontrato;
    }

    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}

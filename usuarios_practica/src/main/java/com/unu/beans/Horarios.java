package com.unu.beans;

public class Horarios {
    private int idhorario;
    private String horaInicio;
    private String horaFin;
    private String dia;
    private int idContrato;

    // Constructor con parámetros
    public Horarios(int idhorario, String horaInicio, String horaFin, String dia, int idContrato) {
        this.idhorario = idhorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
        this.idContrato = idContrato;
    }

    // Constructor por defecto
    public Horarios() {
        this(0, "", "", "", 0);
    }

    // Getters y Setters
    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }
}

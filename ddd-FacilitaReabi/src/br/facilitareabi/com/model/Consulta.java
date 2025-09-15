package br.facilitareabi.com.model;

import br.facilitareabi.com.enums.StatusConsultaEnum;

import java.time.LocalDate;
import java.util.Date;

public class Consulta {
    //atributtes
    private int id;
    private LocalDate dataConsulta;
    private StatusConsultaEnum StatusConsulta;
    private String motivoFalta;

    //Construtor

    public Consulta() {
    }

    public Consulta(int id, LocalDate dataConsulta, StatusConsultaEnum statusConsulta, String motivoFalta) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        StatusConsulta = statusConsulta;
        this.motivoFalta = motivoFalta;
    }

    //Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public StatusConsultaEnum getStatusConsulta() {
        return StatusConsulta;
    }

    public void setStatusConsulta(StatusConsultaEnum statusConsulta) {
        StatusConsulta = statusConsulta;
    }

    public String getMotivoFalta() {
        return motivoFalta;
    }

    public void setMotivoFalta(String motivoFalta) {
        this.motivoFalta = motivoFalta;
    }
}

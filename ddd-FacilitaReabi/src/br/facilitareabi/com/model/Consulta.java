package br.facilitareabi.com.model;

import br.facilitareabi.com.enums.StatusConsultaEnum;

import java.util.Date;

public class Consulta {
    //atributtes
    private int id;
    private Date dataConsulta;
    private StatusConsultaEnum StatusConsulta;
    private String motivoFalta;

    //Construtor

    public Consulta() {
    }

    public Consulta(int id, Date dataConsulta, StatusConsultaEnum statusConsulta, String motivoFalta) {
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

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
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

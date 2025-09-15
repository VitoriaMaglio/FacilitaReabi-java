package br.facilitareabi.com.service;

import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;

import java.time.LocalDate;

public interface ConsultaService {
    boolean verificarAptoParaConsulta(Paciente paciente);
    void remarcarConsulta(Consulta consulta, LocalDate novaData);
}

//alterar a data da consulta e atualizar status.

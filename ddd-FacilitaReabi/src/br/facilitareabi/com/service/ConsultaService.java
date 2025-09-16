package br.facilitareabi.com.service;

import br.facilitareabi.com.dao.ConsultaDao;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;

import java.time.LocalDate;

public interface ConsultaService {
    boolean verificarAptoParaConsulta(Paciente paciente);
    void remarcarConsulta(Consulta consulta, LocalDate novaData, String motivoFalta);
    void cancelarConsulta(Consulta consulta, String motivoFalta);
    ConsultaDao consultaDao = new ConsultaDao();
    public void cadastrarConsulta(Consulta consulta);
}

//alterar a data da consulta e atualizar status.
//Paciente é apto para consulta se tiver internet,camêra,mic, se quiser fazer consultas das especializações certas e se não tiver vulnerabilidades
//Remarcar consulta se o paciente n tiver disponibilidade para o dia if consulta.status == remarcar gere uma nova data, pergunta o motivo e coloca o novo status remarcado para dia.
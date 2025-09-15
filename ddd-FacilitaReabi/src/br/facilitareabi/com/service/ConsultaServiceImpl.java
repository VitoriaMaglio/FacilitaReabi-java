package br.facilitareabi.com.service;

import br.facilitareabi.com.enums.StatusConsultaEnum;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;

import java.time.LocalDate;

public class ConsultaServiceImpl implements ConsultaService {
    @Override
    public boolean verificarAptoParaConsulta(Paciente paciente) {
        // Lógica para checar restrições
        // Regra de aptidão: se vulnerabilidade == "Não", então não é apto
        if (paciente.getVulnerabilidade() != null
                && paciente.getVulnerabilidade().equalsIgnoreCase("Não")) {
            return false;
        }
        return true;
    }

    @Override
    public void remarcarConsulta(Consulta consulta, LocalDate novaData) {
        if(consulta.getStatusConsulta().equals("REMARCAR"));
            consulta.setDataConsulta(novaData);
            consulta.setStatusConsulta(StatusConsultaEnum.valueOf("Agendada"));
    }
}
//cham o método remarcarconsulta

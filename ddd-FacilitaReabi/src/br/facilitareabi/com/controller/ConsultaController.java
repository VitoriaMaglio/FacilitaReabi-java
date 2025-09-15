package br.facilitareabi.com.controller;

import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.service.ConsultaService;
import br.facilitareabi.com.service.ConsultaServiceImpl;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;

public class ConsultaController {
    //chama o serviçop e DAO para atualzar banco
    private ConsultaService consultaService = new ConsultaServiceImpl(); // Dependência do service Crie uma instância concreta de ConsultaService e guarde ela nessa variável de interface

    public void verificarPaciente(Paciente paciente) {
        if (consultaService.verificarAptoParaConsulta(paciente)) {
            System.out.println("Paciente apto para teleconsulta.");
        } else {
            System.out.println("Paciente NÃO está apto para teleconsulta.");
        }
    }

    public void remarcarConsulta(Consulta consulta, LocalDate novaData){
        if(consultaService.remarcarConsulta(consulta, novaData));
        System.out.printf("Digite a data da sua nova consulta");
        //substituir data e guardar no banco
        //registrar motivo
        //mostrar status ;

    }
}

package br.facilitareabi.com.models;

import br.facilitareabi.com.enums.StatusAgendamentoEnum;
import java.util.Scanner;

public class Consulta  {
    // Atributos
    protected String dataHora;
    protected StatusAgendamentoEnum status;
    protected String especialidade;
    private boolean presencaConfirmada = false;

    // Getters e Setters
    public String getDataHora() {return dataHora;}
    public void setDataHora(String dataHora) {this.dataHora = dataHora;}
    public StatusAgendamentoEnum getStatus() {return status;}
    public void setStatus(StatusAgendamentoEnum status) {this.status = status;}
    public String getEspecialidade() {return especialidade;}
    public void setEspecialidade(String especialidade) {this.especialidade = especialidade;}
    public boolean isPresencaConfirmada() {return presencaConfirmada;}
    public void setPresencaConfirmada(boolean presencaConfirmada) {this.presencaConfirmada = presencaConfirmada;}

    // Métodos
    public void confirmarPresenca(boolean confirmacao) {
        this.presencaConfirmada = confirmacao;
        if (confirmacao) {
            System.out.println("\nPresença confirmada com sucesso para dia " + getDataHora() + " para a especialidade " + getEspecialidade());
        } else {
            System.out.println("\nPresença não confirmada.");
        }
    }
    public void atualizarStatusConsulta(Scanner leitor) {
        System.out.println("\nEscolha o novo status da consulta:\n1 - AGENDADA\n2 - CANCELADA\n3 - REALIZADA");
        String escolha = leitor.nextLine();
        switch (escolha) {
            case "1": setStatus(StatusAgendamentoEnum.AGENDADA);
            break;
            case "2": setStatus(StatusAgendamentoEnum.CANCELADA);
            break;
            case "3": setStatus(StatusAgendamentoEnum.REALIZADA);
            break;
            default: System.out.println("Status inválido");
            return;
        }
        System.out.println("Status atualizado: " + getStatus());
    }
}








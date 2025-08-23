package br.facilitareabi.com.models;

import br.facilitareabi.com.enums.StatusAgendamentoEnum;

public class FinalizarAtendimento {
    // Método
    public void finalizarCodigo(Paciente paciente, Consulta consulta) {
        System.out.println("\n==========================================");
        System.out.println("Resumo do Atendimento:");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Idade: " + paciente.getIdade());
        System.out.println("CPF: " + paciente.getCpf());
        System.out.println("Telefone: " + paciente.getTelefone());
        System.out.println("Email: " + paciente.getEmail());

        if (consulta.isPresencaConfirmada()) {
            consulta.setStatus(StatusAgendamentoEnum.REALIZADA);
            System.out.println("Presença confirmada ");
        } else {
            consulta.setStatus(StatusAgendamentoEnum.CANCELADA);
            System.out.println("Presença não confirmada ");
        }
        System.out.println("Status final: " + consulta.getStatus());
        System.out.println("==========================================");
        System.out.println("Obrigado por utilizar nosso app!");
    }
}

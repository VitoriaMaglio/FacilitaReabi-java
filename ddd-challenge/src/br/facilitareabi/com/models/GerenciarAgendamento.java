package br.facilitareabi.com.models;

import br.facilitareabi.com.enums.StatusAgendamentoEnum;

import java.util.Scanner;

public class GerenciarAgendamento {
    Scanner leitor = new Scanner(System.in);
    private Consulta consulta;

    public GerenciarAgendamento() {
        this.consulta = new Consulta();
    }
    public void atualizarStatus() {
        consulta.atualizarStatusConsulta(leitor);
    }

    // Métodos
    public String agendarConsulta(Usuario usuario) {
        System.out.println("Você deseja marcar uma teleconsulta conosco?");
        String resposta = leitor.nextLine();
        switch (resposta) {
            case "Sim":
                System.out.println("Ok, vamos agendar o dia e o horário! ");
                this.primeiraConsulta();
                this.consulta();
                this.desejaNotificacao();
                return "Sim";
            case "Não":
                System.out.println("Tudo bem, você será redirecionado para o menu.");
                return "Não";
            default:
                System.out.println("Opção inválida, retornando ao menu.");
                return "Não";
        }
    }

    public void primeiraConsulta() {
        System.out.println(" \n==========================================");
        String termoConsentimento = "Declaro que li e concordo com o uso dos meus dados para fins de atendimento e melhoria do serviço.";
        String lido = "";
        System.out.println(termoConsentimento);
        System.out.println(" \n==========================================");
        while (true) {
            System.out.println("\n" +"Aceita o termo? (Sim/Não):");
            lido = leitor.nextLine();
            if (lido.equalsIgnoreCase("Sim")) {
                System.out.println("Resposta registrada. Sua consulta poderá ser realizada.");
                break;
            } else if (lido.equalsIgnoreCase("Não")) {
                System.out.println("Ao não aceitar o termo, sua consulta não poderá ser realizada.");
            } else {
                System.out.println("Resposta inválida. Digite apenas 'Sim' ou 'Não'.");
            }
        }
    }

    public void consulta(){
        System.out.println("Digite o dia e o horário que você deseja agendar sua consulta: ");
        consulta.setDataHora(leitor.nextLine());
        consulta.setStatus(StatusAgendamentoEnum.AGENDADA);
        System.out.println("Digite a especialidade:");
        consulta.setEspecialidade(leitor.nextLine());
    }


    public String desejaNotificacao() {
        System.out.println("Você deseja receber notificações sobre o status das suas teleconsultas? ");
        String notificacao = leitor.nextLine();
        String mensagem = "Você tem uma teleconsulta marcada para o dia " + consulta.getDataHora();


        switch (notificacao) {
            case "Sim":
                System.out.println("Ótima escolha, a partir de agora você será notificado sobre informações importantes!");
                System.out.println(mensagem);
                break;
            case "Não":
                System.out.println("Que pena! Notificações de lembrete te ajudam a não faltar nas consultas. Quer recebê-las? ");
                String certeza = leitor.nextLine();
                if (certeza.equalsIgnoreCase("Sim")) {
                    System.out.println("Ótima escolha, a partir de agora você será notificado sobre informações importantes!");
                    System.out.println(mensagem);
                } else {
                    System.out.println("Ok, você não irá ser notificado.");
                }
                break;
            default:
                System.out.println("Resposta inválida, assumindo que não deseja notificações.");
                break;
        }
        return mensagem;
    }
    public void teleconsulta() {
        System.out.println("Você já tem uma teleconsulta agendada?");
        String resposta = leitor.nextLine();
        if (resposta.equalsIgnoreCase("Sim")) {
            System.out.println("Qual o dia e o horário da sua consulta?");
            consulta.setDataHora(leitor.nextLine());
            consulta.setStatus(StatusAgendamentoEnum.AGENDADA);
            System.out.println("Qual é a especialidade da sua consulta?");
            consulta.setEspecialidade(leitor.nextLine());
            System.out.println("Sua consulta é dia " + consulta.getDataHora() + " e a especialidade é " + consulta.getEspecialidade()+".");
            return;
        } else {
            System.out.println("Ok, você será direcionado para a aba de agendar consultas.");
            this.primeiraConsulta();
            this.consulta();
            this.desejaNotificacao();
        }
    }
}

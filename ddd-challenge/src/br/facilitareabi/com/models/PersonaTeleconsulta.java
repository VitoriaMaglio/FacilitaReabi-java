package br.facilitareabi.com.models;

import java.util.Scanner;

public class PersonaTeleconsulta extends Usuario{
    // Métodos

    public String personaIdeal(Paciente paciente, Scanner leitor) {
        System.out.println(" \n==========================================");
        int pontuacao = 0;

        System.out.println("\n==========================================");
        System.out.println(paciente.getNome() + ", antes de tudo, nossa equipe deseja ter certeza de que você é o paciente ideal para atendimento online!");
        System.out.println("Para isso, precisamos que você responda mais algumas perguntas que vão ajudar na nossa identificação.");
        System.out.print("\nVocê possui acesso estável à internet? (sim/não): ");
        String resposta1 = leitor.nextLine().trim();
        if (resposta1.equalsIgnoreCase("sim")) {
            pontuacao++;
        }
        System.out.print("Você tem um dispositivo com câmera e microfone funcionando? (sim/não): ");
        String resposta2 = leitor.nextLine().trim();
        if (resposta2.equalsIgnoreCase("sim")) {
            pontuacao++;
        }
        System.out.print("Você se sente confortável em compartilhar informações pessoais online? (sim/não): ");
        String resposta3 = leitor.nextLine().trim();
        if (resposta3.equalsIgnoreCase("sim")) {
            pontuacao++;
        }
        System.out.print("Você possui alguma condição médica que requer atendimento presencial imediato? (sim/não): ");
        String resposta4 = leitor.nextLine().trim();
        if (resposta4.equalsIgnoreCase("não")) {
            pontuacao++;
        }
        System.out.print("Você deseja tratamento médico em Psicologia e/ou Fonoaudiologia? (sim/não): ");
        String resposta5 = leitor.nextLine().trim();
        boolean interesseEmPsicologiaOuFono = resposta5.equalsIgnoreCase("sim");
        if (pontuacao >= 3) {
            System.out.println("\nParabéns, " + paciente.getNome() + "! Você é um paciente ideal para atendimento online.");
        } else {
            System.out.println("\n" + paciente.getNome() + ", com base em suas respostas, o atendimento online pode não ser o mais adequado para você no momento." +
                    "\n" + "Recomendamos que você procure pessoalmente nossa equipe médica para realizar seus tratamentos."+
                    "\n");
        }
        if (interesseEmPsicologiaOuFono && pontuacao >= 3) {
            System.out.println("\nAs especialidades de Psicologia e Fonoaudiologia são especialidades adequadas para atendimento online, logo," +
                    "\n" + "é um prazer te atender em um consulta on-line, por isso não se preocupe se você tem vergonha ou dificuldade de se abrir com nossa equipe,"+
                    "\n" + "Durante o uso do nosso aplicativo vamos te ajudar!");
        } else {
            System.out.println("\nEntendido. Caso tenha interesse em Psicologia ou Fonoaudiologia, saiba que essas especialidades são adequadas para atendimento online.");
        }
        return null;
    }
}

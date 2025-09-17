package br.facilitareabi.com.controller;


import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.service.PacienteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PacienteController {
    private PacienteService pacienteService = new PacienteService();
    //declarar um obj do tipo service para utilizar lógica de negócio

    //Recebe os dados do usuário e chama in
    public Paciente cadastrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente();

        System.out.println("Digite o nome:");
        paciente.setNome(scanner.nextLine());
        
        System.out.println("Digite o CPF:");
        paciente.setCpf(scanner.nextLine());

        System.out.println("Digite sua data de nascimento:");
        String dataDigitada = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate novaData = LocalDate.parse(dataDigitada, fmt);

        // seta a data no paciente!
        paciente.setDataNascimento(novaData);

        System.out.println("Digite o email:");
        paciente.setEmail(scanner.nextLine());

        System.out.println("Digite o telefone:");
        paciente.setTelefone(scanner.nextLine());

        String[] vulnerabilidades = {
                "Falta de acesso à internet ou conexão instável",
                "Ausência de dispositivos adequados (smartphone, tablet, computador)",
                "Baixa habilidade digital ou dificuldade em usar aplicativos",
                "Falta de privacidade ou ambiente inadequado para a consulta",
                "Condições de saúde que dificultam interação com o dispositivo (ex.: tremores, dores)",
                "Falta de conhecimento sobre a teleconsulta e seu funcionamento"
        };



        System.out.printf(paciente.getNome()+" possui algum tipo de vulnerabilidade?");
        String resp = scanner.nextLine();

        if (resp.equalsIgnoreCase("Sim")) {
            // Mostra opções
            System.out.println("Digite o número que corresponde à sua vulnerabilidade:");
            for (int i = 0; i < vulnerabilidades.length; i++) {
                System.out.println((i + 1) + ". " + vulnerabilidades[i]);
            }
            int opcao = 0;// variável que vai guardar o número digitado pelo paciente

            while (true) { // loop infinito que só termina quando o número for válido
                System.out.print("Número da vulnerabilidade: ");
                try {
                    // Lê a linha digitada pelo paciente e tenta converter para número inteiro
                    opcao = Integer.parseInt(scanner.nextLine());

                    // Verifica se o número está dentro do intervalo válido
                    if (opcao >= 1 && opcao <= vulnerabilidades.length) {
                        break; // se for válido, sai do loop
                    } else {
                        System.out.println("Número inválido, tente novamente."); // fora do intervalo
                    }

                } catch (NumberFormatException e) {
                    // Caso o paciente digite algo que não seja número (ex: "abc")
                    System.out.println("Digite apenas números.");
                }
            }
            // Guardar a vulnerabilidade selecionada no objeto paciente
            String vulnerabilidadeSelecionada = vulnerabilidades[opcao - 1];
            paciente.setVulnerabilidade(vulnerabilidadeSelecionada);
            System.out.println("Vulnerabilidade registrada: " + vulnerabilidadeSelecionada);

            // Salvar diretamente no banco
            //pacienteDao.atualizarVulnerabilidade(paciente);

        } else {
                paciente.setVulnerabilidade("Não"); // sem vulnerabilidade
            //pacienteDao.atualizarVulnerabilidade(paciente);
        }
        pacienteService.cadastrarPaciente(paciente);
        return paciente;
    }


        // Chama o service para validar e salvar
        //pacienteService.cadastrarPaciente(paciente);
    }




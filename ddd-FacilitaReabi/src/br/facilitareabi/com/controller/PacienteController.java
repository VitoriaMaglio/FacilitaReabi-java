package br.facilitareabi.com.controller;

import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.service.PacienteService;

import java.util.Scanner;

public class PacienteController {
    private PacienteService pacienteService = new PacienteService();
    //declarar um obj do tipo service para utilizar lógica de negócio

    //Recebe os dados do usuário e chama in
    public void cadastrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente();

        System.out.println("Digite o ID do paciente:");
        paciente.setId(scanner.nextInt());
        scanner.nextLine(); // limpar buffer

        System.out.println("Digite o nome:");
        paciente.setNome(scanner.nextLine());

        System.out.println("Digite o CPF:");
        paciente.setCpf(scanner.nextLine());

        System.out.println("Digite o email:");
        paciente.setEmail(scanner.nextLine());

        System.out.println("Digite o telefone:");
        paciente.setTelefone(scanner.nextLine());

        System.out.println("Digite a vulnerabilidade:");
        paciente.setVulnerabilidade(scanner.nextLine());

        // Chama o service para validar e salvar
        pacienteService.cadastrarPaciente(paciente);
    }


}

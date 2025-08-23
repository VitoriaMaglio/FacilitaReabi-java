package br.facilitareabi.com.models;

import java.util.Scanner;

public class Menu  {
    private Scanner scanner;
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }
    // Métodos
    public void cadastroObrigatorio(Paciente paciente){
        System.out.println("==========================================");
        System.out.println(" \nBem-vindo ao apliativo do IMREA-HCFMUSP !! ");
        System.out.println(" \n==========================================");
        System.out.println("\nPara continuar tendo acesso aos nossos serviços, por favor, realize seu cadastro! " );
        System.out.println(" \n==========================================");
        paciente.realizarCadastro(scanner);
        System.out.println("Obrigado por fazer seu cadastro, agora você tem livre acesso aos nossos serviços! " );
    }

    public String menu(Paciente paciente) {
        Consulta consulta = new Consulta();
        String opcao = "";
        while (true) {
            System.out.println(" \n==========================================");
            System.out.println(" \nEscolha, dentre as opções abaixo, o que você deseja fazer no app: \n1- Realizar cadastro\n2- Teleconsulta"
                    +"\n3- FacilitaReabi \n4- Dúvidas frequentes \n5- Sair ");
            opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    if (paciente.getNome() != null){
                        System.out.println(paciente.getNome() +  " " + "você já possui cadastro! Escolha outra opção do menu:");
                        return menu(paciente);
                    } else {
                        System.out.println("\nOk! Você será direcionado para a aba de cadastros..");
                        paciente.realizarCadastro(scanner);
                    }
                    return "1";
                case "2":
                    System.out.println("\nOk! Você será direcionado para a aba de teleconsultas..");
                    return "2";
                case "3":
                    System.out.println("\nOk! Você será direcionado para a aba de FacilitaReabi");
                    return "3";
                case "4":
                    System.out.println("\nOk! Você será direcionado para a aba de perguntas frequentes..");
                    return "4";
                case "5":
                    System.out.println("\n==========================================");
                    System.out.println(paciente.getNome()+ " você será direcionado para a aba de verificação de teleconsultas antes de encerrar o programa");
                    return "5";
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;

            }
        }
    }
}

package br.facilitareabi.com.tests;

import br.facilitareabi.com.controller.ConsultaController;
import br.facilitareabi.com.controller.PacienteController;
import br.facilitareabi.com.controller.UsuarioController;
import br.facilitareabi.com.dao.ConsultaDao;
import br.facilitareabi.com.dao.PacienteDao;
import br.facilitareabi.com.dao.UsuarioDao;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.model.Usuario;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    //Método para cadastro-leitura de paciente
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consulta consulta = new Consulta();
        ConsultaDao consultaDao = new ConsultaDao();
        ConsultaController consultaController = new ConsultaController();
        Paciente paciente = new Paciente();
        PacienteDao pacienteDao = new PacienteDao();
        PacienteController controller = new PacienteController();
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        UsuarioController usuarioController = new UsuarioController();

        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU DO SITE ===");
            System.out.println("1 - Login ou Cadastro do paciente");
            System.out.println("2 - Agendar Consulta");
            System.out.println("3 - Remarcar ou Cancelar Consulta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    controller.cadastrarPaciente();
                case "2":
                    consultaController.cadastrarConsulta();
                case "3":
                    consultaController.remarcarConsulta(consulta, consultaDao);
                case "0":
                    running = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            }
        }
    }






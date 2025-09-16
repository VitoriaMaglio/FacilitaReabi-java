package br.facilitareabi.com.controller;

import br.facilitareabi.com.dao.ConsultaDao;
import br.facilitareabi.com.enums.StatusConsultaEnum;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.service.ConsultaService;
import br.facilitareabi.com.service.ConsultaServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsultaController {


        private ConsultaService consultaService = new ConsultaServiceImpl();
        private Scanner scanner = new Scanner(System.in);

        public void verificarPaciente(Paciente paciente) {
            if (consultaService.verificarAptoParaConsulta(paciente)) {
                System.out.println("Paciente apto para teleconsulta.");
            } else {
                System.out.println("Paciente NÃO está apto para teleconsulta.");
            }
        }

        public void cadastrarConsulta() {
            Consulta consulta = new Consulta();

            System.out.printf("Vamos agendar uma teleconsulta!");
            System.out.println("Digite a data da consulta (dd/MM/yyyy):");
            String dataDigitada = scanner.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate novaData = LocalDate.parse(dataDigitada, fmt);
            consulta.setDataConsulta(novaData);

            System.out.println("Consulta agendada!");
            consulta.setStatusConsulta(StatusConsultaEnum.AGENDADA);

            consultaService.cadastrarConsulta(consulta);
        }
        public void remarcarConsulta(Consulta consulta, ConsultaDao consultaDao) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("Você deseja remarcar (1) ou cancelar (2) a consulta?");
            int opcao = leitor.nextInt();
            leitor.nextLine(); // consumir o \n

            String motivoFalta;
            LocalDate novaData = null;

            System.out.print("Digite o motivo da sua falta: ");
            motivoFalta = leitor.nextLine();

            if (opcao == 1) { // Remarcar
                System.out.print("Digite a nova data da consulta (dd/MM/yyyy): ");
                String dataDigitada = leitor.nextLine();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                novaData = LocalDate.parse(dataDigitada, fmt);

                // Chama o método do service
                consultaService.remarcarConsulta(consulta, novaData, motivoFalta);
            } else if (opcao == 2) { // Cancelar
                // Chama o método do service
                consultaService.cancelarConsulta(consulta, motivoFalta);
            } else {
                System.out.println("Opção inválida!");
                return;
            }

            // Atualiza no banco
            consultaDao.atualizarConsulta(consulta);

            System.out.println("Sua consulta está " + consulta.getStatusConsulta());
        }
        }


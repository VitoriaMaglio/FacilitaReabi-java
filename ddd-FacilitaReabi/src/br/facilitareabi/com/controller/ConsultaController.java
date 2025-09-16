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

            System.out.println("Digite o ID da consulta:");
            consulta.setId(scanner.nextInt());
            scanner.nextLine(); // limpar buffer

            System.out.println("Digite a data da consulta (dd/MM/yyyy):");
            String dataDigitada = scanner.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate novaData = LocalDate.parse(dataDigitada, fmt);
            consulta.setDataConsulta(novaData);

            System.out.println("Digite o status da consulta (AGENDADA/REMARCADA/CANCELADA):");
            consulta.setStatusConsulta(StatusConsultaEnum.valueOf(scanner.nextLine().toUpperCase()));

            System.out.println("Digite o motivo da sua falta:");
            consulta.setMotivoFalta(scanner.nextLine());

            consultaService.cadastrarConsulta(consulta);
        }
        public void remarcarConsulta(Consulta consulta, LocalDate novaData, ConsultaDao consultaDao) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("Você deseja remarcar (1) ou cancelar (2) a consulta?");
            int opcao = leitor.nextInt();
            leitor.nextLine();
            if (opcao == 1) {
                System.out.println("Digite a nova data da consulta (dd/MM/yyyy):");
                String dataDigitada = leitor.nextLine();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                novaData = LocalDate.parse(dataDigitada, fmt);
                // só atribuição, sem LocalDate na frente
                System.out.printf("Digite o motivo da sua falta:");
                String motivoFalta = leitor.nextLine();
                consulta.setDataConsulta(novaData);
                consulta.setMotivoFalta(motivoFalta);
                consulta.setStatusConsulta(StatusConsultaEnum.REMARCADA);
                System.out.println("Sua consulta está " + consulta.getStatusConsulta());
            } else {
                System.out.println("Digite o motivo da sua falta:");
                String motivoFalta = leitor.nextLine();
                consulta.setMotivoFalta(motivoFalta);
                consulta.setStatusConsulta(StatusConsultaEnum.CANCELADA);
            }
            consultaDao.atualizarConsulta(consulta);
            System.out.println("Sua consulta está " + consulta.getStatusConsulta());
        }
        }

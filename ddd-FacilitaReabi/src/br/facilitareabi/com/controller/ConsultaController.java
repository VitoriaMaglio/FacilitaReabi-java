package br.facilitareabi.com.controller;
import br.facilitareabi.com.dao.ConsultaDao;
import br.facilitareabi.com.enums.StatusConsultaEnum;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.service.ConsultaService;
import br.facilitareabi.com.service.ConsultaServiceImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public void cadastrarConsulta(Paciente paciente) {
            Consulta consulta = new Consulta();
            consulta.setPaciente(paciente);
            System.out.printf("Vamos agendar uma teleconsulta!");
            System.out.println("Digite a data da consulta (dd/MM/yyyy):");
            String dataDigitada = scanner.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate novaData = LocalDate.parse(dataDigitada, fmt);
            consulta.setDataConsulta(novaData);
            System.out.println("Digite a especialização da consulta:");
            String especializacao = scanner.nextLine();
            consulta.setEspecializacao(especializacao);
            System.out.println("Consulta agendada!");
            consulta.setStatusConsulta(StatusConsultaEnum.AGENDADA);
            consultaService.cadastrarConsulta(consulta);
        System.out.println("Lembre-se! Você tem uma consulta agendada para o dia " + consulta.getDataConsulta());
    }
    public void buscarConsulta(){
        ConsultaDao consultaDao = new ConsultaDao();
        System.out.println("Digite a data da consulta que você deseja buscar (dd/MM/yyyy): ");
        String dataDigitada = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate novaData = LocalDate.parse(dataDigitada, fmt);
            Consulta consulta = consultaDao.buscarPorData(novaData);

            if (consulta != null) {
                System.out.println("Consulta encontrada:");
                System.out.println("ID: " + consulta.getId());
                System.out.println("Data: " + consulta.getDataConsulta());
                System.out.println("Status: " + consulta.getStatusConsulta());
                System.out.println("Motivo da Falta: " + consulta.getMotivoFalta());
                System.out.println("Especialização: " + consulta.getEspecializacao());
                System.out.println("ID do Paciente: " + consulta.getPaciente().getId_paciente());
            } else {
                System.out.println("Nenhuma consulta encontrada para a data informada.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }
    public void remarcarConsulta(Consulta consulta, ConsultaDao consultaDao, Paciente paciente) {
        consulta.setPaciente(paciente);
        Scanner leitor = new Scanner(System.in);
        System.out.println("Você deseja remarcar (1) ou cancelar (2) a consulta?");
        int opcao = leitor.nextInt();
        leitor.nextLine();
        String motivoFalta = null;
        if (opcao == 1) {
            System.out.println("Digite a data da consulta que você deseja remarcar (dd/MM/yyyy): ");
            String dataCancelar = leitor.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataDigitada = LocalDate.parse(dataCancelar, fmt);
            Consulta consultaEncontrada = consultaDao.buscarPorData(dataDigitada);
            leitor.nextLine();
            System.out.print("Digite o motivo da sua falta: ");
             motivoFalta = leitor.nextLine();
             consulta.setMotivoFalta(motivoFalta);
            if (consultaEncontrada != null) {
                System.out.print("Digite a nova data da consulta (dd/MM/yyyy): ");
                String novaDataStr = leitor.nextLine();
                LocalDate novaData = LocalDate.parse(novaDataStr, fmt);
                consultaService.remarcarConsulta(consultaEncontrada, novaData, motivoFalta);
                consultaDao.atualizarConsulta(consultaEncontrada);
                consulta.setDataConsulta(novaData);
                System.out.println("Consulta remarcada com sucesso para " + novaData);
                consulta.setStatusConsulta(StatusConsultaEnum.REMARCADA);
                System.out.println("Lembre-se! Você tem uma consulta agendada para o dia " + consulta.getDataConsulta());
            } else {
                System.out.println("Nenhuma consulta encontrada nessa data.");
            }
        } else if (opcao == 2) {
            System.out.println("Digite a data da consulta que você deseja cancelar (dd/MM/yyyy): ");
            String dataCancelar = leitor.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataDigitada = LocalDate.parse(dataCancelar, fmt);
            Consulta consultaEncontrada = consultaDao.buscarPorData(dataDigitada);
            if (consultaEncontrada != null) {
                consultaService.cancelarConsulta(consultaEncontrada, motivoFalta);
                consultaDao.excluirConsultaData(consultaEncontrada.getId());
                System.out.println("Consulta cancelada com sucesso!");
                consulta.setStatusConsulta(StatusConsultaEnum.CANCELADA);
            } else {
                System.out.println("Nenhuma consulta encontrada nessa data.");
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
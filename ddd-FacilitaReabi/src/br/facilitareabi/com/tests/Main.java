package br.facilitareabi.com.tests;

import br.facilitareabi.com.dao.ConsultaDao;
import br.facilitareabi.com.dao.PacienteDao;
import br.facilitareabi.com.dao.UsuarioDao;
import br.facilitareabi.com.enums.StatusConsultaEnum;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.model.Usuario;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    //Método para cadastro-leitura de paciente
    public static Paciente leituraDados(Paciente paciente) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Digite seu id:");
        paciente.setId(leitorNum.nextInt());
        System.out.println("Digite seu nome:");
        paciente.setNome(leitor.nextLine());
        System.out.println("Digite seu CPF:");
        paciente.setCpf(leitor.nextLine());
        System.out.println("Digite sua data de nascimento:");
        String dataStr = leitor.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //criar um padrão de data
        LocalDate localDate = LocalDate.parse(dataStr, fmt);//converter a String em LocalDate
        paciente.setDataNascimento(Date.valueOf(localDate));//converter LocalDate em obj sql para salvar no banco
        System.out.println("Digite seu telefone:");
        paciente.setTelefone(leitor.nextLine());
        System.out.println("Digite seu email:");
        paciente.setEmail(leitor.nextLine());
        System.out.println("Digite sua vulnerabilidade:");
        paciente.setVulnerabilidade(leitor.nextLine());
        return paciente;
    }

    //Método para cadastro-leitura de usuario
    public static Usuario leituraDadosu(Usuario usuario) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Digite seu id:");
        usuario.setId(leitorNum.nextInt());
        System.out.println("Digite seu login:");
        usuario.setLogin(leitor.nextLine());
        System.out.println("Digite sua senha:");
        usuario.setSenha(leitor.nextLine());
        return usuario;
    }

    //Método para cadastro-leitura de consulta
    public static Consulta leituraDadosc(Consulta consulta) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Digite seu id:");
        consulta.setId(leitorNum.nextInt());
        System.out.println("Digite a data da consulta:");
        String data= leitor.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, fmt);
        consulta.setDataConsulta(Date.valueOf(localDate).toLocalDate());
        System.out.println("Digite o status da consulta:");
        String statusStr = leitor.nextLine().toUpperCase(); // garante que fique maiúsculo
        consulta.setStatusConsulta(StatusConsultaEnum.valueOf(statusStr));// valueof converte a string em enum
        System.out.println("Digite motivo de falta:");
        consulta.setMotivoFalta(leitor.nextLine());
        return consulta;
    }

    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        leituraDados(paciente);
        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.cadastrarPaciente(paciente);
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.cadastrarUsuario(usuario);
        Consulta consulta = new Consulta();
        ConsultaDao consultaDao = new ConsultaDao();
    }
}



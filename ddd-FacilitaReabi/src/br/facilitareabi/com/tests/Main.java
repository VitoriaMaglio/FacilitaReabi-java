package br.facilitareabi.com.tests;

import br.facilitareabi.com.controller.ConsultaController;
import br.facilitareabi.com.controller.PacienteController;
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
    public static void main(String[] args) {


                Consulta consulta = new Consulta();
                ConsultaDao consultaDao = new ConsultaDao();
                ConsultaController consultaController = new ConsultaController();
                PacienteController controller = new PacienteController();

                controller.cadastrarPaciente(); // chama Service internamente
                consultaController.cadastrarConsulta();
                consultaController.remarcarConsulta(consulta, null, consultaDao);
            }
        }






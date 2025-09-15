package br.facilitareabi.com.service;

import br.facilitareabi.com.dao.PacienteDao;
import br.facilitareabi.com.model.Paciente;

public class PacienteService {
    private PacienteDao pacienteDao = new PacienteDao();
    //validar dados do paciente -> criar método com Paciente de parâmetro;
    //chamar pacienteDao.cadastro
    public void cadastrarPaciente(Paciente paciente) {
        if (validarPaciente(paciente)) { // Lógica de negócio: validação
            pacienteDao.cadastrarPaciente(paciente); // DAO só salva
            System.out.println("Paciente cadastrado com sucesso!");
        } else {
            System.out.println("Paciente com dados inválidos!");
        }
    }

    //método boolean validarPaciente
    private boolean validarPaciente(Paciente paciente) {
        // Exemplo simples de validação
        return paciente.getNome() != null && !paciente.getNome().isEmpty()
                && paciente.getCpf() != null && !paciente.getCpf().isEmpty();
    }
}

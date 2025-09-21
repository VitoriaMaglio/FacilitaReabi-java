package br.facilitareabi.com.service;
import br.facilitareabi.com.dao.PacienteDao;
import br.facilitareabi.com.model.Paciente;
public class PacienteService {
    private PacienteDao pacienteDao = new PacienteDao();
    public void cadastrarPaciente(Paciente paciente) {
        if (validarPaciente(paciente)) { // Lógica de negócio: validação
            pacienteDao.cadastrarPaciente(paciente); // DAO só salva
            System.out.println("Paciente cadastrado com sucesso!");
        } else {
            System.out.println("Paciente com dados inválidos!");
        }
    }
    public boolean validarPaciente(Paciente paciente) {
        return paciente.getNome() != null && !paciente.getNome().isEmpty()
                && paciente.getCpf() != null && !paciente.getCpf().isEmpty();
    }
}

package br.facilitareabi.com.controller;
import br.facilitareabi.com.dao.PacienteDao;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.service.PacienteService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class PacienteController {
    private PacienteService pacienteService = new PacienteService();
    public Paciente cadastrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente();
        System.out.println("Digite o nome:");
        paciente.setNome(scanner.nextLine());
        System.out.println("Digite o CPF:");
        paciente.setCpf(scanner.nextLine());
        System.out.println("Digite sua data de nascimento:");
        String dataDigitada = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate novaData = LocalDate.parse(dataDigitada, fmt);
            paciente.setDataNascimento(novaData);
            System.out.println("Data registrada com sucesso: " + novaData);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido! Digite no formato dd/MM/yyyy.");
        }
        System.out.println("Digite o email:");
        paciente.setEmail(scanner.nextLine());
        System.out.println("Digite o telefone:");
        paciente.setTelefone(scanner.nextLine());
        String[] vulnerabilidades = {
                "Falta de acesso à internet ou conexão instável",
                "Ausência de dispositivos adequados (smartphone, tablet, computador)",
                "Baixa habilidade digital ou dificuldade em usar aplicativos",
                "Falta de privacidade ou ambiente inadequado para a consulta",
                "Condições de saúde que dificultam interação com o dispositivo (ex.: tremores, dores)",
                "Falta de conhecimento sobre a teleconsulta e seu funcionamento"
        };
        System.out.printf(paciente.getNome()+" possui algum tipo de vulnerabilidade?");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("Sim")) {
            System.out.println("Digite o número que corresponde à sua vulnerabilidade:");
            for (int i = 0; i < vulnerabilidades.length; i++) {
                System.out.println((i + 1) + ". " + vulnerabilidades[i]);
            }
            int opcao = 0;
            while (true) {
                System.out.print("Número da vulnerabilidade: ");
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao >= 1 && opcao <= vulnerabilidades.length) {
                        break; // se for válido, sai do loop
                    } else {
                        System.out.println("Número inválido, tente novamente."); // fora do intervalo
                    }
                } catch (NumberFormatException e) {
                    // Caso o paciente digite algo que não seja número (ex: "abc")
                    System.out.println("Digite apenas números.");
                }
            }
            String vulnerabilidadeSelecionada = vulnerabilidades[opcao - 1];
            paciente.setVulnerabilidade(vulnerabilidadeSelecionada);
            System.out.println("Vulnerabilidade registrada: " + vulnerabilidadeSelecionada);
            System.out.println("Paciente não apto para realizar consultas on-line.");
            paciente.setAptidao("Não apto");

        } else {
                paciente.setVulnerabilidade("Não");
            System.out.println("Paciente apto para realizar consultas on-line.");
            paciente.setAptidao("Apto");
        }
        pacienteService.cadastrarPaciente(paciente);
        return paciente;
    }
    public void atualizarPaciente(Paciente paciente){
        Scanner scanner = new Scanner(System.in);
        PacienteDao pacienteDao = new PacienteDao();

        System.out.println("Deseja atualizar seu cadastro?");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("Sim")){
            pacienteDao.atualizarPaciente(paciente);
        }else{
            System.out.println("Ok");
        }
    }
    public void excluirPaciente(){
        Scanner scanner = new Scanner(System.in);
        PacienteDao pacienteDao = new PacienteDao();
        Paciente paciente = new Paciente();
        System.out.println("Deseja excluir um paciente?");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("Sim")){
            pacienteDao.excluirPaciente(paciente.getId_paciente());
        }
    }
}




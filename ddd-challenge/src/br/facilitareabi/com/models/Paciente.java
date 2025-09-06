package br.facilitareabi.com.model;

import java.util.Scanner;

public class Paciente extends Usuario {
    // Método
    public void realizarCadastro(Scanner scanner) {
        cadastrarUsuario(scanner);
        exibirUsuario();
        dadoscorretos(scanner);
    }
}
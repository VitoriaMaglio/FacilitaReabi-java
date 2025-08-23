package br.facilitareabi.com.models;

import java.util.Scanner;

public class Paciente extends Usuario {
    // Método
    public void realizarCadastro(Scanner scanner) {
        cadastrarUsuario(scanner);
        exibirUsuario();
        dadoscorretos(scanner);
    }
}
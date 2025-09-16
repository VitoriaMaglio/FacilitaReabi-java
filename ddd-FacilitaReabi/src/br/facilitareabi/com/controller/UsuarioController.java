package br.facilitareabi.com.controller;

import br.facilitareabi.com.model.Usuario;
import br.facilitareabi.com.service.UsuarioService;

import java.util.Scanner;

public class UsuarioController {
    //chama o serviço, depois chama ConsultaDao para atualizar o banco:

    private UsuarioService usuarioService = new UsuarioService();
    public void cadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.println("Digite seu login:");
        usuario.setLogin(scanner.nextLine());
        System.out.println("Digite sua senha:");
        //tratar erro de ser só int,string
        usuario.setSenha(scanner.nextLine());
        usuarioService.cadastrarUsuario(usuario);
    }
}

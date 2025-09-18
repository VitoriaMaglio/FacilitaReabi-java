package br.facilitareabi.com.controller;
import br.facilitareabi.com.model.Usuario;
import br.facilitareabi.com.service.UsuarioService;
import java.util.Scanner;
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();
    public void cadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        System.out.println("Digite seu login:");
        usuario.setLogin(scanner.nextLine());
        System.out.println("Digite sua senha:");
        try{
            String senha = scanner.nextLine();
            Integer.parseInt(senha);
            System.out.println("Erro: digite uma senha com caracteres e números.");
        } catch (NumberFormatException e) {
            usuario.setSenha(scanner.nextLine());
            usuarioService.cadastrarUsuario(usuario);
        }
    }
}

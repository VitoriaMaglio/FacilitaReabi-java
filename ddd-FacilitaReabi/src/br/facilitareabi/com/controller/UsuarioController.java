package br.facilitareabi.com.controller;
import br.facilitareabi.com.dao.PacienteDao;
import br.facilitareabi.com.dao.UsuarioDao;
import br.facilitareabi.com.model.Paciente;
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
    public void atualizarUsuario(){
        Scanner scanner = new Scanner(System.in);
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        System.out.println("Deseja atualizar seu usuário?");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("Sim")){
            usuarioDao.alterarUsuario(usuario);
        }
    }
    public void excluirUsuario(){
        Scanner scanner = new Scanner(System.in);
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        System.out.println("Deseja excluir um usuário?");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("Sim")){
            if (resp.equalsIgnoreCase("Sim")) {
                System.out.println("Digite o login do usuário que deseja excluir:");
                String login = scanner.nextLine();
                if (usuarioDao.existeUsuarioPorLogin(login)) {
                    usuarioDao.excluirUsua(login);
                } else {
                    System.out.println("Usuário com login '" + login + "' não encontrado no banco.");
                }
            } else {
                System.out.println("Operação cancelada.");
            }
        }
    }
}
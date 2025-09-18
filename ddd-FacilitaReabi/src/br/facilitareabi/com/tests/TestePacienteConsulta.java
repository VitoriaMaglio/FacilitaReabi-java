package br.facilitareabi.com.tests;

import br.facilitareabi.com.controller.UsuarioController;
import br.facilitareabi.com.model.Usuario;
import br.facilitareabi.com.service.UsuarioService;

public class TestePacienteConsulta {
    static void main() {


        UsuarioService usuarioService = new UsuarioService();
        UsuarioController controller = new UsuarioController();
        controller.cadastrarUsuario();
    }
}

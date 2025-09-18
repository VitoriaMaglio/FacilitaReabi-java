package br.facilitareabi.com.dao;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.model.Usuario;

import java.sql.*;
public class UsuarioDao {
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (id, login, senha) VALUES (usuario_seq.NEXTVAL, ?, ?)";
        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.executeUpdate();
            try (PreparedStatement psId = conexao.prepareStatement("SELECT usuario_seq.CURRVAL FROM dual");
                 ResultSet rs = psId.executeQuery()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }
            System.out.println("Usuário cadastrado com ID: " + usuario.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Usuario buscarId(int id) {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";
        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void alterarUsuario(Usuario usuario){
        String sql = "UPDATE USUARIO SET LOGIN, WHERE ID=?";
        try(Connection conexao = ConnectionFactory.obterConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement(sql)){
            comandoSQL.setString(2,usuario.getLogin());
            comandoSQL.setString(3,usuario.getSenha());
            comandoSQL.executeUpdate();
            comandoSQL.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void excluirUsua(int id){
        String sql = "DELETE FROM USUARIO WHERE ID=?";
        try( Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement comandoSQL = conexao.prepareStatement((sql))) {
            comandoSQL.setInt(1,id);
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

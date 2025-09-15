package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    //CRUD inserir,buscar,alterar,excluir

    public void cadastrarUsuario(Usuario usuario){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "insert into usuario (id, login, senha) values(?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, usuario.getId());
            comandoSQL.setString(2, usuario.getLogin());
            comandoSQL.setString(3, usuario.getSenha());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Usuario buscarId(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Usuario usuario = new Usuario();
        try{
            ps = conexao.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario.setId(rs.getInt(1));
                usuario.setSenha(rs.getString(2));
                usuario.setLogin(rs.getString(3));
            }
            ps.close();;
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public void alterarUsuario(Usuario usuario){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "UPDATE USUARIO SET LOGIN, WHERE ID=?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(2,usuario.getLogin());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirUsua(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "DELETE FROM USUARIO WHERE ID=?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1,id);
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

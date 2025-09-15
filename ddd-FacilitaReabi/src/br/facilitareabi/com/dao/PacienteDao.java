package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDao {
    //CRUD

    public void cadastrarPaciente(Paciente paciente){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "insert into paciente (id, nome,cpf,dataNascimento,telefone,email,vulnerabilidade) values(?,?,?,?,?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, paciente.getId());
            comandoSQL.setString(2, paciente.getNome());
            comandoSQL.setString(3, paciente.getCpf());
            comandoSQL.setDate(4, paciente.getDataNascimento());
            comandoSQL.setString(5, paciente.getTelefone());
            comandoSQL.setString(6, paciente.getEmail());
            comandoSQL.setString(7, paciente.getVulnerabilidade());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Paciente buscarId(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Paciente paciente = new Paciente();
        try{
            ps= conexao.prepareStatement("SELECT * FROM PACIENTE WHERE ID_PACIE=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                paciente.setId(rs.getInt(1));
                paciente.setNome(rs.getString(2));
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return paciente;
    }

    public void alterarPaciente(Paciente paciente){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE PACIENTE SET NOME=?,WHERE ID_PACIE=?";
            ps= conexao.prepareStatement(sql);
            ps.setString(2, paciente.getNome());
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirPacie(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "DELETE FROM PACIENTE WHERE ID_PACIE=?";
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

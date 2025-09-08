package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDao {

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
}

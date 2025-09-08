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
            comandoSQL.setInt((1, paciente.getId());

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

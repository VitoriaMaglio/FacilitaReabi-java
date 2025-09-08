package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDao {

    public void cadastrarConsulta(Consulta consulta) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "insert into usuario (id, login, senha) values(?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, consulta.getId());
            comandoSQL.setDate(2, (Date) consulta.getDataConsulta());
            comandoSQL.setString(3, consulta.getStatusConsulta().name());
            comandoSQL.setString(3, consulta.getMotivoFalta());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }}

package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.FacilitaReabi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacilitaReabiDao {
    //CRUD
    public void cadastrarInfSite(FacilitaReabi facilitaReabi){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "insert into facilitaReabi (id, informacao,feedback) values(?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, facilitaReabi.getId());
            comandoSQL.setString(2, facilitaReabi.getInformacao());
            comandoSQL.setString(3, facilitaReabi.getFeedback());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    }


package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.FacilitaReabi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public FacilitaReabi buscarId(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        FacilitaReabi facilitaReabi = new FacilitaReabi();
        try{
            ps = conexao.prepareStatement("SELECT * FROM FACILITAREABI WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                facilitaReabi.setId(1);
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return facilitaReabi;
    }

    public void atualizarFacilita (FacilitaReabi facilitaReabi) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE FACILITAREABI SET informacao = ?, feedback = ? WHERE id = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, facilitaReabi.getId());
            ps.setString(2, facilitaReabi.getInformacao());
            ps.setString(3, facilitaReabi.getFeedback());
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        FacilitaReabi facilitaReabi = new FacilitaReabi();
        try{
            String sql = "DELETE FROM FACILITAREABI WHERE ID=?";
            ps= conexao.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }


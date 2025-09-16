package br.facilitareabi.com.dao;

import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Usuario;

import java.sql.*;
import java.time.LocalDate;

public class ConsultaDao {
    //CRUD

    public void cadastrarConsulta(Consulta consulta) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "insert into consulta (id, dataConsulta, statusConsulta, motivoFalta) values(?,?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, consulta.getId());
            comandoSQL.setDate(2, Date.valueOf((LocalDate)consulta.getDataConsulta()));
            comandoSQL.setString(3, consulta.getStatusConsulta().name());
            comandoSQL.setString(4, consulta.getMotivoFalta());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //buscar
    public Consulta buscarId(int id){
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        Consulta consulta = new Consulta();
        try{
            ps = conexao.prepareStatement("SELECT * FROM CONEXAO WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                consulta.setId(1);
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return consulta;
    }

    //UPDATE não cria registros — ele só modifica registros que já existem
    public void atualizarConsulta(Consulta consulta) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE consulta SET dataConsulta = ?, statusConsulta = ?, motivoFalta = ? WHERE id = ?";
            ps = conexao.prepareStatement(sql);
            ps.setDate(1,java.sql.Date.valueOf(consulta.getDataConsulta()) );
            ps.setString(2, consulta.getStatusConsulta().name());
            ps.setString(3, consulta.getMotivoFalta());// salva enum como texto
            ps.setInt(4, consulta.getId());
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
        Consulta consulta = new Consulta();
        try{
            String sql = "DELETE FROM CONSULTA WHERE ID=?";
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

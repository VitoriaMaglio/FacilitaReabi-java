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
            String sql = "insert into usuario (id, login, senha) values(?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, consulta.getId());
            comandoSQL.setDate(2, Date.valueOf((LocalDate) consulta.getDataConsulta()));
            comandoSQL.setString(3, consulta.getStatusConsulta().name());
            comandoSQL.setString(3, consulta.getMotivoFalta());
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

    public void atualizarConsulta(Consulta consulta) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE consulta SET dataConsulta = ?, motivo_falta = ?, status = ? WHERE id = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, consulta.getId());
            ps.setString(2, consulta.getStatusConsulta().name());
            ps.setString(3, consulta.getMotivoFalta()); // salva enum como texto
            ps.setDate(4,java.sql.Date.valueOf(consulta.getDataConsulta()) );

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

package br.facilitareabi.com.dao;

import br.facilitareabi.com.enums.StatusConsultaEnum;
import br.facilitareabi.com.model.Consulta;
import br.facilitareabi.com.model.Paciente;
import br.facilitareabi.com.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDao {
    //CRUD

    public void cadastrarConsulta(Consulta consulta) {
        String sql = "insert into consulta ( id, dataConsulta, statusConsulta, motivoFalta,id_paciente) values(consulta_seq.NEXTVAL,?,?,?,?)";


        try(Connection conexao = ConnectionFactory.obterConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setDate(1, Date.valueOf((LocalDate)consulta.getDataConsulta()));
            comandoSQL.setString(2, consulta.getStatusConsulta().name());
            comandoSQL.setString(3, consulta.getMotivoFalta());
            comandoSQL.setInt(4,consulta.getPaciente().getId_paciente());
            comandoSQL.executeUpdate();
            try (PreparedStatement psId = conexao.prepareStatement("SELECT consulta_seq.CURRVAL FROM dual");
                 ResultSet rs = psId.executeQuery()) {

                if (rs.next()) {
                    consulta.setId(rs.getInt(1));
                }
            }
            System.out.println("Consulta cadastrado com ID: " + consulta.getId());


            //comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //buscar
    public Consulta buscarId(int id){
        String sql = "SELECT * FROM consulta WHERE id=?";
        Consulta consulta = null;

        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    consulta = new Consulta();
                    consulta.setId(rs.getInt("id"));
                    consulta.setDataConsulta(rs.getDate("dataConsulta").toLocalDate());
                    consulta.setStatusConsulta(StatusConsultaEnum.valueOf(rs.getString("statusConsulta")));
                    consulta.setMotivoFalta(rs.getString("motivoFalta"));

                    //referência ao paciente:
                    Paciente paciente = new Paciente();
                    paciente.setId_paciente(rs.getInt("id_paciente"));
                    consulta.setPaciente(paciente);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consulta;
        }

        //UPDATE não cria registros — ele só modifica registros que já existem
    public void atualizarConsulta(Consulta consulta) {
        String sql = "UPDATE consulta SET dataConsulta = ?, statusConsulta = ?, motivoFalta = ?, id_paciente = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(consulta.getDataConsulta()));
            ps.setString(2, consulta.getStatusConsulta().name());
            ps.setString(3, consulta.getMotivoFalta());
            ps.setInt(4, consulta.getPaciente().getId_paciente());
            ps.setInt(5, consulta.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma consulta encontrada com o ID: " + consulta.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM consulta WHERE id = ?";

        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma consulta encontrada com o ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Consulta> listarConsultas() {
        String sql = "SELECT * FROM consulta";
        List<Consulta> consultas = new ArrayList<>();
        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setDataConsulta(rs.getDate("dataConsulta").toLocalDate());
                consulta.setStatusConsulta(StatusConsultaEnum.valueOf(rs.getString("statusConsulta")));
                consulta.setMotivoFalta(rs.getString("motivoFalta"));
                Paciente paciente = new Paciente();
                paciente.setId_paciente(rs.getInt("id_paciente"));
                consulta.setPaciente(paciente);
                consultas.add(consulta);

            }
            for (Consulta c : consultas){
                System.out.println(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return consultas;
    }
}

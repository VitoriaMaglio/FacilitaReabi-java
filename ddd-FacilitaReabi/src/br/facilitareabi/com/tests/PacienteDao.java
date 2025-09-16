package br.facilitareabi.com.tests;

import br.facilitareabi.com.dao.ConnectionFactory;
import br.facilitareabi.com.model.Paciente;

import java.sql.*;

public class PacienteDao {
    //CRUD
    //esse método faz persistência no banco, não valida nem aplica regras.
    public void cadastrarPaciente(Paciente paciente){
        String sql = "insert into paciente (nome,cpf,dataNascimento,telefone,email,vulnerabilidade) values(?,?,?,?,?,?)";
        try(Connection conexao = ConnectionFactory.obterConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            //comandoSQL.setInt(1, paciente.getId_paciente());
            comandoSQL.setString(1, paciente.getNome());
            comandoSQL.setString(2, paciente.getCpf());
            comandoSQL.setDate(3, java.sql.Date.valueOf(paciente.getDataNascimento()));//converte para sql
            comandoSQL.setString(4, paciente.getTelefone());
            comandoSQL.setString(5, paciente.getEmail());
            comandoSQL.setString(6, paciente.getVulnerabilidade());
            comandoSQL.executeUpdate();
            try (ResultSet rs = comandoSQL.getGeneratedKeys()){
                if(rs.next()){
                    paciente.setId_paciente(rs.getInt(1));
                }
            }
            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Paciente buscarId(int id) {
        String sql = "SELECT * FROM paciente WHERE id_paciente = ?";
        try (Connection conn = ConnectionFactory.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setVulnerabilidade(rs.getString("vulnerabilidade"));
                return paciente;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }}

package br.facilitareabi.com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static Connection obterConexao(){
        Connection conexao = null;
        try {
            conexao = conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "", "");
            conexao.setAutoCommit(true);
        }catch (SQLException e){
            e.printStackTrace();
        }return conexao;
    }

}

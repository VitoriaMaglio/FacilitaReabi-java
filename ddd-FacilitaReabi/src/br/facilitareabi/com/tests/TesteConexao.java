package br.facilitareabi.com.tests;
import br.facilitareabi.com.dao.ConnectionFactory;
public class TesteConexao {
     static void main(String[] args) {
        if(ConnectionFactory.obterConexao()==null){
            System.out.printf("erro");
        }else{
            System.out.println("Conexão realizada.");
        }
    }
}

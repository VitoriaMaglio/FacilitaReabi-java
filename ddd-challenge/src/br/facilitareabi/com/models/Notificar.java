package br.facilitareabi.com.models;

public class Notificar {
    // Método
    public void notificar(Consulta consulta) {
        System.out.println(" \n==========================================");
        System.out.println("LEMBRETE!");
        System.out.println("   ==========================================");
        System.out.println("Não se esqueça das suas consultas!"   );
        System.out.println("Você tem uma teleconsulta marcada para o dia "+ consulta.getDataHora()+".");
        System.out.println("Sua consulta está" + " " + consulta.getStatus()+".");
    }


}

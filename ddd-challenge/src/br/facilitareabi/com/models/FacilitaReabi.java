package br.facilitareabi.com.models;

import java.util.Scanner;

public class FacilitaReabi  {
    // Atributos
    private String incluir;

    // Getters e Setters
    public String getIncluir() {return incluir;}
    public void setIncluir(String incluir) {this.incluir = incluir;}
    public Scanner getLeitor() {return leitor;}
    public void setLeitor(Scanner leitor) {this.leitor = leitor;}

    Scanner leitor = new Scanner(System.in);

    // Métodos
    public void facilitaReabi(Paciente paciente){
        System.out.println("\n==========================================");
        if (paciente.getIdade() >= 50){
            System.out.println("\n==========================================");
            System.out.println("Percebemos que você tem " +paciente.getIdade()+ " " +"anos, e isso é sinal de muita experiência e sabedoria. ");
            System.out.println("Pensando nisso, criamos uma explicação especial, com calma e clareza, para te ajudar a usar o aplicativo com tranquilidade.");
            System.out.println("\n" + paciente.getNome()+ " " +"Vamos te explicar com detalhes como nossas consultas realizadas pelo celular podem ajudar no seu tratamento.");
            System.out.println("\n" +"Nosso aplicativo foi desenvolvido com carinho para facilitar sua vida. Veja o que você vai encontrar nele:");
            System.out.println("\n Menu principal:");
            System.out.println("\n" +"Informações sobre sua próxima consulta (data, horário e link).");
            System.out.println("\n" +"Explicações simples sobre como funciona a teleconsulta.");
            System.out.println("\n Passo a passo para usar o aplicativo:");
            System.out.println("\n==========================================");
            System.out.println("\n" +"1. Abra o aplicativo no celular."+ "\n" +
            "\n" +"2. Toque na opção ‘Minhas Consultas’."+ "\n" +
            "\n" +"3. Veja o horário marcado e toque em ‘Entrar na Consulta’."+ "\n" +
            "\n" +"4. Permita o uso da câmera e do microfone."+ "\n" +
            "\n" +"5. Aguarde o profissional de saúde iniciar a chamada.");
            System.out.println("\n Nossa missão é te acolher:");
            System.out.println(" \n==========================================");
            System.out.println("Sabemos que o mundo digital pode ser novo para você. Por isso, fizemos tudo com letras grandes, linguagem simples e apoio humano sempre disponível.");
            System.out.println("Se você sentir dificuldade, não se preocupe: nossa equipe está pronta para te ajudar em cada etapa.");
        } else {
            System.out.println("\n" + paciente.getNome()+  " " +"vamos te explicar mais sobre nossas consultas on-lines." );
            System.out.println("Nosso app facilita sua vida na hora de cuidar da saúde. Veja o que você vai encontrar:");
            System.out.println("\n Funcionalidades principais:"+ "\n" +
            " \n=========================================="+ "\n" +
            "\n" +"Consulta rápida: veja o dia, hora e link da sua próxima consulta."+ "\n" +
            "\n" +"Acesso direto à chamada com um clique."+ "\n" +
            "\n" +"Informações claras sobre como a teleconsulta funciona.");
            System.out.println("\n Como usar:"+ "\n" +
            " \n==========================================" + "\n" +
            "\n" +"1. Abra o aplicativo no seu celular." + "\n" +
            "\n" +"2. Vá em ‘Minhas Consultas’." + "\n" +
            "\n" +"3. Clique no botão ‘Entrar’ na hora marcada." +  "\n" +
            "\n" +"4. Ative a câmera e o microfone se for solicitado.");
            System.out.println("\n Dica:");
            System.out.println(" \n==========================================");
            System.out.println("Programe um lembrete no celular para não esquecer sua consulta.");
            System.out.println("Se tiver qualquer dúvida, nossa equipe está pronta para te ajudar.");
        }
    }
    public String entendendo(Paciente paciente) {
        while (true) {
            System.out.println("==========================================");
            System.out.println(paciente.getNome() + " " + "vamos entender mais sobre nossa Rede de Reabilitação!");
            System.out.println("O Instituto de Medicina Física e Reabilitação (IMREA) do Hospital das Clínicas da Faculdade de Medicina da Universidade de São Paulo (HCFMUSP)," +"\n" +
            "em conjunto com o Instituto de Reabilitação Lucy Montoro (IRLM), oferece reabilitação multidisciplinar, propiciando melhoria na qualidade de vida e autonomia.");
            System.out.println("\nEscolha, dentre as opções abaixo, o que você quer entender melhor:");
            System.out.println("1 - O que é uma teleconsulta?");
            System.out.println("2 - Como consultas digitais podem me ajudar?");
            System.out.println("3 - Como entrar em uma teleconsulta?");
            System.out.println("4 - Como aproveitar a tecnologia para melhorar minha saúde?");
            String resposta = leitor.nextLine();
            switch (resposta) {
                case "1":
                    System.out.println("==========================================");
                    return "Teleconsulta é uma consulta médica realizada à distância, por meio de chamadas de vídeo, áudio ou mensagens, utilizando celular, computador ou outro dispositivo conectado à internet."+
                            "É uma forma segura e prática de receber atendimento médico sem sair de casa." +"\n" +
                            "\nInformação importante!" + "\n" +
                            "\nLembre-se que nossa equipe médica está aqui para te ajudar a evoluir em seus tratamentos, nós entendemos que pode ser complicado entrar em uma ligação com" +"\n" +
                            "sua câmera e áudio abertos, porém tenha certeza que os profissionais do IMREA farão de tudo para gerar um ambiente acolhedor e inclusivo! ";
                case "2":
                    System.out.println("==========================================");
                    return "Consultas digitais facilitam o acesso à saúde, evitando deslocamentos e filas. Elas permitem que você consulte um médico com mais rapidez, acompanhe tratamentos, tire dúvidas e tenha " +"\n" +
                            "mais controle sobre sua saúde, tudo com mais conforto e segurança." +"\n" +
                            "\nInformação importante!" + "\n" +
                            "\nLembre-se que nossa equipe médica está aqui para te ajudar a evoluir em seus tratamentos, nós entendemos que pode ser complicado entrar em uma ligação com " +"\n" +
                            "sua câmera e áudio abertos, porém tenha certeza que os profissionais do IMREA farão de tudo para gerar um ambiente acolhedor e inclusivo! ";
                case "3":
                    System.out.println("==========================================");
                    return "Para entrar em uma teleconsulta, você precisa:\n" +
                            "\n" +
                            "Ter um celular ou computador com internet.\n" +
                            "\n" +
                            "Acessar o link enviado pelo médico ou sistema de saúde.\n" +
                            "\n" +
                            "Estar em um local silencioso e com boa iluminação.\n" +
                            "\n" +
                            "Clicar no link no horário marcado e permitir o uso da câmera e microfone.\n" +
                            "\n" + "\nInformação importante!" + "\nLembre-se que nossa equipe médica está aqui para te ajudar a evoluir em seus tratamentos, nós entendemos que pode ser complicado entrar em uma " +"\n" +
                            "ligação com sua câmera e áudio abertos, porém tenha certeza que os profissionais do IMREA farão de tudo para gerar um ambiente acolhedor e inclusivo! ";
                case "4":
                    System.out.println("==========================================");
                    return "Você pode usar aplicativos e plataformas digitais para:\n" +
                            "\n" +
                            "Marcar e acompanhar consultas.\n" +
                            "\n" +
                            "Receber lembretes de medicamentos e exames.\n" +
                            "\n" +
                            "Ter acesso a informações confiáveis sobre sua saúde.\n" +
                            "\n" +
                            "Falar com profissionais da saúde com mais facilidade." +
                            "\nInformação importante!" + "\nLembre-se que nossa equipe médica está aqui para te ajudar a evoluir em seus tratamentos, nós entendemos que pode ser complicado entrar em uma ligação com " +
                            "sua câmera e áudio abertos, porém tenha certeza que os profissionais do IMREA farão de tudo para gerar um ambiente acolhedor e inclusivo! ";
                default:
                    System.out.println("==========================================");
                    System.out.println("Opção inválida!" + " Digite um número válido entre 1 a 4.");
            }
        }
    }

    public void inclusao() {
        System.out.println("Sabemos que usar a tecnologia pode ser difícil no começo, e queremos que você saiba que estamos aqui para ajudar.");
        System.out.println("O IMREA foi feito para tornar suas consultas mais fáceis e acessíveis.");
        System.out.println("Se você tiver qualquer problema com o celular ou o aplicativo, nossa equipe está pronta para dar todo o suporte necessário!");
        System.out.println("\nVocê encontra dificuldades para comparecer às suas consultas online? (Sim/Não)");
        String resposta = leitor.nextLine();
        while (true) {
            if (resposta.equalsIgnoreCase("Sim")) {
                System.out.println("\nOk! Vamos te ajudar a enfrentar esse problema.");
                System.out.println("Escolha abaixo o motivo principal da sua ausência:");
                System.out.println("1 - Dificuldade em usar o celular ou o computador");
                System.out.println("2 - Falta de acesso à internet");
                System.out.println("3 - Falta de equipamento adequado");
                System.out.println("4 - Esquecimento do horário ou data");
                System.out.println("5 - Condições de vulnerabilidade social");
                System.out.print("Digite o número da opção: ");
                this.incluir = leitor.nextLine();
                fornecerSolucoesPersonalizadas(this.incluir);
                break;
            } else if (resposta.equalsIgnoreCase("Não")) {
                System.out.println("Ótimo! Que bom saber que está conseguindo participar das consultas.");
                break;
            } else {
                System.out.println("Por favor, responda apenas com 'Sim' ou 'Não'.");
                resposta = leitor.nextLine();
            }
        }
        System.out.println("\nObrigada pela resposta, nossa equipe irá te ajudar!");
        System.out.println("Também recomendamos que você entre em contato com a Rede de Reabilitação Lucy Montoro para ajustar seu tratamento conforme sua rotina.");
        System.out.println("Agradecemos sua colaboração, e esperamos que você consiga usufruir das nossas teleconsultas!");
    }

    private void fornecerSolucoesPersonalizadas(String incluir) {
        System.out.println("\nSolução recomendada para você:");
        switch (incluir) {
            case "1":
                System.out.println("\n" +"Passo a passo básico para usar o celular na teleconsulta:");
                System.out.println("\n" +"  1. Ligue seu celular e verifique se está com internet."+ "\n" +
                "\n" +"  2. Abra o aplicativo ou o link enviado pela equipe médica."+ "\n" +
                "\n" +"  3. Toque em 'Entrar na consulta'."+ "\n" +
                "\n" +"  4. Permita o uso da câmera e microfone."+ "\n" +
                "\n" +"  5. Aguarde o médico entrar na chamada.");
                break;
            case "2":
                System.out.println("Dica: Busque locais com Wi-Fi gratuito, como unidades de saúde, bibliotecas ou centros comunitários.");
                System.out.println("Tente se conectar ao Wi-Fi antes do horário da consulta e verifique se o sinal está bom.");
                break;
            case "3":
                System.out.println("Se você não tem celular ou computador adequado:");
                System.out.println("Tente usar o aparelho de alguém da família ou amigo.");
                System.out.println("Verifique se há espaços públicos que emprestam computadores.");
                System.out.println("Se nada disso funcionar, informe à equipe para buscar uma alternativa presencial.");
                break;
            case "4":
                System.out.println("\n" +"Dica para lembrar da consulta:"+ "\n" +
                "\n" +"Anote o dia e horário em um papel e cole na geladeira ou porta."+ "\n" +
                "\n" +"Ative um alarme no seu celular."+ "\n" +
                "\n" +"Peça para alguém de confiança te lembrar.");
                break;
            case "5":
                System.out.println("Sabemos que cada situação é única.");
                System.out.println("Informe suas dificuldades à equipe para buscarmos juntos uma solução.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente com um número de 1 a 5.");
                break;
        }
    }

}



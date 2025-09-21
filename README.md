# FacilitaReabi-java <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" alt="Java logo">

Projeto em Java desenvolvido para o **Hospital das Clínicas**, com o objetivo de reduzir a taxa de **absenteísmo em teleconsultas** por meio da inclusão digital de pacientes.

---

## Funcionalidades
- Filtragem eficiente de usuários aptos a utilizarem serviços on-line.
- Melhoria da acessibilidade e inclusão digital por meio de perguntas simples e diretas.
- Notificação automática de consultas agendadas.
- Registro de vulnerabilidades de cada paciente.
- Integração com banco de dados para persistência de informações de pacientes e consultas.

---

## Cenário
O projeto atende pacientes com dificuldades em utilizar tecnologias digitais, ajudando-os a compreender o funcionamento das teleconsultas e reduzir faltas.  

Exemplo de fluxo:  
1. Paciente acessa o sistema e realiza login.  
2. Sistema verifica vulnerabilidades e oferece explicações personalizadas.  
3. Consulta é agendada e o paciente recebe notificações.  
4. Feedback sobre participação e presença é registrado no banco de dados.

---

## Tecnologias Utilizadas
- **Java 17**  
- **Oracle SQL Developer** para gestão do banco de dados  
- JDBC para conexão e manipulação de dados  
- Estrutura MVC (Model-View-Controller) para organização do código  

---


## Benchmarks
- Redução de **absenteísmo** em teleconsultas por meio de alertas e educação digital.  
- Facilidade de uso mesmo para pacientes com baixo conhecimento em tecnologia.  
- Registro de dados de vulnerabilidade para análise e melhoria contínua do serviço.

---

## Como rodar o projeto
1- Instale as tecnologias necessárias (Java e Oracle SQL Developer).
2- Execute o arquivo SQL Vitoria_java_bd.sql no Oracle SQL Developer para criar as tabelas e sequências do banco de dados.
3- Abra o projeto Java e configure suas credenciais do banco de dados na classe ConnectionFactory.
4- Execute a classe Main para iniciar a aplicação.


---

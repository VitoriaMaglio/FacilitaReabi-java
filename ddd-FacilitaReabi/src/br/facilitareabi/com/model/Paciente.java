package br.facilitareabi.com.model;

import java.sql.Date;
import java.time.LocalDate;

public class Paciente {
    //atributtes
    private int id_paciente;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String vulnerabilidade;

    //Construtor


    public Paciente() {
    }

    public Paciente(int id_paciente, String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String vulnerabilidade) {
        this.id_paciente = id_paciente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.vulnerabilidade = vulnerabilidade;
    }

    //Getters e setters


    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVulnerabilidade() {
        return vulnerabilidade;
    }

    public void setVulnerabilidade(String vulnerabilidade) {
        this.vulnerabilidade = vulnerabilidade;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "ID=" + id_paciente +
                ", Nome='" + nome + '\'' +
                ", DataNascimento=" + dataNascimento +
                ", Email='" + email + '\'' +
                ", Telefone='" + telefone + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Vulnerabilidade='" + vulnerabilidade + '\'' +
                '}';
    }



}

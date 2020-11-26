package br.ufscar.dc.dsw.domain;

import java.time.LocalDate;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String genero;
    private String telefone;
    private LocalDate dataNascimento;

    public Cliente(String cpf) {
        this.setCPF(cpf);
    }

    public Cliente(String cpf, String nome, String email, String senha, String genero, String telefone, LocalDate dataNascimento) {
        this.setCPF(cpf);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setGenero(genero);
        this.setTelefone(telefone);
        this.setDataNascimento(dataNascimento);
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }
}

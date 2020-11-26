package br.ufscar.dc.dsw.domain;

public class Locadora {
    private String cnpj;
    private String nome;
    private String email;
    private String senha;
    private String cidade;

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCPF() {
        return this.cnpj;
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

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }
}

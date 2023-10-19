package br.edu.faeterj;

import java.util.Date;

public class Aluno {
  private String nome;
  private String cpf;
  private String matricula;
  private Date dtNasc;
  private String endereco;
  private String cep;

  public Aluno(String nome, String cpf, String matricula, String dtNasc, String endereco, String cep) {
    super();
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
    // this.dtNasc = dtNasc;
    this.endereco = endereco;
    this.cep = cep;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getMatricula() {
    return this.matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Date getDtNasc() {
    return this.dtNasc;
  }

  public void setDtNasc(Date dtNasc) {
    this.dtNasc = dtNasc;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

}
package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(length = 100)
  private String nome;
  @Column(unique = true, length = 14)
  private String cpf;
  @Temporal(TemporalType.DATE)
  private Date dataNascimento;
  @Column
  private boolean vacinado;

  public Pessoa(long id, String nome, String cpf, Date dataNascimento, boolean vacinado) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.vacinado = vacinado;
  }

  public Pessoa() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public boolean isVacinado() {
    return vacinado;
  }

  public void setVacinado(boolean vacinado) {
    this.vacinado = vacinado;
  }
}

package com.example.demo.dto;

import java.util.Date;

public record PessoaDTO(String nome, String cpf, Date dataNascimento, boolean vacinado) {
}

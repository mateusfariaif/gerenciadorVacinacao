package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {
  private PessoaRepository pessoaRepository;

  public PessoaController(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  @GetMapping
  public Iterable<Pessoa> getPessoas() {
    return pessoaRepository.findAll();
  }

  @PostMapping
  public Pessoa criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
    var novaPessoa = new Pessoa(0, pessoaDTO.nome(), pessoaDTO.cpf(), pessoaDTO.dataNascimento(),
        pessoaDTO.vacinado());

    return pessoaRepository.save(novaPessoa);
  }

  @DeleteMapping("/{id}")
  public String removerPessoa(@PathVariable long id) {
    var pessoa = pessoaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id " + id));

    pessoaRepository.delete(pessoa);

    return "A pessoa com id " + id + " foi deletada.";
  }
}

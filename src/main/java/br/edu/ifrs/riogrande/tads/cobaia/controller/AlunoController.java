package br.edu.ifrs.riogrande.tads.cobaia.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.cobaia.domain.dto.AlunoDTO;
import br.edu.ifrs.riogrande.tads.cobaia.domain.dto.NovoAluno;
import br.edu.ifrs.riogrande.tads.cobaia.domain.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.domain.service.AlunoService;
import br.edu.ifrs.riogrande.tads.cobaia.repository.AlunoRepository;

// é uma boa prática versionar a API, definir o contrato
@Validated
@RequestMapping("/api/v1/alunos")
@RestController
public class AlunoController {
  // Controller nunca tem regras de negócio,
  // nem acessam a persistência diretamente,
  // nunca expor as entidades do domínio
  // private AlunoRepository alunoRepository;

  private AlunoService alunoService;

  public AlunoController(AlunoService alunoService) {
    this.alunoService = alunoService;
  }
  
  // DTO, Data Transfer Object

  @GetMapping
  public ResponseEntity<List<AlunoDTO>> getAlunos() {
    return ResponseEntity.ok(alunoService.findAll());
  }

  @PostMapping
  public ResponseEntity salvarAluno(@RequestBody @Valid NovoAluno aluno) {
    // validações
    return ResponseEntity.ok().build();
  }

}

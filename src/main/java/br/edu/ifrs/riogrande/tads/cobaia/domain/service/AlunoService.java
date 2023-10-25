package br.edu.ifrs.riogrande.tads.cobaia.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.cobaia.domain.dto.AlunoDTO;
import br.edu.ifrs.riogrande.tads.cobaia.domain.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.repository.AlunoRepository;

@Service // Bean
public class AlunoService {

  private final AlunoRepository alunoRepository;

  public AlunoService(AlunoRepository alunoRepository) {
    this.alunoRepository = alunoRepository;
  }

  private AlunoDTO converte(Aluno aluno) {
    AlunoDTO dto = new AlunoDTO();
    BeanUtils.copyProperties(aluno, dto);
    // dto.setMatricula(aluno.getMatricula());
    // dto.setNome(aluno.getNome());
    return dto;
  }
  
  public List<AlunoDTO> findAll() {
    // one-liner
    return alunoRepository.findAll().stream()
        .map(this::converte)
        .collect(Collectors.toList());

    // List<AlunoDTO> dtos = new ArrayList<>();
    // for (Aluno a : alunos) {
    //   AlunoDTO dto = new AlunoDTO();
    //   dto.setMatricula(a.getMatricula());
    //   dto.setNome(a.getNome());
    //   dtos.add(dto);
    // }
    // return dtos;
  }
}

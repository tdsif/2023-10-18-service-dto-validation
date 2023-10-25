package br.edu.ifrs.riogrande.tads.cobaia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.riogrande.tads.cobaia.domain.entity.Aluno;

// <ClasseEntidade, TipoId>
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

  List<Aluno> findAll();
  
}

package br.edu.ifrs.riogrande.tads.cobaia.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// POJO: Plain Old Java Object (o velho e bom objeto java)

@Getter
@Setter
@ToString(exclude = "senha")
@Table(name = "alunos")
@Entity
public class Aluno { // orm.xml

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer matricula;
  
  @Column(length = 100, nullable = false, unique = true)
  private String nome;

  // @JsonIgnore // não vai para o payload ("não vira json")
  @Column(length = 11, nullable = false, unique = true)
  private String cpf;

  @Column
  private String tokenAcesso;

  private String senha;

  // Builder "preguiçoso"
  public Aluno withMatricula(Integer matricula) {
    this.setMatricula(matricula);
    return this;
  }

  public Aluno withNome(String nome) {
    this.setNome(nome);
    return this;
  }
  
  
}

package br.edu.ifrs.riogrande.tads.cobaia.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// DTO -> Payload
@Data
public class AlunoDTO { // dado público
  
  private Integer matricula;
  @JsonProperty("nomeCompleto")
  private String nome;

}

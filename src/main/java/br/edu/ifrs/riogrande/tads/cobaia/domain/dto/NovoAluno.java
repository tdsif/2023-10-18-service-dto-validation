package br.edu.ifrs.riogrande.tads.cobaia.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NovoAluno { // payload de entrada

  /*
   * {
   *   "nome": "Marcio",
   *   "cpf": "12345678901",
   *   "password": "1234"
   * }
   * 
   */

  @NotBlank(message = "O nome é obrigatório")
  @Length(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
  String nome;
  @Pattern(regexp = "^\\d{11}$")
  String cpf;
  @JsonProperty("password")
  String password;

}

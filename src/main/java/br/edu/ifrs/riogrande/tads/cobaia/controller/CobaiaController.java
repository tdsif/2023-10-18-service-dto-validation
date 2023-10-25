package br.edu.ifrs.riogrande.tads.cobaia.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.cobaia.domain.entity.Aluno;
import ch.qos.logback.core.util.ContentTypeUtil;

// Cada componente (ex.: controller) é um Singleton
// Engine de Injeção de Dependências
// a <- b <- c
//        <- d

@RestController
public class CobaiaController {

  // Modo Completo: ENDPOINT
  @RequestMapping(
        method = RequestMethod.GET, 
        path = {"/oi", "/ola"})
  public String hello() {
    return "Oi!";
  }

  @GetMapping("/tchau")
  public String bye() {
    return "Tchauzinho!";
  }

  // Content-Type -- Mime Type
  @GetMapping(path = "/dados", produces = "application/json")
  public String dados() { // String => text/plain
    return "{\"nome\": \"Marcio\"}";
  }


  @GetMapping("/dados2") // KeyValuePair
  public Map<String, Object> dados2() {
    // Map<String, String> bag = new HashMap<>();
    // bag.put("nome", "Marcio");
    // bag.put("sobrenome", "Torres");
    return Map.of( // {"nome": "Marcio", "sobrenome": "Torres"}
      "nome", "Marcio", 
      "sobrenome", "Torres",
      "idade", 46,
      "professor", true
    );
  }

  @GetMapping("/aluno")
  public Aluno aluno() {
    // Aluno a = new Aluno();
    // a.setNome("Joca");
    // a.setMatricula(123);
    // return a;

    // return new Aluno() {{ // hack: façam para impressionar
    //   setMatricula(123);
    //   setNome("Joca");
    // }};

    return new Aluno() // Builder-ish
      .withMatricula(123)
      .withNome("Joca");
  }


  @GetMapping("/aluno2")
  public ResponseEntity<?> semAluno() {
    // return ResponseEntity.notFound().build();
    // return ResponseEntity.status(404).build();
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(Map.of("mensagem", "Nenhum aluno encontrado"));
    // return ResponseEntity.noContent().build(); // 204
  }



}

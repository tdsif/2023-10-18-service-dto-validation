package br.edu.ifrs.riogrande.tads.cobaia;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zaxxer.hikari.HikariDataSource;

import br.edu.ifrs.riogrande.tads.cobaia.controller.CobaiaController;
import br.edu.ifrs.riogrande.tads.cobaia.domain.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.repository.AlunoRepository;

// boilerplate: código que está lá só para manter a estrutura ex: get/set

// lombok

@SpringBootApplication
public class CobaiaApplication {

	@Autowired
	AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CobaiaApplication.class, args);
	}

	@PreDestroy
	void limpar() {

	}

	// Tentar evitar:
	// evitar verbos, POST,GET,PUT,DELETE são os verbos
	// domain/api/v1/salvarAluno
	// domain/api/v1/aluno?action=salvar
	// Transportar o conceito de objeto para a web
	// comum usar a ideia de RECURSO (RESOURCE)
	// recurso estado representacional (multilinguagem)
	// plural:
	// POST=>Salvar, GET=>Ler
	// domain/api/v1/alunos


	// domain/api/v1/alunos?nome=Marcio
	// GET, DELETE, PATCH, PUT
	// domain/api/v1/alunos/123



	@PostConstruct
	void popularBanco() {
		System.out.println("Rodando o Post Construct");

		Aluno a = new Aluno();
		a.setNome("Marcio Torres");
		a.setCpf("12345678901");

		alunoRepository.save(a);

		Aluno b = new Aluno();
		b.setNome("Teste");
		b.setCpf("09876543210");

		alunoRepository.save(b);

		System.out.println("Matrícula:" + a.getMatricula());

		System.out.println(alunoRepository.findAll());

	}
}

package com.hibicode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.hibicode.model.Funcionario;

public interface Funcionarios extends JpaRepository<Funcionario, Integer> {

	@RestResource(path = "findByNome")
	public List<Funcionario> findByNomeContaining(@Param("nome") String nome);
	
}

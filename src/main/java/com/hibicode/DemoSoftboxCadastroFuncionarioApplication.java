package com.hibicode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoSoftboxCadastroFuncionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSoftboxCadastroFuncionarioApplication.class, args);
	}
}

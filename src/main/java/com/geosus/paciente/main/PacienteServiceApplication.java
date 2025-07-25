package com.geosus.paciente.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.geosus.paciente")
@EnableJpaRepositories(basePackages = "com.geosus.paciente.infrastructure.repository")
@EntityScan(basePackages = "com.geosus.paciente.infrastructure.entity")
public class PacienteServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PacienteServiceApplication.class, args);
	}
}


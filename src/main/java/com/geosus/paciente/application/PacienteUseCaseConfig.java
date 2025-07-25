package com.geosus.paciente.main;

import com.geosus.paciente.application.CadastrarPacienteUseCase;
import com.geosus.paciente.application.ListarTodosPacientesUseCase;
import com.geosus.paciente.domain.PacienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteUseCaseConfig {

    @Bean
    public CadastrarPacienteUseCase cadastrarPacienteUseCase(PacienteRepository storage) {
        return new CadastrarPacienteUseCase(storage);
    }

    @Bean
    public ListarTodosPacientesUseCase listarTodosPacientesUseCase(PacienteRepository storage) {
        return new ListarTodosPacientesUseCase(storage);
    }
}

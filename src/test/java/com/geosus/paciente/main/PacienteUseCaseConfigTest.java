package com.geosus.paciente.main;

import com.geosus.paciente.application.CadastrarPacienteUseCase;
import com.geosus.paciente.application.ListarTodosPacientesUseCase;
import com.geosus.paciente.domain.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class PacienteUseCaseConfigTest {

    private final com.geosus.paciente.main.PacienteUseCaseConfig config = new com.geosus.paciente.main.PacienteUseCaseConfig();
    private final PacienteRepository mockRepo = Mockito.mock(PacienteRepository.class);

    @Test
    void deveInstanciarCadastrarPacienteUseCase() {
        CadastrarPacienteUseCase useCase = config.cadastrarPacienteUseCase(mockRepo);
        assertThat(useCase).isNotNull();
    }

    @Test
    void deveInstanciarListarTodosPacientesUseCase() {
        ListarTodosPacientesUseCase useCase = config.listarTodosPacientesUseCase(mockRepo);
        assertThat(useCase).isNotNull();
    }
}

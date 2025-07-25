package com.geosus.paciente.application;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CadastrarPacienteUseCaseTest {

    private PacienteRepository repository;
    private CadastrarPacienteUseCase useCase;

    @BeforeEach
    void setUp() {
        repository = mock(PacienteRepository.class);
        useCase = new CadastrarPacienteUseCase(repository);
    }

    @Test
    void deveCadastrarPacienteComSucesso() {
        Paciente paciente = new Paciente(null, "Lud", "11122233344", LocalDate.of(1993, 9, 23), "Rua A");
        Paciente salvo = new Paciente(1L, "Lud", "11122233344", LocalDate.of(1993, 9, 23), "Rua A");

        when(repository.salvar(paciente)).thenReturn(salvo);

        Paciente resultado = useCase.execute(paciente);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(repository).salvar(paciente);
    }
}

package com.geosus.paciente.infrastructure.repository;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;
import com.geosus.paciente.infrastructure.gateway.PacienteRepositoryJpaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PacienteRepositoryImplTest {

    private SpringPacienteJpaRepository springRepository;
    private PacienteRepositoryImpl repository;

    private Paciente paciente;

    @BeforeEach
    void setUp() {
        springRepository = Mockito.mock(SpringPacienteJpaRepository.class);
        repository = new PacienteRepositoryImpl(springRepository);

        paciente = Paciente.builder()
                .id(1L)
                .nome("Lud")
                .cpf("11122233344")
                .dataNascimento(LocalDate.of(1993, 9, 23))
                .endereco("Rua A")
                .build();
    }

    @Test
    void deveSalvarPaciente() {
        PacienteJpaEntity entity = PacienteJpaEntity.fromDomain(paciente);
        when(springRepository.save(any())).thenReturn(entity);

        Paciente salvo = repository.salvar(paciente);

        assertThat(salvo).usingRecursiveComparison().isEqualTo(paciente);
        verify(springRepository).save(any());
    }

    @Test
    void deveListarTodosPacientes() {
        when(springRepository.findAll()).thenReturn(List.of(PacienteJpaEntity.fromDomain(paciente)));

        List<Paciente> pacientes = repository.listarTodos();

        assertThat(pacientes).hasSize(1);
        assertThat(pacientes.get(0)).usingRecursiveComparison().isEqualTo(paciente);
    }

    @Test
    void deveBuscarPacientePorCpf() {
        when(springRepository.findByCpf("11122233344")).thenReturn(Optional.of(PacienteJpaEntity.fromDomain(paciente)));

        Optional<Paciente> resultado = repository.buscarPorCpf("11122233344");

        assertThat(resultado).isPresent();
        assertThat(resultado.get()).usingRecursiveComparison().isEqualTo(paciente);
    }

    @Test
    void deveRetornarVazioSeCpfNaoExistir() {
        when(springRepository.findByCpf("00000000000")).thenReturn(Optional.empty());

        Optional<Paciente> resultado = repository.buscarPorCpf("00000000000");

        assertThat(resultado).isEmpty();
    }
}

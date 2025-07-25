package com.geosus.paciente.infrastructure.repository.gateway;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;
import com.geosus.paciente.infrastructure.gateway.PacienteRepositoryJpaGateway;
import com.geosus.paciente.infrastructure.repository.SpringPacienteJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PacienteRepositoryJpaGatewayTest {

    private SpringPacienteJpaRepository repository;
    private PacienteRepositoryJpaGateway gateway;

    private Paciente paciente;
    private PacienteJpaEntity entity;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(SpringPacienteJpaRepository.class);
        gateway = new PacienteRepositoryJpaGateway(repository);

        paciente = Paciente.builder()
                .id(1L)
                .nome("Lud")
                .cpf("11122233344")
                .dataNascimento(LocalDate.of(1993, 9, 23))
                .endereco("Rua A")
                .build();

        entity = PacienteJpaEntity.fromDomain(paciente);
    }

    @Test
    void deveSalvarPaciente() {
        when(repository.save(any())).thenReturn(entity);

        Paciente salvo = gateway.salvar(paciente);

        assertThat(salvo).usingRecursiveComparison().isEqualTo(paciente);
        verify(repository).save(any());
    }

    @Test
    void deveBuscarPorId() {
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        Optional<Paciente> resultado = gateway.buscarPorId(1L);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getCpf()).isEqualTo("11122233344");
    }

    @Test
    void deveBuscarPorCpf() {
        when(repository.findByCpf("11122233344")).thenReturn(Optional.of(entity));

        Optional<Paciente> resultado = gateway.buscarPorCpf("11122233344");

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Lud");
    }

    @Test
    void deveListarTodos() {
        when(repository.findAll()).thenReturn(List.of(entity));

        List<Paciente> resultado = gateway.listarTodos();

        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNome()).isEqualTo("Lud");
    }
}

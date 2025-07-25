package com.geosus.paciente.adapter.mapper;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PacienteMapperTest {

    @Test
    void deveConverterDeDomainParaJpa() {
        Paciente domain = new Paciente(1L, "Lud", "11122233344", LocalDate.of(1993, 9, 23), "Rua A");

        PacienteJpaEntity entity = PacienteMapper.toEntity(domain);

        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getNome()).isEqualTo("Lud");
        assertThat(entity.getCpf()).isEqualTo("11122233344");
        assertThat(entity.getDataNascimento()).isEqualTo(LocalDate.of(1993, 9, 23));
        assertThat(entity.getEndereco()).isEqualTo("Rua A");
    }

    @Test
    void deveConverterDeJpaParaDomain() {
        PacienteJpaEntity entity = new PacienteJpaEntity(2L, "Victor", "55566677788", LocalDate.of(1991, 3, 5), "Rua B");

        Paciente domain = PacienteMapper.toDomain(entity);

        assertThat(domain.getId()).isEqualTo(2L);
        assertThat(domain.getNome()).isEqualTo("Victor");
        assertThat(domain.getCpf()).isEqualTo("55566677788");
        assertThat(domain.getDataNascimento()).isEqualTo(LocalDate.of(1991, 3, 5));
        assertThat(domain.getEndereco()).isEqualTo("Rua B");
    }
}

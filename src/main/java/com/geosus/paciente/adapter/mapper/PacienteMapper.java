package com.geosus.paciente.adapter.mapper;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;


public class PacienteMapper {

    public static Paciente toDomain(PacienteJpaEntity entity) {
        return Paciente.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .dataNascimento(entity.getDataNascimento())
                .endereco(entity.getEndereco())
                .build();
    }

    public static PacienteJpaEntity toEntity(Paciente domain) {
        return PacienteJpaEntity.builder()
                .id(domain.getId())
                .nome(domain.getNome())
                .cpf(domain.getCpf())
                .dataNascimento(domain.getDataNascimento())
                .endereco(domain.getEndereco())
                .build();
    }
}

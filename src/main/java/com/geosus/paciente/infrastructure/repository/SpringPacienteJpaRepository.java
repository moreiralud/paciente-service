package com.geosus.paciente.infrastructure.repository;

import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringPacienteJpaRepository extends JpaRepository<PacienteJpaEntity, Long> {
    Optional<PacienteJpaEntity> findByCpf(String cpf);
}

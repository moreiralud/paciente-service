package com.geosus.paciente.infrastructure.gateway;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteStorage;
import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;
import com.geosus.paciente.infrastructure.repository.SpringPacienteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Primary
@RequiredArgsConstructor
public class PacienteStorageJpaGateway implements PacienteStorage {

    private final SpringPacienteJpaRepository repository;

    @Override
    public Paciente salvar(Paciente paciente) {
        PacienteJpaEntity entity = PacienteJpaEntity.fromDomain(paciente);
        return repository.save(entity).toDomain();
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return repository.findById(id).map(PacienteJpaEntity::toDomain);
    }

    @Override
    public Optional<Paciente> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).map(PacienteJpaEntity::toDomain);
    }

    @Override
    public List<Paciente> listarTodos() {
        return repository.findAll().stream()
                .map(PacienteJpaEntity::toDomain)
                .collect(Collectors.toList());
    }
}

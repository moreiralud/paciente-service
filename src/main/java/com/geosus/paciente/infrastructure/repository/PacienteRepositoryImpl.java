package com.geosus.paciente.infrastructure.repository;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteRepository;
import com.geosus.paciente.infrastructure.entity.PacienteJpaEntity;
import com.geosus.paciente.adapter.mapper.PacienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PacienteRepositoryImpl implements PacienteRepository {

    private final SpringPacienteJpaRepository jpaRepository;

    @Override
    public Paciente salvar(Paciente paciente) {
        PacienteJpaEntity entity = PacienteMapper.toEntity(paciente);
        return PacienteMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(PacienteMapper::toDomain);
    }

    @Override
    public Optional<Paciente> buscarPorCpf(String cpf) {
        return jpaRepository.findByCpf(cpf).map(PacienteMapper::toDomain);
    }

    @Override
    public List<Paciente> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(PacienteMapper::toDomain)
                .collect(Collectors.toList());
    }
}

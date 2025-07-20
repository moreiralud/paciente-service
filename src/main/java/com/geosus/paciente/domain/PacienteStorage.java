package com.geosus.paciente.domain;

import java.util.List;
import java.util.Optional;

public interface PacienteStorage {
    Paciente salvar(Paciente paciente);
    Optional<Paciente> buscarPorId(Long id);
    Optional<Paciente> buscarPorCpf(String cpf);
    List<Paciente> listarTodos();
}

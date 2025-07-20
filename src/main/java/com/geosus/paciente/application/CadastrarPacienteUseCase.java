package com.geosus.paciente.application;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteStorage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarPacienteUseCase {

    private final PacienteStorage storage;

    public Paciente execute(Paciente paciente) {
        storage.buscarPorCpf(paciente.getCpf()).ifPresent(p -> {
            throw new RuntimeException("CPF já cadastrado");
        });

        return storage.salvar(paciente);
    }
}

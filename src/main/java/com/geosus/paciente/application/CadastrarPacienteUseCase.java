package com.geosus.paciente.application;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarPacienteUseCase {

    private final PacienteRepository storage;

    public Paciente execute(Paciente paciente) {
        storage.buscarPorCpf(paciente.getCpf()).ifPresent(p -> {
            throw new RuntimeException("CPF já cadastrado");
        });

        return storage.salvar(paciente);
    }
}

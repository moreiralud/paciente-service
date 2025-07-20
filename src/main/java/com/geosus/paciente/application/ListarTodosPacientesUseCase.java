package com.geosus.paciente.application;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteStorage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarTodosPacientesUseCase {

    private final PacienteStorage storage;

    public List<Paciente> execute() {
        return storage.listarTodos();
    }
}

package com.geosus.paciente.application;

import com.geosus.paciente.domain.Paciente;
import com.geosus.paciente.domain.PacienteRepository;
import com.geosus.paciente.domain.exception.PacienteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodosPacientesUseCase {

    private final PacienteRepository storage;

    public List<Paciente> execute() {
        return storage.listarTodos();
    }

    public Paciente buscarPorCpf(String cpf) {
        return storage.buscarPorCpf(cpf)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente não encontrado"));
    }
}

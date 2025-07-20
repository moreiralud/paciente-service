package com.geosus.paciente.adapter.controller;

import com.geosus.paciente.application.CadastrarPacienteUseCase;
import com.geosus.paciente.application.ListarTodosPacientesUseCase;
import com.geosus.paciente.domain.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final CadastrarPacienteUseCase cadastrarPacienteUseCase;
    private final ListarTodosPacientesUseCase listarTodosPacientesUseCase;

    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return cadastrarPacienteUseCase.execute(paciente);
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return listarTodosPacientesUseCase.execute();
    }
}

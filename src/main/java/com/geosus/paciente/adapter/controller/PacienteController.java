package com.geosus.paciente.adapter.controller;

import com.geosus.paciente.application.CadastrarPacienteUseCase;
import com.geosus.paciente.application.ListarTodosPacientesUseCase;
import com.geosus.paciente.domain.Paciente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final CadastrarPacienteUseCase cadastrarPacienteUseCase;
    private final ListarTodosPacientesUseCase listarTodosPacientesUseCase;

    @PostMapping
    @Operation(summary = "Cadastrar novo paciente", description = "Cadastra um novo paciente no sistema")
    public ResponseEntity<?> cadastrar(@RequestBody Paciente paciente) {
        try {
            Paciente salvo = cadastrarPacienteUseCase.execute(paciente);
            return ResponseEntity.ok(salvo);
        } catch (RuntimeException ex) {
            if (ex.getMessage().equalsIgnoreCase("CPF já cadastrado")) {
                return ResponseEntity.status(409).body("CPF já cadastrado");
            }
            return ResponseEntity.status(500).body("Erro interno");
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos os pacientes", description = "Retorna uma lista com todos os pacientes cadastrados")
    public List<Paciente> listarTodos() {
        return listarTodosPacientesUseCase.execute();
    }

    @GetMapping("/por-cpf")
    @Operation(summary = "Buscar paciente por CPF", description = "Retorna os dados de um paciente específico a partir do CPF informado")
    public ResponseEntity<Paciente> buscarPorCpf(
            @RequestParam @Parameter(description = "CPF do paciente") String cpf
    ) {
        return ResponseEntity.ok(
                listarTodosPacientesUseCase.buscarPorCpf(cpf)
        );
    }
}

    package com.geosus.paciente.application;

    import com.geosus.paciente.domain.Paciente;
    import com.geosus.paciente.domain.PacienteStorage;
    import io.swagger.v3.oas.annotations.servers.Server;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class ListarTodosPacientesUseCase {

        private final PacienteStorage storage;

        public List<Paciente> execute() {
            return storage.listarTodos();
        }

        public Paciente buscarPorCpf(String cpf) {
            return storage.buscarPorCpf(cpf)
                    .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        }
    }

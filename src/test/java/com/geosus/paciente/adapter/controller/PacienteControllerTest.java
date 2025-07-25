package com.geosus.paciente.adapter.controller;

import com.geosus.paciente.application.CadastrarPacienteUseCase;
import com.geosus.paciente.application.ListarTodosPacientesUseCase;
import com.geosus.paciente.domain.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PacienteController.class)
@ContextConfiguration(classes = {PacienteController.class, PacienteControllerTest.TestConfig.class})
@Import({
        PacienteControllerTest.TestConfig.class,
        com.geosus.paciente.adapter.handler.GlobalExceptionHandler.class
})
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ListarTodosPacientesUseCase listarTodosPacientesUseCase;

    private Paciente paciente;

    @BeforeEach
    void setUp() {
        paciente = new Paciente(1L, "Lud", "11122233344", LocalDate.of(1993, 9, 23), "Rua A");
        when(listarTodosPacientesUseCase.buscarPorCpf("11122233344")).thenReturn(paciente);
    }

    @Test
    void deveBuscarPacientePorCpf() throws Exception {
        mockMvc.perform(get("/pacientes/por-cpf")
                        .param("cpf", "11122233344"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Lud"))
                .andExpect(jsonPath("$.cpf").value("11122233344"));
    }

    @Test
    void deveRetornar404SePacienteNaoEncontrado() throws Exception {
        when(listarTodosPacientesUseCase.buscarPorCpf("99999999999"))
                .thenThrow(new com.geosus.paciente.domain.exception.PacienteNotFoundException("Paciente não encontrado"));

        mockMvc.perform(get("/pacientes/por-cpf")
                        .param("cpf", "99999999999"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Paciente não encontrado"));
    }



    @TestConfiguration
    static class TestConfig {
        @Bean
        public ListarTodosPacientesUseCase listarTodosPacientesUseCase() {
            return Mockito.mock(ListarTodosPacientesUseCase.class);
        }

        @Bean
        public CadastrarPacienteUseCase cadastrarPacienteUseCase() {
            return Mockito.mock(CadastrarPacienteUseCase.class);
        }
    }
}

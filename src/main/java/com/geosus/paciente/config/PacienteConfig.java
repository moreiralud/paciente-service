//package com.geosus.paciente.config;
//
//import com.geosus.paciente.application.CadastrarPacienteUseCase;
//import com.geosus.paciente.application.ListarTodosPacientesUseCase;
//import com.geosus.paciente.domain.PacienteStorage;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class PacienteConfig {
//
//    @Bean
//    public CadastrarPacienteUseCase cadastrarPacienteUseCase(PacienteStorage storage) {
//        return new CadastrarPacienteUseCase(storage);
//    }
//
//    @Bean
//    public ListarTodosPacientesUseCase listarTodosPacientesUseCase(PacienteStorage storage) {
//        return new ListarTodosPacientesUseCase(storage);
//    }
//}

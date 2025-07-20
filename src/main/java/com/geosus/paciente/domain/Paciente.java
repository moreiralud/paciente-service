package com.geosus.paciente.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
}

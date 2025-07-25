package com.geosus.paciente.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;

    public Paciente(String lud, String number, String date, String endereco) {
    }
}

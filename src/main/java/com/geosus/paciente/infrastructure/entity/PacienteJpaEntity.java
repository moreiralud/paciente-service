package com.geosus.paciente.infrastructure.entity;

import com.geosus.paciente.domain.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private LocalDate dataNascimento;

    private String endereco;

    public static PacienteJpaEntity fromDomain(Paciente paciente) {
        return PacienteJpaEntity.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .cpf(paciente.getCpf())
                .dataNascimento(paciente.getDataNascimento())
                .endereco(paciente.getEndereco())
                .build();

    }

    public Paciente toDomain() {
        return new Paciente(
                this.id,
                this.nome,
                this.cpf,
                this.dataNascimento,
                this.endereco
        );
    }
}

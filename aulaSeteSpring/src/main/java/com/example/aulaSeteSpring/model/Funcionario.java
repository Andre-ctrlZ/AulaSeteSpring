package com.example.aulaSeteSpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "O RG é obrigatório.")
    private String rg;

    @NotBlank(message = "A matricula é obrigatória.")
    private String matricula;

    @NotBlank(message = "A data de nascimento é obrigatória")
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Setor setor;


    private Double Salario;

    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    @NotBlank
    @Email(message = "Insira um email valido!")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}

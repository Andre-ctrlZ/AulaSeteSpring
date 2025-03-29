package com.example.aulaSeteSpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tab_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Logradouro não pode ser vazio.")
    private String logradouro;

    @NotBlank(message = "Número não pode ser vazio.")
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    @Size(max = 2)
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Logradouro não pode ser vazio.") String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(@NotBlank(message = "Logradouro não pode ser vazio.") String logradouro) {
        this.logradouro = logradouro;
    }

    public @NotBlank(message = "Número não pode ser vazio.") String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank(message = "Número não pode ser vazio.") String numero) {
        this.numero = numero;
    }

    public @NotBlank String getComplemento() {
        return complemento;
    }

    public void setComplemento(@NotBlank String complemento) {
        this.complemento = complemento;
    }

    public @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotBlank String cep) {
        this.cep = cep;
    }

    public @NotBlank String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank String cidade) {
        this.cidade = cidade;
    }

    public @NotBlank @Size(max = 2) String getUf() {
        return uf;
    }

    public void setUf(@NotBlank @Size(max = 2) String uf) {
        this.uf = uf;
    }
}

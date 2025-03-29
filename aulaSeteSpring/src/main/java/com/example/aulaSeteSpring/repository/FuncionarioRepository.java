package com.example.aulaSeteSpring.repository;

import com.example.aulaSeteSpring.model.Funcionario;
import com.example.aulaSeteSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Usuario> findByEmail(String email);
}

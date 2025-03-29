package com.example.aulaSeteSpring.controller;

import com.example.aulaSeteSpring.model.Usuario;
import com.example.aulaSeteSpring.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> ListarTodos(){
       return usuarioService.ListarUsuarios();
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.mensagem(usuario));
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
        return ResponseEntity.ok().body(usuarioService.mensagemAtualizar(usuario));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> excluir(@PathVariable String email){
        usuarioService.excluir(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário excluido com sucesso!");
    }
}

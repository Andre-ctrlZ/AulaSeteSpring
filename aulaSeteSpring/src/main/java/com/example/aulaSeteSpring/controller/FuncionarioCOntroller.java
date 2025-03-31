package com.example.aulaSeteSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aulaSeteSpring.model.Funcionario;
import com.example.aulaSeteSpring.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioCOntroller {
    private FuncionarioService funcionarioService;

    public FuncionarioCOntroller(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos(){
        return funcionarioService.ListarFuncionario();
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.mensagem(funcionario));
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok().body(funcionarioService.mensagemAtualizar(funcionario));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> excluir(@PathVariable String email){
        funcionarioService.excluir(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Funcionario excluído com sucesso!");
    }
}

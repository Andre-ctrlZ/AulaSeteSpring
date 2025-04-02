package com.example.aulaSeteSpring.service;

import com.example.aulaSeteSpring.model.Funcionario;
import com.example.aulaSeteSpring.model.Usuario;
import com.example.aulaSeteSpring.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> ListarFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setRg(funcionario.getRg());
        funcionarioAtualizar.setMatricula(funcionario.getMatricula());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setTelefone(funcionario.getTelefone());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        return funcionarioRepository.save(funcionario);
    }

    public void excluir(String Email){
        Funcionario funcionario = funcionarioRepository.findByEmail(Email)
            .orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));
        
        funcionarioRepository.deleteById(funcionario.getId());
    }

    public String mensagem(Funcionario funcionario){
        return "Funcionario " + funcionario.getNome() + " cadastrado com sucesso!";
    }

    public String mensagemAtualizar(Funcionario funcionario){
        return "Os dados de " + funcionario.getNome() + " foram alterados com sucesso!";
    }

    public String mensagemExcluir(Funcionario funcionario){
        return "Os dados foram excluidos";
    }
}

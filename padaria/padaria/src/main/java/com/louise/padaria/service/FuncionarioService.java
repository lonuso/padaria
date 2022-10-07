package com.louise.padaria.service;

import com.louise.padaria.model.Funcionario;
import com.louise.padaria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service -> anotaçãoque indica que essa classe é uma classe de serviço
@Service
public class FuncionarioService {
    //Autowired -> é responsavel por fazer a instanciação do repository
    @Autowired
    private FuncionarioRepository repository;

    public boolean salvarFuncionario(Funcionario funcionario){
        repository.save(funcionario);
        return true;
    }

    public boolean deletarFuncionario(Funcionario f){
        Funcionario funcionario = buscarFuncionarioPorId(f.getId());
        if(funcionario != null){
            repository.delete(f);
            return true;
        }
        return false;
    }

    public boolean atualizarFuncionario(Funcionario func){
        Funcionario funcionario = buscarFuncionarioPorId(func.getId());
        if (funcionario != null){
            repository.save(func);
            return true;
        }
        return false;

    }

    public Funcionario buscarFuncionarioPorId(Integer id){
        Funcionario funcionario = repository.findById(id).get();
        return funcionario;

    }

    public List<Funcionario> buscarTodosFuncionarios(){
        return repository.findAll();
    }

}

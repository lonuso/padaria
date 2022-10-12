package com.louise.padaria.service;

import com.louise.padaria.model.Funcionario;
import com.louise.padaria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean deletarFuncionario(Integer f){
        if(f != null){
            Funcionario funcionario = buscarFuncionarioPorId(f);
            if(funcionario != null){
                repository.delete(funcionario);
                return true;
            }

        }

        return false;
    }

    public boolean atualizarFuncionario(Funcionario func){
        if(func != null){
            Funcionario funcionario = buscarFuncionarioPorId(func.getId());
            if (funcionario != null){
                repository.save(func);
                return true;
            }
        }

        return false;

    }

    public Funcionario buscarFuncionarioPorId(Integer id){
        if(id == null){
            return null;
        }
        Optional<Funcionario>funcionario = repository.findById(id);
        if(funcionario.isPresent()){
            return funcionario.get();
        }
        return null;

    }

    public List<Funcionario> buscarTodosFuncionarios(){
        return repository.findAll();
    }

}

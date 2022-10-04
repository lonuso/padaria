package com.louise.padaria.service;

import com.louise.padaria.model.Funcionario;
import com.louise.padaria.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
//Service -> anotaçãoque indica que essa classe é uma classe de serviço
@Service
public class FuncionarioService {
    private FuncionarioRepository repository;

    public Funcionario buscarFuncionarioPorId(Integer id){
        Funcionario funcionario = repository.findById(id).get();
        return funcionario;

    }

}

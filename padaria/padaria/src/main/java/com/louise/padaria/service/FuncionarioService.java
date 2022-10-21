package com.louise.padaria.service;

import com.louise.padaria.dto.FuncionarioConsultarDto;
import com.louise.padaria.dto.FuncionarioDto;
import com.louise.padaria.dto.FuncionarioEditarDto;
import com.louise.padaria.dto.FuncionarioSalvarDto;
import com.louise.padaria.mapper.FuncionarioMapper;
import com.louise.padaria.model.Funcionario;
import com.louise.padaria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Service -> anotaçãoque indica que essa classe é uma classe de serviço
@Service
public class FuncionarioService {
    //Autowired -> é responsavel por fazer a instanciação do repository
    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private FuncionarioMapper mapper;
    public boolean salvarFuncionario(FuncionarioSalvarDto dto){
        Funcionario funcionario = mapper.converterDtoParaModel(dto);
        repository.save(funcionario);
        return true;
    }

    public boolean deletarFuncionario(Integer f){
        if(f != null){
            Funcionario funcionario = mapper.converterDtoParaModel(buscarFuncionarioPorId(f));
            if(funcionario != null){
                repository.delete(funcionario);
                return true;
            }
        }
        return false;
    }
    public boolean atualizarFuncionario(FuncionarioEditarDto func){
        if(func != null){
            FuncionarioConsultarDto funcionario = buscarFuncionarioPorId(func.getId());
            if (funcionario != null){
                Funcionario funcionarioAtualizar = mapper.converterDtoParaModel(func);
                repository.save(funcionarioAtualizar);
                return true;
            }
        }
        return false;
    }
    public FuncionarioConsultarDto buscarFuncionarioPorId(Integer id){
        if(id == null){
            return null;
        }
        Optional<Funcionario>funcionario = repository.findById(id);
        if(funcionario.isPresent()){
            FuncionarioConsultarDto dto = mapper.converteModelParaConsultar(funcionario.get());
            return dto;
        }
        return null;
    }

    public List<FuncionarioDto> buscarTodosFuncionarios(){
        List<FuncionarioDto>lista = new ArrayList<>();
        for (Funcionario f: repository.findAll()) {
            lista.add(mapper.converteModelParaDto(f));
        }
        return lista;
    }
}

package com.louise.padaria.mapper;

import com.louise.padaria.dto.FuncionarioConsultarDto;
import com.louise.padaria.dto.FuncionarioDto;
import com.louise.padaria.dto.FuncionarioEditarDto;
import com.louise.padaria.dto.FuncionarioSalvarDto;
import com.louise.padaria.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    //Usou-se sobrecarga no metodo converter dto para model
    //Que quer dizer que possui várias funções com o mesmo nome, mas com parametros diferentes.
    public FuncionarioDto converteModelParaDto(Funcionario model) {
        FuncionarioDto dto = new FuncionarioDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setCargo(model.getCargo());
        return dto;
    }
    public Funcionario converterDtoParaModel(FuncionarioDto dto) {
        Funcionario model = new Funcionario();
        model.setId(dto.getId());
        model.setCargo(dto.getCargo());
        model.setNome(dto.getNome());
        return model;
    }
    public FuncionarioEditarDto converteModelParaDtoEditar(Funcionario model) {
        FuncionarioEditarDto dto = new FuncionarioEditarDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setCargo(model.getCargo());
        dto.setCpf(model.getCpf());
        dto.setTelefone(model.getTelefone());

        return dto;
    }
    public Funcionario converterDtoParaModel(FuncionarioEditarDto dto) {
        Funcionario model = new Funcionario();
        model.setId(dto.getId());
        model.setCargo(dto.getCargo());
        model.setNome(dto.getNome());
        model.setCpf(dto.getCpf());
        model.setTelefone(dto.getTelefone());

        return model;
    }

    public FuncionarioSalvarDto converteModelParaSalvar(Funcionario model) {
        FuncionarioSalvarDto dto = new FuncionarioSalvarDto();
        dto.setNome(model.getNome());
        dto.setCargo(model.getCargo());
        dto.setCpf(model.getCpf());
        dto.setTelefone(model.getTelefone());
        return dto;
    }
    public Funcionario converterDtoParaModel(FuncionarioSalvarDto dto) {
        Funcionario model = new Funcionario();
        model.setCargo(dto.getCargo());
        model.setNome(dto.getNome());
        model.setTelefone(dto.getTelefone());
        model.setCpf(dto.getCpf());
        return model;
    }

    public FuncionarioConsultarDto converteModelParaConsultar(Funcionario model) {
        FuncionarioConsultarDto dto = new FuncionarioConsultarDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setCargo(model.getCargo());
        dto.setCpf(model.getCpf());
        dto.setTelefone(model.getTelefone());
        return dto;
    }
    public Funcionario converterDtoParaModel(FuncionarioConsultarDto dto) {
        Funcionario model = new Funcionario();
        model.setId(dto.getId());
        model.setCargo(dto.getCargo());
        model.setNome(dto.getNome());
        model.setTelefone(dto.getTelefone());
        model.setCpf(dto.getCpf());
        return model;
    }
}

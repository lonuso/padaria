package com.louise.padaria.mapper;

import com.louise.padaria.dto.ClienteConsultarDto;
import com.louise.padaria.dto.ClienteDto;
import com.louise.padaria.dto.ClienteEditarDto;
import com.louise.padaria.dto.ClienteSalvarDto;
import com.louise.padaria.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDto converteModelParaDto(Cliente model){
        ClienteDto dto = new ClienteDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        return dto;
    }
    public Cliente converteDtoParaModel(ClienteDto dto){
        Cliente model = new Cliente();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        return model;
    }
    public ClienteEditarDto converteModelParaDtoEditar(Cliente model){
        ClienteEditarDto dto = new ClienteEditarDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setCpf(model.getCpf());
        dto.setTelefone(model.getTelefone());
        dto.setEmail(model.getEmail());
        dto.setData(model.getData());
        return dto;
    }
    public Cliente converteDtoParaModel(ClienteEditarDto dto){
        Cliente model = new Cliente();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setCpf(dto.getCpf());
        model.setTelefone(dto.getTelefone());
        model.setEmail(dto.getEmail());
        model.setData(dto.getData());
        return model;
    }
    public ClienteSalvarDto converteModelParaDtoSalvar(Cliente model){
        ClienteSalvarDto dto = new ClienteSalvarDto();
        dto.setNome(model.getNome());
        dto.setCpf(model.getCpf());
        dto.setEmail(model.getEmail());
        dto.setData(model.getData());
        dto.setTelefone(model.getTelefone());
        return dto;
    }
    public Cliente converteDtoParaModel(ClienteSalvarDto dto){
        Cliente model = new Cliente();
        model.setNome(dto.getNome());
        model.setCpf(dto.getCpf());
        model.setEmail(dto.getEmail());
        model.setData(dto.getData());
        model.setTelefone(dto.getTelefone());
        return model;
    }
    public ClienteConsultarDto converteModelParaConsultar(Cliente model){
        ClienteConsultarDto dto = new ClienteConsultarDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setCpf(model.getCpf());
        dto.setTelefone(model.getTelefone());
        dto.setEmail(model.getEmail());
        dto.setData(model.getData());
        return dto;
    }
    public Cliente converteDtoParaModel(ClienteConsultarDto dto){
        Cliente model = new Cliente();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setCpf(dto.getCpf());
        model.setTelefone(dto.getTelefone());
        model.setEmail(dto.getEmail());
        model.setData(dto.getData());
        return model;
    }
}

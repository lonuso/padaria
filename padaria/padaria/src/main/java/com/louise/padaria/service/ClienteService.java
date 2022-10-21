package com.louise.padaria.service;

import com.louise.padaria.dto.ClienteConsultarDto;
import com.louise.padaria.dto.ClienteDto;
import com.louise.padaria.dto.ClienteEditarDto;
import com.louise.padaria.dto.ClienteSalvarDto;
import com.louise.padaria.mapper.ClienteMapper;
import com.louise.padaria.model.Cliente;
import com.louise.padaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteMapper mapper;
    public boolean salvarCliente(ClienteSalvarDto dto){
        Cliente cliente = mapper.converteDtoParaModel(dto);
        repository.save(cliente);
        return true;
    }

    public boolean deletarCliente(Integer c){
        if(c != null){
            Cliente cliente = mapper.converteDtoParaModel(buscarClientePorId(c));
            if(cliente != null){
                repository.delete(cliente);
                return true;
            }
        }
        return false;
    }
    public boolean atualizarCliente(ClienteEditarDto cli){
        if(cli != null){
            ClienteConsultarDto cliente = buscarClientePorId(cli.getId());
            if (cliente != null){
                Cliente clienteAtualizar = mapper.converteDtoParaModel(cli);
                repository.save(clienteAtualizar);
                return true;
            }
        }
        return false;
    }
    public ClienteConsultarDto buscarClientePorId(Integer id){
        if(id == null){
            return null;
        }
        Optional<Cliente>cliente = repository.findById(id);
        if(cliente.isPresent()){
            ClienteConsultarDto dto = mapper.converteModelParaConsultar(cliente.get());
            return dto;
        }
        return null;
    }

    public List<ClienteDto> buscarTodosClientes(){
        List<ClienteDto>lista = new ArrayList<>();
        for (Cliente c: repository.findAll()){
            lista.add(mapper.converteModelParaDto(c));
        }
        return lista;
    }
}

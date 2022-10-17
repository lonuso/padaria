package com.louise.padaria.service;

import com.louise.padaria.model.Cliente;
import com.louise.padaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public boolean salvarCliente(Cliente cliente){
        repository.save(cliente);
        return true;
    }

    public boolean deletarCliente(Integer c){
        if(c != null){
            Cliente cliente = buscarClientePorId(c);
            if(cliente != null){
                repository.delete(cliente);
                return true;
            }

        }

        return false;
    }

    public boolean atualizarCliente(Cliente cli){
        if(cli != null){
            Cliente cliente = buscarClientePorId(cli.getId());
            if (cliente != null){
                repository.save(cli);
                return true;

            }
        }
        return false;
    }

    public Cliente buscarClientePorId(Integer id){
        if(id == null){
            return null;
        }
        Optional<Cliente>cliente = repository.findById(id);
        if(cliente.isPresent()){
            return cliente.get();
        }
        return null;
    }

    public List<Cliente> buscarTodosClientes(){

        return repository.findAll();
    }

}

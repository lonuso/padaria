package com.louise.padaria.service;

import com.louise.padaria.model.Cliente;
import com.louise.padaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public boolean salvarCliente(Cliente cliente){
        repository.save(cliente);
        return true;
    }

    public boolean deletarCliente(Cliente c){
        Cliente cliente = buscarClientePorId(c.getId());
        if(cliente != null){
            repository.delete(c);
            return true;
        }
        return false;
    }

    public boolean atualizarCliente(Cliente cli){
        Cliente cliente = buscarClientePorId(cli.getId());
        if (cliente != null){
            repository.save(cli);
            return true;

        }
        return false;
    }

    public Cliente buscarClientePorId(Integer id){
        Cliente cliente = repository.findById(id).get();
        return cliente;
    }

    public List<Cliente> buscarTodosClientes(){

        return repository.findAll();
    }

}

package com.louise.padaria.service;

import com.louise.padaria.model.Pedido;
import com.louise.padaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public boolean salvarPedido(Pedido pedido){
        repository.save(pedido);
        return true;
    }
    
    public boolean deletarPedido(Pedido p){
        Pedido pedido = buscarPedidoPorId(p.getId());
        if(pedido != null){
            repository.delete(p);
            return true;
        }
        return false;
    }

    public boolean atualizarPedido(Pedido ped){
        Pedido pedido = buscarPedidoPorId(ped.getId());
        if (pedido != null){
            repository.save(ped);
            return true;
        }
        return false;
    }

    public Pedido buscarPedidoPorId(Integer id) {
        Pedido pedido = repository.findById(id).get();
        return pedido;

    }

}

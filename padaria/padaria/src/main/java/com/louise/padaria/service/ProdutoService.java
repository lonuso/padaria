package com.louise.padaria.service;

import com.louise.padaria.model.Produto;
import com.louise.padaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public boolean salvarProduto(Produto produto){
        repository.save(produto);
        return true;
    }

    public boolean deletarProduto(Produto pr){
        Produto produto = buscarProdutoPorId(pr.getId());
        if(produto != null){
            repository.delete(pr);
            return true;
        }
        return false;
    }
    public boolean atualizarProduto(Produto prod){
        Produto produto = buscarProdutoPorId(prod.getId());
        if (produto != null){
            repository.save(prod);
            return true;
        }
        return false;
    }

    public Produto buscarProdutoPorId(Integer id){
        Produto produto = repository.findById(id).get();
        return produto;

    }
    public List<Produto> buscarTodosProdutos(){
        return repository.findAll();
    }

}

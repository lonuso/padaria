package com.louise.padaria.service;

import com.louise.padaria.dto.ProdutoConsultarDto;
import com.louise.padaria.dto.ProdutoDto;
import com.louise.padaria.dto.ProdutoEditarDto;
import com.louise.padaria.dto.ProdutoSalvarDto;
import com.louise.padaria.excessao.ProdutoInvalidoException;
import com.louise.padaria.mapper.ProdutoMapper;
import com.louise.padaria.model.Produto;
import com.louise.padaria.repository.ProdutoRepository;
import com.louise.padaria.util.validacao.ProdutoValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private ProdutoMapper mapper;
    @Autowired
    private ProdutoValidacao validacao;

    public boolean salvarProduto(ProdutoSalvarDto dto) throws ProdutoInvalidoException {
        validacao.produtoValido(dto);
            Produto produto = mapper.converteDtoParaModel(dto);
            repository.save(produto);
            return true;
    }
    public boolean deletarProduto(Integer pr){
        if(pr != null) {
            Produto produto = mapper.converteDtoParaModel(buscarProdutoPorId(pr));
            if (produto != null) {
                repository.delete(produto);
                return true;
            }
        }
        return false;
    }
    public boolean atualizarProduto(ProdutoEditarDto prod){
        if(prod != null){
            ProdutoConsultarDto produto = buscarProdutoPorId(prod.getId());
            if (produto != null){
                 Produto produtoAtualizar = mapper.converteDtoParaModel(prod);
                 repository.save(produtoAtualizar);
                 return true;
            }
        }
        return false;
    }

    public ProdutoConsultarDto buscarProdutoPorId(Integer id){
        if(id == null){
            return null;
        }
       Optional<Produto>produto = repository.findById(id);
       if(produto.isPresent()){
           ProdutoConsultarDto dto = mapper.converteModelParaConsultar(produto.get());
           return dto;
       }
        return null;
    }
    public List<ProdutoDto> buscarTodosProdutos(){
        List<ProdutoDto>lista = new ArrayList<>();
        for (Produto p: repository.findAll()){
            lista.add(mapper.converteModelParaDto(p));
        }
        return lista;
    }
}

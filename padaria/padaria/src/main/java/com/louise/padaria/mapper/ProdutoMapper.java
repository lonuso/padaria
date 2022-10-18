package com.louise.padaria.mapper;

import com.louise.padaria.dto.ProdutoConsultarDto;
import com.louise.padaria.dto.ProdutoDto;
import com.louise.padaria.dto.ProdutoEditarDto;
import com.louise.padaria.dto.ProdutoSalvarDto;
import com.louise.padaria.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDto converteModelParaDto(Produto model){
        ProdutoDto dto = new ProdutoDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        return dto;
    }
    public Produto converteDtoParaModel(ProdutoDto dto){
        Produto model = new Produto();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        return model;
    }
    public ProdutoEditarDto converteModelParaDtoEditar(Produto model){
        ProdutoEditarDto dto = new ProdutoEditarDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setPreco(dto.getPreco());
        dto.setQuantidade(dto.getQuantidade());
        return dto;
    }
    public Produto converteDtoParaModel(ProdutoEditarDto dto){
        Produto model = new Produto();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setPreco(dto.getPreco());
        model.setQuantidade(dto.getQuantidade());
        return model;
    }
    public ProdutoSalvarDto converteModelParaSalvar(Produto model){
        ProdutoSalvarDto dto = new ProdutoSalvarDto();
        dto.setNome(model.getNome());
        dto.setPreco(model.getPreco());
        dto.setQuantidade(model.getQuantidade());
        return dto;
    }
    public Produto converteDtoParaModel(ProdutoSalvarDto dto){
        Produto model = new Produto();
        model.setNome(dto.getNome());
        model.setPreco(dto.getPreco());
        model.setQuantidade(dto.getQuantidade());
        return model;
    }
    public ProdutoConsultarDto converteModelParaConsultar(Produto model){
        ProdutoConsultarDto dto = new ProdutoConsultarDto();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setPreco(model.getPreco());
        dto.setQuantidade(model.getQuantidade());
        return dto;
    }
    public Produto converteDtoParaConsultar(ProdutoConsultarDto dto){
        Produto model = new Produto();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setPreco(dto.getPreco());
        model.setQuantidade(dto.getQuantidade());
        return model;
    }

}

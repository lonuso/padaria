package com.louise.padaria.util.validacao;

import com.louise.padaria.dto.ProdutoSalvarDto;
import com.louise.padaria.excessao.*;
import com.louise.padaria.excessao.dto.ErroData;
import com.louise.padaria.excessao.dto.ErroValor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoValidacao {
    public void produtoValidacao(ProdutoSalvarDto dto) throws ProdutoInvalidoException {
        try {
            verificaProduto(dto) ;
        }catch (NomeInvalidoException | PrecoInvalidoException | QuantidadeInvalidoException e){
            throw new ProdutoInvalidoException(e.getMessage());
        }
    }
    public void produtoValido(ProdutoSalvarDto dto) throws ProdutoInvalidoException{
        verificaProdutoErro(dto);
    }
    private void verificaProduto(ProdutoSalvarDto dto) throws NomeInvalidoException, PrecoInvalidoException, QuantidadeInvalidoException {
        if(!isStringNaoNulaENaoVazia(dto.getNome())){
            throw new NomeInvalidoException("O nome que você informou é invalido, informe um não nulo e não vazio");
        }
        if(!isPrecoValido(dto.getPreco())){
            throw new PrecoInvalidoException("O preço que você informou é invalido, informe um não nulo e não vazio");
        }
        if(!isQuantidadeValido(dto.getQuantidade())){
            throw new QuantidadeInvalidoException("O quantidade que você informou é invalido, informe um não nulo e não vazio");
        }
    }
    private void verificaProdutoErro(ProdutoSalvarDto dto) throws ProdutoInvalidoException {
        List<ErroValor> listaErro = new ArrayList<>();

        if(!isStringNaoNulaENaoVazia(dto.getNome())){
            listaErro.add(new ErroValor("O nome que você informou é inválido, informe um não nulo e não vazio", dto.getNome()));
        }
        if(!isPrecoValido(dto.getPreco())){
             listaErro.add(new ErroValor("O preço que você informou é inválido", dto.getPreco()));
        }
        if(!isQuantidadeValido(dto.getQuantidade())){
            listaErro.add(new ErroValor("O quantidade que você informou é inválido", dto.getQuantidade()));
        }
        if(listaErro.size()>0){
            throw new ProdutoInvalidoException(new ErroData("O produto informado é invalido", listaErro));
        }

    }

    private static void adicionaErro(ErroValor dto, List<ErroValor> listaErro) {
        listaErro.add(dto);
    }

    private boolean isPrecoValido(Double preco){
        return preco != null && preco >= 0;
    }
    private boolean isQuantidadeValido(Integer quantidade){
        return quantidade != null && quantidade >= 0;
    }
    private boolean isNumero(String valor){

        return isStringNaoNulaENaoVazia(valor) && StringUtils.isNumeric(valor);
    }
    private boolean isPadraoEmail(String email){
        return isStringNaoNulaENaoVazia(email) && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }


    private boolean isStringNaoNulaENaoVazia(String valor){
        return valor!= null && !valor.trim().isEmpty();
    }
}


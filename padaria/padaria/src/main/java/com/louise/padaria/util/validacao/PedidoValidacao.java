package com.louise.padaria.util.validacao;

import com.louise.padaria.dto.ClienteSalvarDto;
import com.louise.padaria.dto.PedidoSalvarDto;
import com.louise.padaria.excessao.*;
import com.louise.padaria.excessao.dto.ErroData;
import com.louise.padaria.excessao.dto.ErroValor;
import com.louise.padaria.model.Pedido;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoValidacao {
    public void pedidoValidacao(PedidoSalvarDto dto) throws PedidoInvalidoException{
        try{
            verificaPedido(dto);
        }catch (QuantidadeInvalidoException | ValorInvalidoException e){
            throw new PedidoInvalidoException(e.getMessage());
        }
    }
    public void pedidoValido(PedidoSalvarDto dto) throws PedidoInvalidoException{
            verificaPedidoErro(dto);
    }
    private void verificaPedido(PedidoSalvarDto dto) throws QuantidadeInvalidoException, ValorInvalidoException{
        if(!isQuantidadeValido(dto.getQuantidade())) {
            throw new QuantidadeInvalidoException("A quantidade que você informou é inválido, informe um não nulo e não vazio");
        }
        if(!isValorValido(dto.getValor())){
            throw new ValorInvalidoException("O valor que você informou é invalido, informe um não nulo e não vazio");
        }
    }
    private boolean isValorValido(Double valor) {
        return valor != null && valor >= 0;
    }

    private void verificaPedidoErro(PedidoSalvarDto dto) throws PedidoInvalidoException {
        List<ErroValor> listaErro = new ArrayList<>();
        if(!isQuantidadeValido(dto.getQuantidade())) {
            listaErro.add(new ErroValor("A quantidade que você informou é inválida, informe um não nulo e não vazio", dto.getQuantidade()));
        }
        if(!isValorValido(dto.getValor())){
            listaErro.add(new ErroValor("O valor que você informou é inválido", dto.getValor()));
        }
        if(listaErro.size()>0){
            throw new PedidoInvalidoException(new ErroData("O cliente informado é invalido", listaErro));
        }
    }

    private static void adicionaErro(ErroValor dto, List<ErroValor> listaErro) {
        listaErro.add(dto);
    }
    private boolean isQuantidadeValido(Integer quantidade){
        return quantidade != null && quantidade >= 0;
    }
    private boolean isNumero(String valor){
        return isStringNaoNulaENaoVazia(valor) && StringUtils.isNumeric(valor);
    }
    private boolean isStringNaoNulaENaoVazia(String valor){
        return valor!= null && !valor.trim().isEmpty();
    }
}

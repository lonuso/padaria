package com.louise.padaria.util.validacao;

import com.louise.padaria.dto.FuncionarioSalvarDto;
import com.louise.padaria.excessao.*;
import com.louise.padaria.excessao.dto.ErroData;
import com.louise.padaria.excessao.dto.ErroValor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FuncionarioValidacao {
    public void funcionarioValidacao(FuncionarioSalvarDto dto) throws FuncionarioInvalidoException{
        try {
            verificaFuncionario(dto);
        }catch (NomeInvalidoException | CargoInvalidoException | CpfInvalidoException | TelefoneInvalidoException e){
            throw new FuncionarioInvalidoException(e.getMessage());
        }
    }
    public void funcionarioValido(FuncionarioSalvarDto dto)throws FuncionarioInvalidoException{
        verificaFuncionarioErro(dto);
    }
    private void verificaFuncionario(FuncionarioSalvarDto dto) throws NomeInvalidoException, CargoInvalidoException, CpfInvalidoException, TelefoneInvalidoException {
        if(!isStringNaoNulaENaoVazia(dto.getNome())){
            throw new NomeInvalidoException("O nome que você informou é invalido, informe um não nulo e não vazio");
        }
        if(!isCargoValido(dto.getCargo())){
            throw new CargoInvalidoException("O cargo que você informou é invalido, informe um não nulo e não vazio");
        }
        if(!isCpfValido(dto.getCpf())) {
            throw new CpfInvalidoException("O cpf que você informou é inválido, informe um não nulo e não vazio");
        }
        if(!isTelefoneValido(dto.getTelefone())){
            throw new TelefoneInvalidoException("O telefone que você informou é invalido, informe um não nulo e não vazio");
        }

    }
    private void verificaFuncionarioErro(FuncionarioSalvarDto dto) throws FuncionarioInvalidoException {
        List<ErroValor> listaErro = new ArrayList<>();
        if(!isStringNaoNulaENaoVazia(dto.getNome())){
            listaErro.add(new ErroValor("O nome que você informou é inválido, informe um não nulo e não vazio", dto.getNome()));
        }
        if(!isCargoValido(dto.getCargo())){
            listaErro.add(new ErroValor("O cargo que você informou é inválido", dto.getCargo()));
        }
        if(!isCpfValido(dto.getCpf())) {
            listaErro.add(new ErroValor("O cpf que você informou é inválido, informe um não nulo e não vazio", dto.getCpf()));
        }
        if(!isTelefoneValido(dto.getTelefone())){
            listaErro.add(new ErroValor("O telefone que você informou é inválido", dto.getTelefone()));
        }
        if(listaErro.size()>0){
            throw new FuncionarioInvalidoException(new ErroData("O funcionario informado é inválido", listaErro));
        }
    }

    private static void adicionaErro(ErroValor dto, List<ErroValor> listaErro) {
        listaErro.add(dto);
    }
    private boolean isCargoValido(String cargo){
        return isStringNaoNulaENaoVazia(cargo);
    }
    private boolean isCpfValido(String cpf){
        return isStringNaoNulaENaoVazia(cpf) && cpf.length()>0 && (cpf.length() == 14 || cpf.length() == 11)
                && isPadraoCpf(cpf);
    }
    private boolean isTelefoneValido(String telefone){
        return !isStringNaoNulaENaoVazia(telefone) || (isStringNaoNulaENaoVazia(telefone) && telefone.length()>0
                && isPadraoTelefone(telefone));
    }
    private boolean isNumero(String valor){
        return isStringNaoNulaENaoVazia(valor) && StringUtils.isNumeric(valor);
    }
    private boolean isPadraoCpf(String cpf){
        return isStringNaoNulaENaoVazia(cpf) && (isNumero(cpf) || cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}"));
    }
    private boolean isPadraoTelefone(String telefone){
        return isStringNaoNulaENaoVazia(telefone) && (isNumero(telefone) || telefone.matches("[0-9 +-]"));
    }
    private boolean isStringNaoNulaENaoVazia(String valor){
        return valor!= null && !valor.trim().isEmpty();
    }
}

package com.louise.padaria.util.validacao;

import com.louise.padaria.dto.ClienteSalvarDto;
import com.louise.padaria.excessao.*;
import com.louise.padaria.excessao.dto.ErroData;
import com.louise.padaria.excessao.dto.ErroValor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteValidacao {
    public void clienteValidacao(ClienteSalvarDto dto) throws ClienteInvalidoException{
        try {
            verificaCliente(dto);
        }catch (CpfInvalidoException | NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException | DataInvalidoException e){
            throw new ClienteInvalidoException(e.getMessage());
        }
    }
    public void clienteValido(ClienteSalvarDto dto) throws ClienteInvalidoException{
            verificaClienteErro(dto);

    }

    private void verificaCliente(ClienteSalvarDto dto) throws CpfInvalidoException, NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException, DataInvalidoException {
        if(!isCpfValido(dto.getCpf())) {
            throw new CpfInvalidoException("O cpf que você informou é inválido, informe um não nulo e não vazio");
        }
        if(!isStringNaoNulaENaoVazia(dto.getNome())){
            throw new NomeInvalidoException("O nome que você informou é invalido, informe um não nulo e não vazio");
        }
        if(!isEmailValido(dto.getEmail())){
            throw new EmailInvalidoException("O email que você informou é invalido, informe um não nulo e não vazio");
        }
        if(!isTelefoneValido(dto.getTelefone())){
            throw new TelefoneInvalidoException("O telefone que você informou é invalido, informe um não nulo e não vazio");
        }
        if(dto.getData() == null){
            throw new DataInvalidoException("A data que você informou é invalido, informe um não nulo e não vazio");
        }

    }
    private void verificaClienteErro(ClienteSalvarDto dto) throws ClienteInvalidoException {
        List<ErroValor>listaErro = new ArrayList<>();
        if(!isCpfValido(dto.getCpf())) {
            listaErro.add(new ErroValor("O cpf que você informou é inválido, informe um não nulo e não vazio", dto.getCpf()));
        }
        if(!isStringNaoNulaENaoVazia(dto.getNome())){
            listaErro.add(new ErroValor("O nome que você informou é inválido, informe um não nulo e não vazio", dto.getNome()));
        }
        if(!isEmailValido(dto.getEmail())){
            listaErro.add(new ErroValor("O email que você informou é inválido", dto.getEmail()));
        }
        if(!isTelefoneValido(dto.getTelefone())){
            listaErro.add(new ErroValor("O telefone que você informou é inválido", dto.getTelefone()));
        }
        if(dto.getData() == null){
            listaErro.add(new ErroValor("A data que você informou é inválido, informe um não nulo e não vazio", dto.getData()));
        }
        if(listaErro.size()>0){
            throw new ClienteInvalidoException(new ErroData("O cliente informado é invalido", listaErro));
        }

    }

    private static void adicionaErro(ErroValor dto, List<ErroValor> listaErro) {
        listaErro.add(dto);
    }

    private boolean isCpfValido(String cpf){
        return isStringNaoNulaENaoVazia(cpf) && cpf.length()>0 && (cpf.length() == 14 || cpf.length() == 11)
                && isPadraoCpf(cpf);
    }
    private boolean isTelefoneValido(String telefone){
        return !isStringNaoNulaENaoVazia(telefone) || (isStringNaoNulaENaoVazia(telefone) && telefone.length()>0 && isPadraoTelefone(telefone));
    }
    private boolean isEmailValido(String email){
        return !isStringNaoNulaENaoVazia(email) || (isStringNaoNulaENaoVazia(email) && email.length()>0 && isPadraoEmail(email)) ;
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
    private boolean isPadraoEmail(String email){
        return isStringNaoNulaENaoVazia(email) && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }


    private boolean isStringNaoNulaENaoVazia(String valor){
        return valor!= null && !valor.trim().isEmpty();
    }
}

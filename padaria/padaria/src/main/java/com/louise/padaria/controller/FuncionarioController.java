package com.louise.padaria.controller;

import com.louise.padaria.dto.FuncionarioConsultarDto;
import com.louise.padaria.dto.FuncionarioDto;
import com.louise.padaria.dto.FuncionarioEditarDto;
import com.louise.padaria.dto.FuncionarioSalvarDto;
import com.louise.padaria.excessao.FuncionarioInvalidoException;
import com.louise.padaria.model.Funcionario;
import com.louise.padaria.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController -> Define que a classe é um Controller
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "/funcionario/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FuncionarioConsultarDto> procuraFuncionarioPorId(@PathVariable("id") Integer id){
        FuncionarioConsultarDto funcionario = service.buscarFuncionarioPorId(id);
        if(funcionario != null){
            return new ResponseEntity<>(funcionario,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }
    @PostMapping(value = "/funcionario/salvar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> salvarFuncionario(@RequestBody FuncionarioSalvarDto novo) {
        try {
            boolean salva = service.salvarFuncionario(novo);
            if (salva == true) {
                return new ResponseEntity<>("Salvo com sucesso", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Ocorreu um erro ao salvar", HttpStatus.BAD_REQUEST);
        }catch (FuncionarioInvalidoException e){
            return new ResponseEntity<>(e.getErro().toString(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/funcionario/editar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editarFuncionario(@RequestBody FuncionarioEditarDto funcionario){
        boolean editar = service.atualizarFuncionario(funcionario);
        if(editar == true){
            return new ResponseEntity<>("Editado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/funcionario/deletar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deletarFuncionario(@PathVariable ("id") Integer id){
        boolean deletar = service.deletarFuncionario(id);
        if(deletar == true){
            return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/funcionario/todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FuncionarioDto>> listarTodosFuncionarios(){

            return new ResponseEntity<>(service.buscarTodosFuncionarios(), HttpStatus.OK);


    }

}

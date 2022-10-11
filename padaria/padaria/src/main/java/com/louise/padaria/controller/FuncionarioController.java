package com.louise.padaria.controller;

import com.louise.padaria.model.Funcionario;
import com.louise.padaria.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController -> Define que a classe é um Controller
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "/funcionario/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Funcionario> procuraFuncionarioPorId(@PathVariable("id") Integer id){
        Funcionario funcionario = service.buscarFuncionarioPorId(id);
        if(funcionario != null){
            return new ResponseEntity<>(funcionario,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }
    @PostMapping(value = "/funcionario/salvar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> salvarFuncionario(@RequestBody Funcionario novo){
        boolean salva = service.salvarFuncionario(novo);
        if(salva == true){
            return new ResponseEntity<>("Salvo com sucesso", HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("Ocorreu um erro ao salvar",HttpStatus.BAD_REQUEST);
    }

}

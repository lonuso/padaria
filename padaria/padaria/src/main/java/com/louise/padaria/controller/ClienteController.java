package com.louise.padaria.controller;


import com.louise.padaria.model.Cliente;
import com.louise.padaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/cliente/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente> procuraClientePorId(@PathVariable("id")Integer id){
        Cliente cliente = service.buscarClientePorId(id);
        if(cliente != null){
            return new ResponseEntity<>(cliente,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/cliente/salvar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> salvarCliente(@RequestBody Cliente novo){
        boolean salva = service.salvarCliente(novo);
        if(salva == true){
            return new ResponseEntity<>("Salvo com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Ocorreu um erro ao salvar", HttpStatus.BAD_REQUEST);
    }

}

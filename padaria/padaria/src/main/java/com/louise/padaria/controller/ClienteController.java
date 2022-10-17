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

    @PutMapping(value = "/cliente/editar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editarCliente(@RequestBody Cliente cliente){
        boolean editar = service.atualizarCliente(cliente);
        if(editar == true){
            return new ResponseEntity<>("Editado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/cliente/deletar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deletarCliente(@PathVariable ("id") Integer id){
        boolean deletar = service.deletarCliente(id);
        if(deletar == true){
            return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.BAD_REQUEST);
    }


}

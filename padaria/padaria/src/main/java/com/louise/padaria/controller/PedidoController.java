package com.louise.padaria.controller;

import com.louise.padaria.model.Pedido;
import com.louise.padaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping(value = "/pedido/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Pedido> procuraPedidoPorId(@PathVariable("id")Integer id){
        Pedido pedido = service.buscarPedidoPorId(id);
        if(pedido != null){
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/pedido/salvar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> salvarPedido(@RequestBody Pedido novo){
        boolean salva = service.salvarPedido(novo);
        if(salva == true){
            return new ResponseEntity<>("Salvo com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Ocorreu um erro ao salvar", HttpStatus.BAD_REQUEST);
    }

}

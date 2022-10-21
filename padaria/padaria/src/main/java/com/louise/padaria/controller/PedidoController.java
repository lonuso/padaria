package com.louise.padaria.controller;

import com.louise.padaria.dto.PedidoConsultarDto;
import com.louise.padaria.dto.PedidoEditarDto;
import com.louise.padaria.dto.PedidoSalvarDto;
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
    public ResponseEntity<PedidoConsultarDto> procuraPedidoPorId(@PathVariable("id")Integer id){
        PedidoConsultarDto pedido = service.buscarPedidoPorId(id);
        if(pedido != null){
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/pedido/salvar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> salvarPedido(@RequestBody PedidoSalvarDto novo){
        boolean salva = service.salvarPedido(novo);
        if(salva == true){
            return new ResponseEntity<>("Salvo com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Ocorreu um erro ao salvar", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/pedido/editar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editarPedido(@RequestBody PedidoEditarDto pedido){
        boolean editar = service.atualizarPedido(pedido);
        if(editar == true){
            return new ResponseEntity<>("Editado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/pedido/deletar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deletarPedido(@PathVariable ("id") Integer id){
        boolean deletar = service.deletarPedido(id);
        if(deletar == true){
            return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não se deleta o nada", HttpStatus.BAD_REQUEST);
    }

}

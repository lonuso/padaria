package com.louise.padaria.controller;

import com.louise.padaria.dto.ProdutoConsultarDto;
import com.louise.padaria.dto.ProdutoEditarDto;
import com.louise.padaria.dto.ProdutoSalvarDto;
import com.louise.padaria.model.Produto;
import com.louise.padaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/produto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProdutoConsultarDto> procuraProdutoPorId(@PathVariable("id")Integer id){
        ProdutoConsultarDto produto = service.buscarProdutoPorId(id);
        if(produto != null){
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/produto/salvar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> salvarProduto(@RequestBody ProdutoSalvarDto novo){
        boolean salva = service.salvarProduto(novo);
        if(salva == true){
            return new ResponseEntity<>("Salvo com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Ocorreu um erro ao salvar", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/produto/editar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editarProduto(@RequestBody ProdutoEditarDto produto){
        boolean editar = service.atualizarProduto(produto);
        if(editar == true){
            return new ResponseEntity<>("Editado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/produto/deletar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deletarProduto(@PathVariable ("id") Integer id){
        boolean deletar = service.deletarProduto(id);
        if(deletar == true){
            return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ocorreu erro", HttpStatus.BAD_REQUEST);
    }

}

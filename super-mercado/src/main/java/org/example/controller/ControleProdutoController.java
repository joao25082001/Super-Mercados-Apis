package org.example.controller;

import org.example.DTO.controleProduto.ControleProdutoDTO;
import org.example.DTO.produto.ProdutoDTO;
import org.example.entity.ControleProduto;
import org.example.service.ControleProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/controle")
public class ControleProdutoController {
    @Autowired
    ControleProdutoService controleProdutoService;
    @PostMapping("/cadastrar")
    public ResponseEntity<ControleProduto> cadastrarProduto(@RequestBody ControleProdutoDTO request) throws IOException {
        return ResponseEntity.ok().body(controleProdutoService.cadastroControle(request));
    }

}

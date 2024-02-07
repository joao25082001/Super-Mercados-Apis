package org.example.controller;


import org.example.DTO.produto.ProdutoDTO;
import org.example.DTO.produto.RequestProdutoAtualizacao;
import org.example.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO request) throws IOException {
        return ResponseEntity.ok().body(produtoService.cadastroProduto(request));
    }

    @GetMapping("/exibir")
    public ResponseEntity<List<ProdutoDTO>> exibirUsuarios() {
        return ResponseEntity.ok().body(produtoService.exibiProduto());
    }
    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<RequestProdutoAtualizacao> atualizar(@PathVariable Long id, @RequestBody RequestProdutoAtualizacao request ) {
        return ResponseEntity.ok().body(produtoService.atualizaProduto(id,request));
    }
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok().build();
    }
}

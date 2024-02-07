package org.example.controller;

import org.example.DTO.CaixaDTO;
import org.example.entity.Caixa;
import org.example.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/caixa")
public class CaixaController {
    @Autowired
    CaixaService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Caixa> cadastrarCaixa(@RequestBody CaixaDTO request) throws IOException {
        return ResponseEntity.ok().body(service.cadastrarCaixa(request));
    }

    @PutMapping("/atualizarCaixa")
    public ResponseEntity<String> abrindoOrfechandoCaixa(@RequestParam Integer numeroCaixa, @RequestParam Boolean statusFuncionamento) {
        return ResponseEntity.ok().body(service.abrindoFechandoCaixa(numeroCaixa, statusFuncionamento));
    }
}

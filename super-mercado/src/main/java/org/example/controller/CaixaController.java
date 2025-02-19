package org.example.controller;

import org.example.DTO.caixa.CaixaDTO;
import org.example.entity.Caixa;
import org.example.entity.Lote;
import org.example.exception.ExceptionConflict;
import org.example.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;


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

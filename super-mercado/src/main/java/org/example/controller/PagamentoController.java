package org.example.controller;

import org.example.DTO.pagamento.PagamentoDTO;
import org.example.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    PagamentoService service;
    @PostMapping
    public ResponseEntity<PagamentoDTO> cadastrarVenda(@RequestBody PagamentoDTO request){
        return ResponseEntity.ok().body(service.cadastraPagamento(request));
    }
}

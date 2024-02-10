package org.example.controller;

import org.example.DTO.venda.VendaDTO;
import org.example.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    VendaService service;
    @PostMapping
    public ResponseEntity<VendaDTO> cadastrarVenda(@RequestBody VendaDTO request) throws IOException {

        return ResponseEntity.ok().body(service.cadastraVenda(request));
    }
}

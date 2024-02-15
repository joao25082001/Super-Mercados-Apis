package org.example.controller;

import org.example.DTO.venda.ItensRetornoVendaDTO;
import org.example.DTO.venda.RelatorioMes;
import org.example.DTO.venda.RelatorioVenda;
import org.example.DTO.venda.VendaDTO;
import org.example.service.ArquivoService;
import org.example.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    VendaService service;
    @Autowired
    ArquivoService arquivoService;
    @PostMapping
    public ResponseEntity<VendaDTO> cadastrarVenda(@RequestBody VendaDTO request) throws IOException {

        return ResponseEntity.ok().body(service.cadastraVenda(request));
    }
    @GetMapping
    public ResponseEntity<RelatorioVenda> relatorio(@RequestParam String mesAno) throws IOException {

        return ResponseEntity.ok().body(service.buscaRelatorio(mesAno));
    }


}

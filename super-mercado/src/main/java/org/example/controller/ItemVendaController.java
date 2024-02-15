package org.example.controller;

import org.example.DTO.itemVenda.ItemVendaDTO;
import org.example.DTO.venda.ItensRetornoVendaDTO;
import org.example.entity.ItemVenda;
import org.example.service.ArquivoService;
import org.example.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemVendaController {
    @Autowired
    ItemVendaService service;
    @Autowired
    ArquivoService arquivoService;
    @PostMapping
    public ResponseEntity<ItensRetornoVendaDTO> cadastrarVenda(@RequestBody ItemVendaDTO request){
        return ResponseEntity.ok().body(service.cadastraCompra(request));
    }
    @PostMapping("/cadastrarVendaPorArquivo")
    public ResponseEntity<ItensRetornoVendaDTO> cadastrarVenda(@RequestParam MultipartFile excel, @RequestParam Long idVenda){
        return ResponseEntity.ok().body(arquivoService.teste(excel,idVenda));

    }
}

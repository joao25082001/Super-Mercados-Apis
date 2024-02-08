package org.example.controller;

import org.example.DTO.itemVenda.ItemVendaDTO;
import org.example.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemVendaController {
    @Autowired
    ItemVendaService service;
  /*  @PostMapping
    public ResponseEntity<ItemVendaDTO> cadastrarVenda(@RequestBody ItemVendaDTO request){
        return ResponseEntity.ok().body(service.cadastraCompra(request));
    }*/
}

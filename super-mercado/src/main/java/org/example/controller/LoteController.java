package org.example.controller;

import org.example.entity.Lote;
import org.example.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lote")
public class LoteController {
    @Autowired
    LoteService service;
    @PostMapping("/cadastro")
    public ResponseEntity<Lote> cadastrarLote(@RequestBody Lote lote){
       return ResponseEntity.ok().body(service.cadastrarLote(lote));
    }
}

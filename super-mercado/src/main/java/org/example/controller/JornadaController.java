package org.example.controller;


import org.example.DTO.jornada.JornadaDTO;
import org.example.entity.Jornada;
import org.example.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jornada")
public class JornadaController {
    @Autowired
    JornadaService service;
    @PostMapping("/cadastrar")
    public ResponseEntity<Jornada> iniciandoJornadaTrabalho(@RequestBody JornadaDTO request)  {
        return ResponseEntity.ok().body(service.iniciarJornada(request));
    }
    @PutMapping("/atualizarJornada/{cpf}")
    public ResponseEntity<Jornada> finalizarJordanada(@RequestBody JornadaDTO request,@PathVariable String cpf) {
        return ResponseEntity.ok().body(service.finalizarJornada(request,cpf));
    }


}

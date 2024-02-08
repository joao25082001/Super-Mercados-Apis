package org.example.controller;

import org.example.DTO.FuncionarioDTO;
import org.example.DTO.cliente.ClienteDTO;
import org.example.DTO.cliente.RequestAtualizacao;
import org.example.entity.Funcionario;
import org.example.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService service;
    @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> iniciandoJornadaTrabalho(@RequestBody FuncionarioDTO request) throws IOException {
        return ResponseEntity.ok().body(service.cadastrarFuncionario(request));
    }
    @GetMapping("/exibir")
    public ResponseEntity<List<FuncionarioDTO>> exibirUsuario() {
        return ResponseEntity.ok().body(service.exibirUsuario());
    }
    @DeleteMapping("/deletar/{cpf}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable String cpf) {
        service.deletaFuncionario(cpf);
        return ResponseEntity.ok().build();
    }
}

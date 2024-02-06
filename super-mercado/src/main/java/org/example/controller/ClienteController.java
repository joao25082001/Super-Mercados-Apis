package org.example.controller;

import org.example.DTO.Cliente.ClienteDTO;
import org.example.DTO.Cliente.RequestAtualizacao;
import org.example.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO request) {
        return ResponseEntity.ok().body(clienteService.cadastroCliente(request.getNome(), request.getDataNascimento(), request.getCpf(), request.getCep()));
    }

    @GetMapping("/exibir")
    public ResponseEntity<List<ClienteDTO>> exibirUsuarios() {
        return ResponseEntity.ok().body(clienteService.exibirUsuario());
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<RequestAtualizacao> atualizar(@PathVariable Long id,@RequestBody RequestAtualizacao request ) {
        return ResponseEntity.ok().body(clienteService.atualizarUsuario(id,request));
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        clienteService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}

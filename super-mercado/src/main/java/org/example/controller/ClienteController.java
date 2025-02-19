package org.example.controller;

import org.example.DTO.cliente.ClienteDTO;
import org.example.DTO.cliente.RequestAtualizacao;
import org.example.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody @Validated ClienteDTO request) throws IOException {
        return ResponseEntity.ok().body(clienteService.cadastroCliente(request.getNome(), request.getDataNascimento(), request.getCpf(), request.getCep()));
    }

    @GetMapping("/exibir")
    public ResponseEntity<List<ClienteDTO>> exibirUsuarios() {
        return ResponseEntity.ok().body(clienteService.exibirUsuario());
    }

    @GetMapping("/relatorioVendas")
    public ResponseEntity<?> relatorio(@RequestParam String cpf) {
        return ResponseEntity.ok().body(clienteService.exibirRelatorio(cpf));
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<RequestAtualizacao> atualizar(@PathVariable Long id,@RequestBody RequestAtualizacao request ) {
        return ResponseEntity.ok().body(clienteService.atualizarUsuario(id,request));
    }
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        clienteService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}

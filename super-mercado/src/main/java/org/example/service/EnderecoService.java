package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Cliente;
import org.example.entity.Endereco;
import org.example.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    private ObjectMapper objectMapper;

    public EnderecoService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public void ObtendoInformacoesEndereco(String cep, Cliente id) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String linha = "";
        Endereco.EnderecoBuild endereco = new Endereco.EnderecoBuild();
        StringBuilder json = new StringBuilder();
        while ((linha = br.readLine()) != null) {
            json.append(linha);
        }
        Endereco salvandoEndereco = objectMapper.readValue(json.toString(), Endereco.class);
        salvandoEndereco.setIdCliente(id);
        CadastraEndereco(salvandoEndereco);
    }

    private void CadastraEndereco(Endereco endereco) {
        repository.save(endereco);
    }
}

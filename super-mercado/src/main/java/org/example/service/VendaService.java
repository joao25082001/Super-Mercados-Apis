package org.example.service;

import org.example.DTO.produto.ProdutoBaixoEstoque;
import org.example.DTO.venda.RelatorioMes;
import org.example.DTO.venda.RelatorioVenda;
import org.example.DTO.venda.VendaDTO;
import org.example.entity.Cliente;
import org.example.entity.Email;
import org.example.entity.Jornada;
import org.example.entity.Venda;
import org.example.enums.EnvioEmail;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.projection.ProjectionQuantidadeTotalMes;
import org.example.projection.ProjectionRelatorioMes;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    VendaRepository repository;
    @Autowired
    ClienteService serviceCliente;
    @Autowired
    JornadaService jornadaService;
    public Venda verificaVendaExiste(Long id) {
        Integer nmrVendas = repository.contaVendas(id);
        if(nmrVendas > 1){
            throw  new ExceptionConflict("mais de uma venda para o mesmo cliente, inicie outra venda");
        }
        Optional<Venda> venda = repository.findById(id);
        if(venda.isPresent()){
            return venda.get();
        }
        throw new ExceptioNoContent("Venda nao existe");
    }

    public VendaDTO cadastraVenda(VendaDTO request) throws IOException{
        Cliente cliente = serviceCliente.buscaClienteByCpf(request.getCliente().getCpf());
        Jornada jornada = jornadaService.buscaJornadaByCaixa(request.getCaixa());
        if(cliente== null){
            serviceCliente.cadastroClienteSemCep(request.getCliente());
        }
        if(jornada == null){
           throw new ExceptionConflict("Jornada de trabalho nao encontrada");
        }
        cliente = serviceCliente.buscaClienteByCpf(request.getCliente().getCpf());
        Venda venda = new Venda(request.getDataHora(),cliente,jornada);
        repository.save(venda);
        return request;
    }

    public RelatorioVenda buscaRelatorio(String mesAno) {
        String data = mesAno; // Sua data no formato MM/AA
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        TemporalAccessor temporalAccessor = formatter.parse(data);

        YearMonth year = YearMonth.from(temporalAccessor);
        int mes = year.getMonthValue();
        int ano = year.getYear();
        ProjectionQuantidadeTotalMes total = repository.buscaTotalVenda(mes,ano);
        List<ProjectionRelatorioMes> relatorioMes = repository.buscaInfoRelatorio(mes,ano);
         List<RelatorioMes> relatorioMesList = relatorioMes.stream()
                .map(relatorio ->
                        new RelatorioMes(relatorio.getCpf(),relatorio.getCodigo(),relatorio.getCompraDia(), relatorio.getDataHora()))
                .collect(Collectors.toList());
        return  new RelatorioVenda(relatorioMesList,total.getTotal());

    }

    @Transactional
    public void sendEmail(List<ProdutoBaixoEstoque> produtos, String emailSupermercado) {
        Email emailModel = new Email();

        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("servicosvitae@gmail.com");
            message.setTo(emailSupermercado);
            message.setSubject("Produtos com baixa demanda");
            message.setText(produtos.toString());
            System.out.println(emailModel);
            emailSender.send(message);
            emailModel.setStatusEmail(EnvioEmail.ENVIADO);
        } catch (MailException e){
            System.out.println("erro é " + e);
            emailModel.setStatusEmail(EnvioEmail.ERROR);
        }
    }
}

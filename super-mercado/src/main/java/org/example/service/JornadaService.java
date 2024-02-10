package org.example.service;


import org.example.DTO.jornada.JornadaDTO;
import org.example.entity.Caixa;
import org.example.entity.Funcionario;
import org.example.entity.Jornada;
import org.example.exception.ExceptionConflict;
import org.example.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadaService {
    @Autowired
    CaixaService caixaService;
    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    JornadaRepository repository;
    public Jornada iniciarJornada(JornadaDTO request) {
        Caixa caixa = caixaService.buscarCaixaByNumero(request.getCaixa());
        Funcionario funcionario = funcionarioService.buscarFuncionarioById(request.getCpfFuncionario());
        if (!caixa.getStatus()){
            throw new ExceptionConflict("Não é possivel iniciar uma jornada de trabalho com o caixa fechado");
        }
       Jornada permissaoAbertura = repository.findByCaixa(caixa);
        if(permissaoAbertura != null && permissaoAbertura.getHorarioFechamento() == null){
            throw new ExceptionConflict("Não é possivel iniciar uma jornada de trabalho sem terminar a anterior");
        }
        Jornada jornada = new Jornada(request.getHorarioAbertura(),request.getValorInicial(),caixa,funcionario);
        repository.save(jornada);
        return jornada;

    }

    public Jornada finalizarJornada(JornadaDTO request,String cpf) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioById(cpf);
        Jornada jornada = repository.getByFuncionarioId(funcionario.getId());
        jornada.setHorarioFechamento(request.getHorarioFechamento());
        jornada.setValorFinal(request.getValorFinal());
        repository.save(jornada);
        return jornada;
    }

    public Jornada buscaJornadaByCaixa(Integer caixa) {
        Caixa caixa1 = caixaService.buscarCaixaByNumero(caixa);
        if(!caixa1.getStatus()){
            throw new ExceptionConflict("O caixa se enconta fechado, sem jornada no momento");
        }
       return repository.findTop1ByCaixaOrderByIdDesc(caixa1);
    }
}

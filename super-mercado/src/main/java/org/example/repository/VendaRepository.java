package org.example.repository;

import org.example.entity.Venda;
import org.example.projection.ProjectionQuantidadeTotalMes;
import org.example.projection.ProjectionRelatorioMes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.temporal.TemporalAccessor;
import java.util.List;

@Repository
public interface VendaRepository  extends JpaRepository<Venda,Long> {
    @Query("select count(v.id) from Venda v where id = :id")
    Integer contaVendas(Long id);
    @Query(nativeQuery = true,value = "select count(i.id_venda) as total from item_venda i join venda v on i.id_venda = v.id_venda WHERE MONTH(v.data_hora) = :mes \n" +
            "AND YEAR(v.data_hora) = :ano ")
    ProjectionQuantidadeTotalMes buscaTotalVenda(int mes, int ano);
    @Query(nativeQuery = true,value = " select  cliente.cpf,p.codigo,v.data_hora as dataHora, count(*) as compradia from endereco e join  cliente cliente on e.id_cliente = cliente.id_cliente join \n" +
            "venda v on cliente.id_cliente = v.id_cliente join\n" +
            " item_venda i on i.id_venda = v.id_venda join\n" +
            " controle_produto controle on controle.id_controle_produto = i.id_controle_produto join\n" +
            " produto p on controle.id_produto = p.id_produto WHERE MONTH(v.data_hora) = :mes \n" +
            "AND YEAR(v.data_hora) = :ano \n" +
            "group by  cliente.id_cliente, e.id_endereco,p.codigo, p.nome,v.data_hora")
    List<ProjectionRelatorioMes> buscaInfoRelatorio(int mes, int ano);
}

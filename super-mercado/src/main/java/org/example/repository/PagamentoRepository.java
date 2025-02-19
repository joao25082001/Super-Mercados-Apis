package org.example.repository;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.example.entity.Pagamento;
import org.example.entity.Venda;
import org.example.projection.RecuperaProdutosVenda;
import org.example.projection.VerificaValorTotalPagamentoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento,Long> {

    @Query(nativeQuery = true, value = "select sum(p.valor) as valor from produto p join controle_produto c on p.id_produto = c.id_produto join item_venda v on v.id_controle_produto = c.id_controle_produto join venda  on v.id_venda = venda.id_venda where v.id_venda =:id")
    VerificaValorTotalPagamentoProjection verificaValorTotalPagamento(Long id);
    @Query(nativeQuery = true, value = "select codigo  from produto p join controle_produto c on p.id_produto = c.id_produto join item_venda v on v.id_controle_produto = c.id_controle_produto join venda  on v.id_venda = venda.id_venda where v.id_venda =:id")
    List<RecuperaProdutosVenda> recuperaCodigos(Long id);

    Optional<Pagamento> findByVenda(Venda venda);
    @Query(nativeQuery = true, value = "select codigo  from produto p join controle_produto c on p.id_produto = c.id_produto join item_venda v on v.id_controle_produto = c.id_controle_produto join venda  on v.id_venda = venda.id_venda where v.id_venda =:id group by codigo")
    List<RecuperaProdutosVenda> recuperaCodigosAgrupados(Long id);
}

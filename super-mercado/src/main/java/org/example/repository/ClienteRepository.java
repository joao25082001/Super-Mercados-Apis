package org.example.repository;

import org.example.entity.Cliente;
import org.example.projection.ProjectionRelatorioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByCpf(String cpf);
    @Query(value = "select  cliente.*,e.*,p.codigo,p.nome as produtoNome,v.data_hora as dataHora, count(*) as compraDia  from endereco e join  cliente cliente on e.id_cliente = cliente.id_cliente join \n" +
            "venda v on cliente.id_cliente = v.id_cliente join\n" +
            " item_venda i on i.id_venda = v.id_venda join\n" +
            " controle_produto controle on controle.id_controle_produto = i.id_controle_produto join\n" +
            " produto p on controle.id_produto = p.id_produto \n" +
            " where cliente.cpf = :cpf group by  cliente.id_cliente, e.id_endereco,p.codigo, p.nome,v.data_hora",nativeQuery = true)
    List<ProjectionRelatorioCliente> buscaInfoRelatorioCliente(String cpf);
}

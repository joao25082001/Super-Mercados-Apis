package org.example.repository;

import org.example.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository  extends JpaRepository<Venda,Long> {
    @Query("select count(v.id) from Venda v where id = :id")
    Integer contaVendas(Long id);
}

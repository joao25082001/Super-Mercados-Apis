package org.example.repository;

import org.example.entity.ItemVenda;
import org.example.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository  extends JpaRepository<ItemVenda,Long> {
    void deleteAllByVenda(Venda venda);
}

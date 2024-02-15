package org.example.repository;

import org.example.entity.ItemVenda;
import org.example.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemVendaRepository  extends JpaRepository<ItemVenda,Long> {



    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "delete from  item_venda where id_venda = :id")
    void deleteAllByVenda(Long id);
}

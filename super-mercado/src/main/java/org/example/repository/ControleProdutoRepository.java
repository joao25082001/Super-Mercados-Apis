package org.example.repository;


import org.example.entity.ControleProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleProdutoRepository extends JpaRepository<ControleProduto,Long> {
}

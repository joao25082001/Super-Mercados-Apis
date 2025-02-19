package org.example.repository;

import org.example.entity.SuperMercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMercadoRepository  extends JpaRepository<SuperMercado,Long> {
}

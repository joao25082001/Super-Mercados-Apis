package org.example.repository;

import org.example.entity.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository  extends JpaRepository<Lote,Long> {
}

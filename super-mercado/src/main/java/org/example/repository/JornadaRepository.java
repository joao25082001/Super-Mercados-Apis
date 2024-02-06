package org.example.repository;

import org.example.entity.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository  extends JpaRepository<Jornada,Long> {
}

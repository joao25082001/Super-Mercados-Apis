package org.example.repository;

import org.example.entity.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa,Long> {
    Optional<Caixa> findByNumero(Integer numero);
}

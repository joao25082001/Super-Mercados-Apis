package org.example.repository;

import org.example.entity.Caixa;
import org.example.entity.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository  extends JpaRepository<Jornada,Long> {

    Jornada getByFuncionarioId(Long id);


    Jornada findByCaixa(Caixa caixa1);

    Jornada findTop1ByCaixaOrderByIdDesc(Caixa caixa1);
}

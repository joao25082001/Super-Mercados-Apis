package org.example.repository;

import org.example.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario,Long> {
    Optional<Funcionario> findByCpf(String id);

    void deleteByCpf(String cpf);
}

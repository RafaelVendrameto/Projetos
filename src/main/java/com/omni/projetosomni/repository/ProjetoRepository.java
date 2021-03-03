package com.omni.projetosomni.repository;

import com.omni.projetosomni.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    Optional<Projeto> findByNomeProjeto(String nome);
}

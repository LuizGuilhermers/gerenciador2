package com.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}

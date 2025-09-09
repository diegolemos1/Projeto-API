
package com.meuprojeto.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meuprojeto.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

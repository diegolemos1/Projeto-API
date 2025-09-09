
package com.meuprojeto.tarefas.controller;

import com.meuprojeto.tarefas.model.Tarefa;
import com.meuprojeto.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setNome(novaTarefa.getNome());
            tarefa.setDataEntrega(novaTarefa.getDataEntrega());
            tarefa.setResponsavel(novaTarefa.getResponsavel());
            return repository.save(tarefa);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void removerTarefa(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

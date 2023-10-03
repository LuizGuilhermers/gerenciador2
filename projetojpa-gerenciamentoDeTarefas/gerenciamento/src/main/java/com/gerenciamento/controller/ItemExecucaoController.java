package com.gerenciamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerenciamento.entities.ItemExecucao;
import com.gerenciamento.entities.Tarefa;
import com.gerenciamento.service.ItemExecucaoService;

public class ItemExecucaoController {
	
	
	private ItemExecucaoService itemExecucaoService;

	@Autowired
	public ItemExecucaoController (ItemExecucaoService itemExecucaoService) {
		this.itemExecucaoService = itemExecucaoService;
	}
	
    @PostMapping("/")
    public ResponseEntity<ItemExecucao> criarItemExecucao(@RequestBody ItemExecucao itemExecucao) {
        ItemExecucao criarItemExecucao = itemExecucaoService.saveItemExecucao(itemExecucao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarItemExecucao);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ItemExecucao> updateItemExecucao(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao) {
		ItemExecucao updatedItemExecucao = itemExecucaoService.updateItemExecucao(id, itemExecucao);
        if (updatedItemExecucao != null) {
            return ResponseEntity.ok(updatedItemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        boolean deleted = itemExecucaoService.deleteItemExecucao(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("A tarefa foi excluída com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.gerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.entities.ItemExecucao;
import com.gerenciamento.repository.ItemExecucaoRepository;
import com.gerenciamento.repository.TarefaRepository;

@Service
public class ItemExecucaoService {

	private ItemExecucaoRepository itemExecucaoRepository;
	
	@Autowired
	public ItemExecucaoService (ItemExecucaoRepository itemExecucaoRepository) {
		this.itemExecucaoRepository = itemExecucaoRepository;
	}
	
	public ItemExecucao saveItemExecucao (ItemExecucao itemExecucao) {
		return itemExecucaoRepository.save(itemExecucao);
	}
	
	public ItemExecucao getItemExecucaoById (Long id) {
		return itemExecucaoRepository.findById(id).orElse(null);
	}
	public List<ItemExecucao> getAllItemExecucao(){
		return itemExecucaoRepository.findAll();
	}
	public ItemExecucao updateItemExecucao(Long id, ItemExecucao updatedItemExecucao) {
		Optional<ItemExecucao> existingItemExecucao = itemExecucaoRepository.findById(id);

		if (existingItemExecucao.isPresent()) {
			updatedItemExecucao.setId(id);
			return itemExecucaoRepository.save(updatedItemExecucao);
		}
		return null;
	}

		public boolean deleteItemExecucao(Long id) {
			Optional <ItemExecucao> existingItemExecucao = itemExecucaoRepository.findById(id);
			if (existingItemExecucao.isPresent()) {
				itemExecucaoRepository.deleteById(id);
				return true;
			}
			return false;

		}


}

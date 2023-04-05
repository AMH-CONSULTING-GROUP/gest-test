package com.fth.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.CategorieProduit;
import com.fth.stock.repository.CategorieProduitRepository;

@Service
public class CategorieProduitService {
	@Autowired
	private CategorieProduitRepository categorieProduitRepository;
	
	public void addCategorie(CategorieProduit categorie) {
		categorieProduitRepository.save(categorie);
	}

	public List<CategorieProduit> getAll() {
		return categorieProduitRepository.getAllCategories();
	}
}

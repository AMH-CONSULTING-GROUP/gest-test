package com.fth.stock.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.Produit;
import com.fth.stock.repository.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository repository;

	public List<Produit> getAllProduits() {
		return repository.getAllProduits();
	}

	public List<Produit> findTop5ByOrderByCreateAtDesc() {
		return repository.findTop5ByOrderByCreateAtDesc();
	}

	public void saveProduit(Produit produit) {
		repository.save(produit);
	}

	public Produit getById(long id) {
		return repository.getById(id);
	}

	@Transactional
	public void deleteProduct(long id) {
		repository.disableProduit(id);
	}

	public int countProduit() {
		return repository.countProduit();
	}

	public List<Produit> getExpiredProduits() {
		return repository.getProduitByDate(LocalDate.now());
	}
}

package com.fth.stock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.MouvementProduit;
import com.fth.stock.entity.Produit;
import com.fth.stock.repository.MouvementProduitRepository;
import com.fth.stock.repository.ProduitRepository;

@Service
public class MouvementProduitService {
	@Autowired
	private MouvementProduitRepository repository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private UserService userService;

	public List<MouvementProduit> getAllMouvementProduit() {
		return repository.getAll();
	}

	public List<MouvementProduit> getAllProduitEntree() {
		return repository.getByType("Entree");
	}

	public List<MouvementProduit> getAllProduitSortie() {
		return repository.getByType("Sortie");
	}

	@Transactional
	public void saveProduitEntree(long produitId, String type, long quantite) {
		Produit produit = produitRepository.getById(produitId);
		produit.setQuantite(produit.getQuantite() + quantite);
		produitRepository.save(produit);

		MouvementProduit mProduit = new MouvementProduit(type, produitRepository.getById(produitId),
				userService.getConnectedUser(), quantite);
		repository.save(mProduit);
	}

	@Transactional
	public void saveProduitSortie(long produitId, String type, long quantite) {
		Produit produit = produitRepository.getById(produitId);
		produit.setQuantite(produit.getQuantite() - quantite);
		produitRepository.save(produit);

		MouvementProduit mProduit = new MouvementProduit(type, produitRepository.getById(produitId),
				userService.getConnectedUser(), quantite);
		repository.save(mProduit);
	}
}

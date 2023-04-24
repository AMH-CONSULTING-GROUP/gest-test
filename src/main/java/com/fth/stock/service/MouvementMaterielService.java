package com.fth.stock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.Materiel;
import com.fth.stock.entity.MouvementMateriel;
import com.fth.stock.repository.MaterielRepository;
import com.fth.stock.repository.MouvementMaterielRepository;

@Service
public class MouvementMaterielService {
	@Autowired
	private MouvementMaterielRepository repository;
	@Autowired
	private MaterielRepository materielRepository;
	@Autowired
	private UserService userService;

	public List<MouvementMateriel> getAllMouvementMateriel() {
		return repository.getAll();
	}

	public List<MouvementMateriel> getAllMaterielEntree() {
		return repository.getByType("Entree");
	}

	public List<MouvementMateriel> getAllMaterielSortie() {
		return repository.getByType("Sortie");
	}

	@Transactional
	public void saveMaterielEntree(long materielId, String type, long quantite) {
		Materiel materiel = materielRepository.getById(materielId);
		materiel.setQuantite(materiel.getQuantite() + quantite);
		materielRepository.save(materiel);

		MouvementMateriel mMateriel = new MouvementMateriel(type, materielRepository.getById(materielId),
				userService.getConnectedUser(), quantite);
		repository.save(mMateriel);
	}

	@Transactional
	public void saveMaterielSortie(long materielId, String type, long quantite) {
		Materiel materiel = materielRepository.getById(materielId);
		materiel.setQuantite(materiel.getQuantite() - quantite);
		materielRepository.save(materiel);

		MouvementMateriel mMateriel = new MouvementMateriel(type, materielRepository.getById(materielId),
				userService.getConnectedUser(), quantite);
		repository.save(mMateriel);
	}

	public void rendreProduit(long id) {
		MouvementMateriel mvMateriel = repository.findById(id).get();
		Materiel materiel = mvMateriel.getMateriel();
		materiel.setQuantite(materiel.getQuantite() + mvMateriel.getQuantite());
		mvMateriel.setReturned(true);

		materielRepository.save(materiel);
		repository.save(mvMateriel);
	}
}

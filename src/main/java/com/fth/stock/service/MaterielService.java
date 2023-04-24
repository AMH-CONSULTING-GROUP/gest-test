package com.fth.stock.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.Materiel;
import com.fth.stock.repository.MaterielRepository;

@Service
public class MaterielService {
	@Autowired
	private MaterielRepository repository;

	public List<Materiel> getAllMateriels() {
		return repository.getAllMateriels();
	}

	public List<Materiel> findTop5ByOrderByCreateAtDesc() {
		return repository.findTop5ByOrderByCreateAtDesc();
	}

	public void saveMateriel(Materiel Materiel) {
		repository.save(Materiel);
	}

	public Materiel getById(long id) {
		return repository.getById(id);
	}

	@Transactional
	public void deleteProduct(long id) {
		repository.disableMateriel(id);
	}

	public int countMateriel() {
		return repository.countMateriel();
	}

	public List<Materiel> getExpiredMateriels() {
		return repository.getMaterielByDate(LocalDate.now());
	}
}

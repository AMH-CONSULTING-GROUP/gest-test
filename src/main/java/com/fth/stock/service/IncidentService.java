package com.fth.stock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.Incident;
import com.fth.stock.entity.Materiel;
import com.fth.stock.entity.User;
import com.fth.stock.repository.IncidentRepository;
import com.fth.stock.repository.MaterielRepository;
import com.fth.stock.repository.UserRepository;

@Service
public class IncidentService {
	@Autowired
	private IncidentRepository repository;
	@Autowired
	private MaterielRepository materielRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Incident> getAllIncident() {
		return repository.getAll();
	}

	@Transactional
	public void saveIncident(long userId, long materielId, String type, long quantite, String description) {
		Materiel materiel = materielRepository.getById(materielId);
		User user = userRepository.findById(userId).get();
		materiel.setQuantite(materiel.getQuantite() - quantite);
		materielRepository.save(materiel);

		Incident incident = new Incident(type, description, quantite, materielRepository.getById(materielId), user);
		repository.save(incident);
	}

	public void delete(long id) {
		Incident incident = repository.findById(id).get();
		incident.setDeleted(true);
		repository.save(incident);
	}

	public int countIncident() {
		return repository.countIncident();
	}
}

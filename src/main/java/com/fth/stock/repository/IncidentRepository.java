package com.fth.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long> {

	@Query("SELECT ic FROM Incident ic where ic.deleted = false")
	public List<Incident> getAll();

//	@Query("SELECT ic FROM Incident ic where ic.type =:type")
//	public List<Incident> getByType(@Param("type") String type);

	@Query("SELECT ic FROM Incident ic where ic.user.id =:userId ")
	public List<Incident> getUserIncident(@Param("userId") long id);

	@Query("SELECT ic FROM Incident ic where ic.user.id =:incidentId ")
	public List<Incident> getMaterieltMouvement(@Param("incidentId") long id);

	@Query("SELECT count(ic.id) FROM Incident ic WHERE ic.deleted = false")
	public int countIncident();

}

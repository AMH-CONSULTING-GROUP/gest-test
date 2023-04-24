package com.fth.stock.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.Materiel;

public interface MaterielRepository extends CrudRepository<Materiel, Long> {

	@Query("SELECT m FROM Materiel m WHERE m.id = :id")
	public Materiel getById(@Param("id") long id);

	@Query("SELECT m FROM Materiel m WHERE m.deleted = false")
	public List<Materiel> getAllMateriels();

	public List<Materiel> findTop5ByOrderByCreateAtDesc();

	@Modifying
	@Query("UPDATE Materiel m set m.deleted = true where m.id =:id")
	public void disableMateriel(@Param("id") long id);

	@Query("SELECT count(m.id) FROM Materiel m WHERE m.deleted = false")
	public int countMateriel();

	@Query("SELECT m FROM Materiel m WHERE m.expireAt <:date")
	public List<Materiel> getMaterielByDate(@Param("date") LocalDate date);

}

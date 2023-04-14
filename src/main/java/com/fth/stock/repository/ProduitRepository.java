package com.fth.stock.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

	@Query("SELECT p FROM Produit p WHERE p.id = :id")
	public Produit getById(@Param("id") long id);

	@Query("SELECT p FROM Produit p WHERE p.deleted = false")
	public List<Produit> getAllProduits();
	
	public List<Produit> findTop5ByOrderByCreateAtDesc();

	@Modifying
	@Query("UPDATE Produit p set p.deleted = true where p.id =:id")
	public void disableProduit(@Param("id") long id);

	@Query("SELECT count(p.id) FROM Produit p WHERE p.deleted = false")
	public int countProduit();

	@Query("SELECT p FROM Produit p WHERE p.expireAt <:date")
	public List<Produit> getProduitByDate(@Param("date") LocalDate date);

}

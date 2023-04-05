package com.fth.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fth.stock.entity.CategorieProduit;

public interface CategorieProduitRepository extends CrudRepository<CategorieProduit, Long> {

	@Query("SELECT c FROM CategorieProduit c WHERE c.deleted = false")
	public List<CategorieProduit> getAllCategories();
}

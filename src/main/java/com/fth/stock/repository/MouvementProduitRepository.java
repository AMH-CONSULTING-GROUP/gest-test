package com.fth.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.MouvementProduit;

public interface MouvementProduitRepository extends CrudRepository<MouvementProduit, Long> {

	@Query("SELECT mp FROM MouvementProduit mp where mp.deleted = false")
	public List<MouvementProduit> getAll();

	@Query("SELECT mp FROM MouvementProduit mp where mp.type =:type")
	public List<MouvementProduit> getByType(@Param("type") String type);

	@Query("SELECT mp FROM MouvementProduit mp where mp.user.id =:userId ")
	public List<MouvementProduit> getUserMouvementProduit(@Param("userId") long id);

	@Query("SELECT mp FROM MouvementProduit mp where mp.id =:produitId ")
	public List<MouvementProduit> getProduitMouvement(@Param("produitId") long id);

}

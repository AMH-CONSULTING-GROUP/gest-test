package com.fth.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.MouvementMateriel;

public interface MouvementMaterielRepository extends CrudRepository<MouvementMateriel, Long> {

	@Query("SELECT mm FROM MouvementMateriel mm where mm.deleted = false")
	public List<MouvementMateriel> getAll();

	@Query("SELECT mm FROM MouvementMateriel mm where mm.type =:type")
	public List<MouvementMateriel> getByType(@Param("type") String type);

	@Query("SELECT mm FROM MouvementMateriel mm where mm.user.id =:userId ")
	public List<MouvementMateriel> getUserMouvementMateriel(@Param("userId") long id);

	@Query("SELECT mm FROM MouvementMateriel mm where mm.user.id =:materielId ")
	public List<MouvementMateriel> getMaterieltMouvement(@Param("materielId") long id);

}

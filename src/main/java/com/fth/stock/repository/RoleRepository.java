package com.fth.stock.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query("SELECT r FROM Role r")
	public List<Role> getAllRoles();

	@Query("SELECT r FROM Role r where r.name=:name")
	public Role getRoleByName(@Param("name") String name);

	@Query("SELECT r FROM Role r where r.id=:id")
	public Optional<Role> getRoleById(@Param("id") int id);

}

package com.fth.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fth.stock.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);

	@Query("SELECT u FROM User u where u.enabled = true")
	public List<User> getAllUsers();

	@Modifying
	@Query("UPDATE User u set u.enabled = false where u.id =:id")
	public void disableUser(@Param("id") long id);

}

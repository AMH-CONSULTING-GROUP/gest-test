package com.fth.stock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.User;
import com.fth.stock.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> getAllUsers() {
		return repository.getAllUsers();
	}

	public void saveUser(User user) {
		repository.save(user);
	}

	@Transactional
	public void deleteUser(long id) {
		repository.disableUser(id);
	}

	public User getConnectedUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		User user = repository.getUserByUsername(username);

		return user;

	}
}

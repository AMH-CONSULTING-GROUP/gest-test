package com.fth.stock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
}

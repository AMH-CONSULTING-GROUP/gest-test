package com.fth.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fth.stock.entity.Role;
import com.fth.stock.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;

	public List<Role> getAllRoles() {
		return repository.getAllRoles();
	}

	public Role getRoleByName(String name) {
		return repository.getRoleByName(name);
	}

	public Role getRoleById(int id) {
		Role role = this.getRoleByName("USER");
		return repository.getRoleById(id).orElse(role);
	}
}

package com.fth.stock.controller.view;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fth.stock.dto.UserDto;
import com.fth.stock.entity.Role;
import com.fth.stock.entity.User;
import com.fth.stock.service.RoleService;
import com.fth.stock.service.UserService;

@Controller
public class UtilisateurController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
//	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

//	@GetMapping("/view/utilisateur/add")
//	public String viewCategorieAdd(Model model) {
//		CategorieProduit categorie = new CategorieProduit();
//		model.addAttribute("utilisateur", categorie);
//		return "categorie/categorieProduitAdd";
//	}
//
	@PostMapping("utilisateur/add")
	public String utilisateurAdd(Model model, @ModelAttribute("user") UserDto userDto) {
		String encodedPassword = passwordEncoder.encode(userDto.getPassword());
		Role role = roleService.getRoleById(userDto.getRoleId());
		User user = new User(userDto.getUsername(), encodedPassword, userDto.getFullName(), userDto.getTelephone());
		user.setRoles(Set.of(role));
		userService.saveUser(user);

		return "redirect:/utilisateur/list";
	}

	@RequestMapping("utilisateur/delete/{id}")
	public String utilisateurDelete(@PathVariable long id) {
		userService.deleteUser(id);
		return "redirect:/utilisateur/list";
	}

	@RequestMapping("/utilisateur/list")
	public String viewUtilisateurList(Model model) {
		List<User> liste = userService.getAllUsers();
		List<Role> listeRoles = roleService.getAllRoles();
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		model.addAttribute("listeUtil", liste);
		model.addAttribute("listeRoles", listeRoles);
		model.addAttribute("link", "utilisateur");
		return "utilisateur/utilisateur";
	}

}

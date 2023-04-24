package com.fth.stock.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fth.stock.dto.MouvementMaterielDto;
import com.fth.stock.entity.Materiel;
import com.fth.stock.entity.MouvementMateriel;
import com.fth.stock.entity.User;
import com.fth.stock.service.MaterielService;
import com.fth.stock.service.MouvementMaterielService;
import com.fth.stock.service.UserService;

@Controller
public class MouvementMaterielController {

	@Autowired
	private MouvementMaterielService mouvementMaterielService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private UserService userService;

	@PostMapping("stock/materiel/entree")
	public String stockEntree(Model model, @ModelAttribute("dto") MouvementMaterielDto dto) {

		mouvementMaterielService.saveMaterielEntree(dto.getMaterielId(), "Entree", dto.getQuantite());

		return "redirect:/stock/materiel/historique-entree";
	}

	@PostMapping("stock/materiel/sortie")
	public String materielAdd(Model model, @ModelAttribute("dto") MouvementMaterielDto dto) {

		mouvementMaterielService.saveMaterielSortie(dto.getMaterielId(), "Sortie", dto.getQuantite());

		return "redirect:/stock/materiel/historique-sortie";
	}

	@RequestMapping("/stock/materiel/historique-entree")
	public String viewMouvementMaterielEntree(Model model) {
		List<MouvementMateriel> liste = mouvementMaterielService.getAllMaterielEntree();
		List<User> users = userService.getAllUsers();
		List<Materiel> materiels = materielService.getAllMateriels();
		MouvementMaterielDto dto = new MouvementMaterielDto();

		model.addAttribute("dto", dto);
		model.addAttribute("mMateriels", liste);
		model.addAttribute("users", users);
		model.addAttribute("materiels", materiels);
		model.addAttribute("link", "mv-materiel-entree");
		return "materiel/stock-historique-entree";
	}

	@RequestMapping("/stock/materiel/historique-sortie")
	public String viewMouvementMaterielSortie(Model model) {
		List<MouvementMateriel> liste = mouvementMaterielService.getAllMaterielSortie();
		List<User> users = userService.getAllUsers();
		List<Materiel> materiels = materielService.getAllMateriels();
		MouvementMaterielDto dto = new MouvementMaterielDto();

		model.addAttribute("dto", dto);
		model.addAttribute("mMateriels", liste);
		model.addAttribute("users", users);
		model.addAttribute("materiels", materiels);
		model.addAttribute("link", "mv-materiel-sortie");
		return "materiel/stock-historique-sortie";
	}

	@RequestMapping("materiel/rendre/{id}")
	public String rendreProduit(@PathVariable long id) {
		mouvementMaterielService.rendreProduit(id);
		return "redirect:/stock/materiel/historique-sortie";
	}

}

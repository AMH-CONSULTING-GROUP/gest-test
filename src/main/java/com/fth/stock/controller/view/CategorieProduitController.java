package com.fth.stock.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fth.stock.entity.CategorieProduit;
import com.fth.stock.service.CategorieProduitService;

@Controller
public class CategorieProduitController {

	@Autowired
	CategorieProduitService categorieProduitService;

	@GetMapping("/view/categorieProduit/add")
	public String viewCategorieAdd(Model model) {
		CategorieProduit categorie = new CategorieProduit();
		model.addAttribute("categorie", categorie);
		model.addAttribute("link", "produit-cat");
		return "categorie/categorieProduitAdd";
	}

	@PostMapping("categorieProduit/add")
	public String CategorieAdd(Model model, @ModelAttribute("categorie") CategorieProduit categorieProduit) {
		categorieProduitService.addCategorie(categorieProduit);
		return "redirect:/categorieProduit/list";
	}

	@RequestMapping("/categorieProduit/list")
	public String viewCategorieProduitList(Model model) {
		List<CategorieProduit> liste = categorieProduitService.getAll();
		model.addAttribute("listeCat", liste);
		model.addAttribute("link", "produit-cat");
		return "categorie/categorieProduit";
	}

}

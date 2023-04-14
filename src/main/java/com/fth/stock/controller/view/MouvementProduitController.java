package com.fth.stock.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fth.stock.dto.MouvementProduitDto;
import com.fth.stock.entity.MouvementProduit;
import com.fth.stock.entity.Produit;
import com.fth.stock.entity.User;
import com.fth.stock.service.MouvementProduitService;
import com.fth.stock.service.ProduitService;
import com.fth.stock.service.UserService;

@Controller
public class MouvementProduitController {

	@Autowired
	private MouvementProduitService mouvementProduitService;
	@Autowired
	private ProduitService produitService;
	@Autowired
	private UserService userService;

	@PostMapping("stock/produit/entree")
	public String stockEntree(Model model, @ModelAttribute("dto") MouvementProduitDto dto) {

		mouvementProduitService.saveProduitEntree(dto.getProduitId(), "Entree", dto.getQuantite());

		return "redirect:/stock/produit/historique-entree";
	}

	@PostMapping("stock/produit/sortie")
	public String produitAdd(Model model, @ModelAttribute("dto") MouvementProduitDto dto) {

		mouvementProduitService.saveProduitSortie(dto.getProduitId(), "Sortie", dto.getQuantite());

		return "redirect:/stock/produit/historique-sortie";
	}

	@RequestMapping("/stock/produit/historique-entree")
	public String viewMouvementProduitEntree(Model model) {
		List<MouvementProduit> liste = mouvementProduitService.getAllProduitEntree();
		List<User> users = userService.getAllUsers();
		List<Produit> produits = produitService.getAllProduits();
		MouvementProduitDto dto = new MouvementProduitDto();

		model.addAttribute("dto", dto);
		model.addAttribute("mProduits", liste);
		model.addAttribute("users", users);
		model.addAttribute("produits", produits);
		return "produit/stock-historique-entree";
	}

	@RequestMapping("/stock/produit/historique-sortie")
	public String viewMouvementProduitSortie(Model model) {
		List<MouvementProduit> liste = mouvementProduitService.getAllProduitSortie();
		List<User> users = userService.getAllUsers();
		List<Produit> produits = produitService.getAllProduits();
		MouvementProduitDto dto = new MouvementProduitDto();

		model.addAttribute("dto", dto);
		model.addAttribute("mProduits", liste);
		model.addAttribute("users", users);
		model.addAttribute("produits", produits);
		return "produit/stock-historique-sortie";
	}

}

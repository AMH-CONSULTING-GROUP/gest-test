package com.fth.stock.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fth.stock.entity.MouvementProduit;
import com.fth.stock.entity.Produit;
import com.fth.stock.service.IncidentService;
import com.fth.stock.service.MaterielService;
import com.fth.stock.service.MouvementProduitService;
import com.fth.stock.service.ProduitService;

@Controller
public class AuthentificationController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private IncidentService incidentService;
	@Autowired
	private MouvementProduitService mouvementProduitService;

	@GetMapping("/")
	public String log(Model model) {
		int nbreProduit = produitService.countProduit();
		int nbreMateriel = materielService.countMateriel();
		int nbreIncident = incidentService.countIncident();
		List<Produit> expiredP = produitService.getExpiredProduits();
		List<Produit> lastP = produitService.findTop5ByOrderByCreateAtDesc();
		List<MouvementProduit> mProduits = mouvementProduitService.getAllMouvementProduit();

		model.addAttribute("nbreProduit", nbreProduit);
		model.addAttribute("nbreMateriel", nbreMateriel);
		model.addAttribute("nbreIncident", nbreIncident);
		model.addAttribute("expiredP", expiredP);
		model.addAttribute("lastP", lastP);
		model.addAttribute("mProduits", mProduits);
		model.addAttribute("link", "dashboard");
		return "index";
	}

	@GetMapping("/css2")
	public String css2() {
		return "redirect:/";
	}

	@GetMapping("/index")
	public String home() {

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	@GetMapping("/errorPage")
	public String errorPage() {
		return "error";
	}

}

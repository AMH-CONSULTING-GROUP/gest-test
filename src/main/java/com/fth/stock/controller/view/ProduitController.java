package com.fth.stock.controller.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fth.stock.dto.ProduitDto;
import com.fth.stock.entity.CategorieProduit;
import com.fth.stock.entity.Produit;
import com.fth.stock.entity.User;
import com.fth.stock.service.CategorieProduitService;
import com.fth.stock.service.ProduitService;
import com.fth.stock.service.UserService;

@Controller
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategorieProduitService categorieProduitService;
	@Autowired
	private UserService userService;
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\static\\img\\uploads";

	@PostMapping("produit/add")
	public String produitAdd(Model model, @ModelAttribute("produit") ProduitDto produitDto,
			@RequestParam("image") MultipartFile file) throws IOException {

		User user = userService.getConnectedUser();

		String fileName = "";
		if (file.getOriginalFilename().isBlank() || file.getOriginalFilename().isEmpty()) {
			fileName = "img1.png";
		} else {
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			Files.write(fileNameAndPath, file.getBytes());
			fileName = file.getOriginalFilename();
		}

		LocalDate expireAt = LocalDate.now();
		if (produitDto.getExpireAt().isBlank() || produitDto.getExpireAt().isEmpty()
				|| produitDto.getExpireAt() == null) {
			expireAt = null;
		} else {
			expireAt = LocalDate.parse(produitDto.getExpireAt());
		}

		Produit produit = new Produit(produitDto.getName(), produitDto.getDescription(), fileName,
				produitDto.getQuantite(), produitDto.getMinQuantite(), produitDto.getType(), produitDto.isInflammable(),
				expireAt, produitDto.getUnite(), user);

		produitService.saveProduit(produit);

		return "redirect:/produit/list";
	}

	@RequestMapping("produit/delete/{id}")
	public String produitDelete(@PathVariable long id) {
		produitService.deleteProduct(id);
		return "redirect:/produit/list";
	}

	@RequestMapping("/produit/list")
	public String viewProduitList(Model model) {
		List<Produit> liste = produitService.getAllProduits();
		List<CategorieProduit> categories = categorieProduitService.getAll();
		ProduitDto produit = new ProduitDto();
		model.addAttribute("produit", produit);
		model.addAttribute("produitList", liste);
		model.addAttribute("categories", categories);
		return "produit/list";
	}

	@RequestMapping("/produit/details/{id}")
	public String viewProduitDetails(Model model, @PathVariable long id) {
		Produit produit = produitService.getById(id);
		model.addAttribute("produit", produit);
		return "produit/details";
	}

}

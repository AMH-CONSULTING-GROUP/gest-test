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

import com.fth.stock.dto.MaterielDto;
import com.fth.stock.entity.Materiel;
import com.fth.stock.entity.User;
import com.fth.stock.service.MaterielService;
import com.fth.stock.service.UserService;

@Controller
public class MaterielController {

	@Autowired
	private MaterielService materielService;
	@Autowired
	private UserService userService;
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\static\\img\\uploads";

	@PostMapping("materiel/add")
	public String materielAdd(Model model, @ModelAttribute("materiel") MaterielDto materielDto,
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
		if (materielDto.getExpireAt().isBlank() || materielDto.getExpireAt().isEmpty()
				|| materielDto.getExpireAt() == null) {
			expireAt = null;
		} else {
			expireAt = LocalDate.parse(materielDto.getExpireAt());
		}

		Materiel materiel = new Materiel(materielDto.getName(), materielDto.getDescription(), fileName,
				materielDto.getQuantite(), materielDto.getMinQuantite(), expireAt, user);

		materielService.saveMateriel(materiel);

		return "redirect:/materiel/list";
	}

	@RequestMapping("materiel/delete/{id}")
	public String materielDelete(@PathVariable long id) {
		materielService.deleteProduct(id);
		return "redirect:/materiel/list";
	}

	@RequestMapping("/materiel/list")
	public String viewMaterielList(Model model) {
		List<Materiel> liste = materielService.getAllMateriels();
		MaterielDto materiel = new MaterielDto();
		model.addAttribute("materiel", materiel);
		model.addAttribute("materielList", liste);
		model.addAttribute("link", "materiel-list");
		return "materiel/list";
	}

	@RequestMapping("/materiel/details/{id}")
	public String viewMaterielDetails(Model model, @PathVariable long id) {
		Materiel materiel = materielService.getById(id);
		model.addAttribute("materiel", materiel);
		model.addAttribute("link", "materiel-list");
		return "materiel/details";
	}

}

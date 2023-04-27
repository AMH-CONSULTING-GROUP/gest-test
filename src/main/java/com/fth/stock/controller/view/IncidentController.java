package com.fth.stock.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fth.stock.dto.IncidentDto;
import com.fth.stock.entity.Incident;
import com.fth.stock.entity.Materiel;
import com.fth.stock.entity.User;
import com.fth.stock.service.IncidentService;
import com.fth.stock.service.MaterielService;
import com.fth.stock.service.UserService;

@Controller
public class IncidentController {

	@Autowired
	private IncidentService incidentService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private UserService userService;

	@PostMapping("incident/add")
	public String incidentAdd(Model model, @ModelAttribute("dto") IncidentDto dto) {

		incidentService.saveIncident(dto.getUserId(), dto.getMaterielId(), dto.getCause(), dto.getQuantite(),
				dto.getDescription());

		return "redirect:/incident/list";
	}

	@RequestMapping("/incident/list")
	public String incidentList(Model model) {
		List<Incident> liste = incidentService.getAllIncident();
		List<User> users = userService.getAllUsers();
		List<Materiel> materiels = materielService.getAllMateriels();
		IncidentDto dto = new IncidentDto();

		model.addAttribute("dto", dto);
		model.addAttribute("incidents", liste);
		model.addAttribute("users", users);
		model.addAttribute("materiels", materiels);
		model.addAttribute("link", "incident-list");
		return "incident/list";
	}

	@RequestMapping("incident/delete/{id}")
	public String delete(@PathVariable long id) {
		incidentService.delete(id);
		return "redirect:/incident/list";
	}

}

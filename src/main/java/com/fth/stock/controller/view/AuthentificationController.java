package com.fth.stock.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationController {

	@GetMapping("/")
	public String log() {
		return "index";
	}

	@GetMapping("/css2")
	public String css2() {
		return "index";
	}

	@GetMapping("/index")
	public String home() {
		return "index";
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

package io.javabrains.springsecurityusingjsp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {

	@GetMapping("/")
	public String home() {

		return "Welcome Home Page ..!!";
	}

	@GetMapping("/admin")
	public String admin() {

		return "Welcome Admin Page ..!!";
	}

	@GetMapping("/user")
	public String user() {

		return "Welcome user page ..!!";
	}

	@GetMapping("/logoutSuccess")
	public String logout() {

		return "Welcome logout page ..!!";
	}
}

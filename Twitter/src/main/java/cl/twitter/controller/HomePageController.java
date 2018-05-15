package cl.twitter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	@GetMapping("/home")
 	public String homePage() {
 		System.out.println("Aplikacja online");	
 		return "forms/success";
 	}
}

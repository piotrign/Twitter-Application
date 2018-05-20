package cl.twitter.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;


public class MyErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String denied() {
		System.out.println("no error");
		return "redirect:/login/";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}

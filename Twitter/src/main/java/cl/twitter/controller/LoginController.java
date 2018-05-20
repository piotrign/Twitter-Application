package cl.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.twitter.dao.UserDao;
import cl.twitter.entity.User;

@Controller
@RequestMapping(path="/login")
public class LoginController {
	
	@Autowired
	private UserDao userRepository;
	
	@GetMapping(path="/")
	public String getUserTweets(Model model) {
		model.addAttribute("User", new User());
		return "login/login";
	}

	@PostMapping(path="/")
	public String getUserTweets(@ModelAttribute String username, @ModelAttribute String password) {
		
		return "redirect:/tweeter/home";
	}

}

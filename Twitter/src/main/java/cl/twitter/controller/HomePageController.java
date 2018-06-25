package cl.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.twitter.entity.User;
import cl.twitter.repository.TweetRepository;
import cl.twitter.service.UserService;

@Controller
public class HomePageController {
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("tweets", tweetRepository.findAllByOrderByCreatedDesc());
		return "/home";
	}

	@PostMapping(path="/home")
	public String getUserTweets(@ModelAttribute String username, @ModelAttribute String password) {
		
		return "redirect:/home";
	}
	
	@GetMapping("/admin/home")
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.setViewName("/home");
		return modelAndView;
	}
	
	
}

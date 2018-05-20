package cl.twitter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.twitter.dao.TweetDao;
import cl.twitter.dao.UserDao;
import cl.twitter.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao userRepo;

	@Autowired
	TweetDao tweetRepo;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getUser(Model model) {
		model.addAttribute(new User());
		return "forms/registerUser";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processUserForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "forms/registerUser";
		}
		userRepo.addUser(user);
		System.out.println(user.getId() + " " + user.getUsername() + " " + user.getEmail());
		return "forms/success";
	}

	@GetMapping("/all")
	public String findAllUser(Model model) {
		model.addAttribute("users", userRepo.getAllUsers());
		return "forms/displayUsers";
	}

	@GetMapping("/{id}/tweets")
	public String findUserTweets(@PathVariable long id, Model model) {
		model.addAttribute("tweets", tweetRepo.getAllTweetsByUserId(id));
		return "forms/displayTweets";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepo.findById(id));
		return "/forms/addUser";
	}

	@PostMapping("/edit/{id}")
	public String saveEditedUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "/forms/addUser";
		}
		userRepo.updateUser(user);
		return "redirect:/user/all";
	}
	@GetMapping("/remove/{id}")
	 	public String removeUser(@PathVariable long id) {
		userRepo.deleteById(id);
		return "redirect:/user/all";
	}
	
}

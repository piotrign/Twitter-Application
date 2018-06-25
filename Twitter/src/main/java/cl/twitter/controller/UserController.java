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

import cl.twitter.entity.User;
import cl.twitter.repository.TweetRepository;
import cl.twitter.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	UserRepository userRepository;

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
		userRepository.save(user);
		System.out.println(user.getId() + " " + user.getLastName() + " " + user.getEmail());
		return "forms/success";
	}

	@GetMapping("/all")
	public String findAllUser(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "forms/displayUsers";
	}

	@GetMapping("/{id}/tweets")
	public String findUserTweets(@PathVariable long id, Model model) {
		model.addAttribute("tweets", tweetRepository.findAllTweetByUserId(id));
		return "forms/displayTweets";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepository.findById(id));
		return "/forms/addUser";
	}

	@PostMapping("/edit/{id}")
	public String saveEditedUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "/forms/addUser";
		}
		userRepository.save(user);
		return "redirect:/user/all";
	}

	@GetMapping("/remove/{id}")
	public String removeUser(@PathVariable long id) {
		userRepository.delete(id);
		return "redirect:/user/all";
	}

}

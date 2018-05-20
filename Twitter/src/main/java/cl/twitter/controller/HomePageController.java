package cl.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.twitter.dao.TweetDao;

@Controller
public class HomePageController {
	@Autowired
	private TweetDao tweetDao;

	@GetMapping("/user/home")
	public String homePage(Model model) {
		model.addAttribute("tweets", tweetDao.getAllTweets());
		return "forms/home";
	}

	@GetMapping("/login")
	public String login() {
		return "forms/login";
	}

}

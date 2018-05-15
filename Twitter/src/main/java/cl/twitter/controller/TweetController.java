package cl.twitter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.twitter.dao.TweetDao;
import cl.twitter.dao.UserDao;
import cl.twitter.entity.Tweet;
import cl.twitter.entity.User;


@Controller
@RequestMapping("/tweet")
public class TweetController {

	@Autowired
	TweetDao tweetRepo;
	
	@Autowired
	UserDao userRepo;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getTweet(Model model) {
		model.addAttribute("tweet",new Tweet());
		return "forms/addTweet";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processTweetForm(@Valid Tweet tweet, BindingResult result) {
		if(result.hasErrors()) {
			return "forms/addTweet";
		}
		tweetRepo.addTweet(tweet);
		System.out.println(tweet.getId() + " " + tweet.getTitle() + " " + tweet.getTextBox());
		return "forms/success";
	}
	
	@ModelAttribute("userList")
	public List<User> allUserList() {
		List<User> allUsers = userRepo.getAllUsers();
		return allUsers;
	}
	
}

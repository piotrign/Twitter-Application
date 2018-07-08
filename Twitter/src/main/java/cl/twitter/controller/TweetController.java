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

import cl.twitter.entity.Tweet;
import cl.twitter.repository.TweetRepository;
import cl.twitter.repository.UserRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/add")
	public String getTweet(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "forms/addTweet";
	}

	@PostMapping("/add")
	public String processTweetForm(@Valid Tweet tweet, BindingResult result) {
		if (result.hasErrors()) {
			return "forms/addTweet";
		}
		tweetRepository.save(tweet);
		System.out.println(tweet.getId() + " " + tweet.getTitle() + " " + tweet.getTextBox());
		return "/forms/addTweet";
	}
	/** 
	 * This method displays details of selected tweet by provided id.
	 * */
	@GetMapping("details/{id}")
	public String findTweetDetails(@PathVariable int id, Model model) {
		model.addAttribute("tweet", tweetRepository.findById(id));
		return "tweetDetails";
	}
	/** 
	 * This method displays form to edit selected tweet by provided id.
	 * */
	@GetMapping("edit/{id}")
	public String editTweet(@PathVariable int id, Model model) {
		model.addAttribute("tweetDetails", tweetRepository.findById(id));
		return "forms/editTweet";
	}
	
	/** 
	 * This method process form to edit selected tweet by provided id.
	 * */
	@PostMapping("edit/{id}")
	public String saveEditedTweet(@Valid Tweet tweet, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("form edit error");
			return "tweetDetails";
		}
		System.out.println("ID" + " " + tweet.getId() + " " + "Title" + " " + tweet.getTitle());
		tweetRepository.save(tweet);
		return "tweetDetails";
	}
}

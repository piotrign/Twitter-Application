package cl.twitter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.twitter.entity.Comment;
import cl.twitter.repository.CommentRepository;
import cl.twitter.repository.TweetRepository;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	TweetRepository tweetRepository;
	
	@GetMapping("/add/{id}")
	public String getComment(@PathVariable long id, Model model) {
		model.addAttribute("comment", new Comment());
		model.addAttribute("tweet", tweetRepository.findById(id));
		return "forms/addComment";
	}

	@PostMapping("/add/{id}")
	public String processCommentForm(@AuthenticationPrincipal UserDetails currentUser, @Valid Comment comment, BindingResult result) {
		if (result.hasErrors()) {
			return "forms/addComment";
		}
		Comment commentPosted = new Comment();
		commentPosted.setUser(user.getId);
		commentRepository.save(comment);
		System.out.println(comment.getId() + " " + comment.getCreated() + " " + comment.getCommentText());
		return "/forms/addComment";
	}
}

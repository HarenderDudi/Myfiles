package com.dudi.twitter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController combines 
 * 		@Controller and 
 * 		@ResponseBody, 
 * two annotations that results in web requests returning data  rather than a view*/

@RestController
public class CommentController {

	@GetMapping("/comment")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}
//
//
//Tweet
//User
//Comments

package com.dudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping(value = "/search")
public class TestController {

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody String test() {
		System.out.println("THIS IS SUCCESS");
		return "HELLO TIME WASTER";
	}
}

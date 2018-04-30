package com.kurromat.hikingmetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		return new ModelAndView("hello").addObject("recipient", "world");
	}
}

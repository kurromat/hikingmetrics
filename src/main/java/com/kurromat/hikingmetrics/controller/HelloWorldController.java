package com.kurromat.hikingmetrics.controller;

import com.kurromat.hikingmetrics.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelloWorldController {


	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping("/")
	public ModelAndView helloRoot() {
		return new ModelAndView("index").addObject("person", new Person());
	}

	@RequestMapping(value = "/doGreet", method = POST)
	public ModelAndView doGreet(@ModelAttribute Person person) {
		helloWorldService.registerGreeting(person.getName());
		return new ModelAndView("doGreet").addObject("person", helloWorldService.getPerson(person.getName()));
	}
}

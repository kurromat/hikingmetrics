package com.kurromat.hikingmetrics.controller;

import com.kurromat.hikingmetrics.model.Person;
import com.kurromat.hikingmetrics.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {


	private PersonRepository greetingRegistry;

	@Autowired
	public HelloWorldService(PersonRepository repository) {
		this.greetingRegistry = repository;
	}

	public void registerGreeting(String recipient) {
		Person person = greetingRegistry.findByName(recipient).orElse(new Person(recipient));
		person.setCount(person.getCount() + 1);
		greetingRegistry.save(person);
	}

	public Person getPerson(String recipient) {
		return greetingRegistry.findByName(recipient).orElseThrow(() -> new RuntimeException("recipient " + recipient + " not found"));
	}
}

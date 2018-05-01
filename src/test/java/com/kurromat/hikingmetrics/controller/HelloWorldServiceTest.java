package com.kurromat.hikingmetrics.controller;

import com.kurromat.hikingmetrics.model.Person;
import com.kurromat.hikingmetrics.repositories.PersonRepository;
import com.kurromat.hikingmetrics.services.HelloWorldService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldServiceTest {

	private static final String JOE = "Joe";
	private HelloWorldService service;

	@Mock
	private PersonRepository repository;

	@Before
	public void setUp() {
		service = new HelloWorldService(repository);
	}

	@Test
	public void registerGreeting() {
		when(repository.findByName(JOE)).thenReturn(Optional.empty());
		service.registerGreeting(JOE);
		when(repository.findByName(JOE)).thenReturn(Optional.of(new Person(JOE, 1)));
		assertThat(service.getPerson(JOE).getCount(), is(1));
	}

	@Test
	public void calculateAllGreetings() {
		when(repository.findAll()).thenReturn(Stream.of(new Person("Joe", 3), new Person("Sue", 8)).collect(toList()));

		Map<String, Integer> greetings = service.calculateAllGreetings();
		assertThat(greetings, hasEntry("Joe", 3));
		assertThat(greetings, hasEntry("Sue", 8));
	}
}
package com.kurromat.hikingmetrics.controller;

import com.kurromat.hikingmetrics.model.Person;
import com.kurromat.hikingmetrics.repositories.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

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
}
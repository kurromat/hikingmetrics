package com.kurromat.hikingmetrics.controller;

import com.kurromat.hikingmetrics.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {

	private static final String WORLD = "World";
	private static final String JOE = "Joe";
	private HelloWorldController controller;

	@Mock
	private HelloWorldService service;

	@Before
	public void setUp() {
		controller = new HelloWorldController(service);
	}

	@Test
	public void helloWorldRegistersWorld() {
		controller.doGreet(new Person(WORLD, 0));
		verify(service, times(1)).registerGreeting(WORLD);
	}

	@Test
	public void helloWorldRegistersRecipientAndChecksCount() {
		controller.doGreet(new Person(JOE, 0));
		verify(service, times(1)).registerGreeting(JOE);
		verify(service, times(1)).getPerson(JOE);
	}
}
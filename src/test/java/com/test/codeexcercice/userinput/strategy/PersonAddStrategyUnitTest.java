package com.test.codeexcercice.userinput.strategy;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.model.Person;
import com.test.codeexcercice.model.Response;

//TODO: for all other classes in a similar way
@RunWith(MockitoJUnitRunner.class)
public class PersonAddStrategyUnitTest {

	@Mock
	PersonDao dao;
	
	@InjectMocks
	PersonAddStrategy strategy;
	
	@Test
	public void test_process_valid() {
		Person mockedObj = new Person(1, "James", "Bridges");
		when(dao.addPerson(any(Person.class))).thenReturn(mockedObj);
		
		Response<Person> actual = strategy.process("1,James,Bridges");
		
		//verify the args
		ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
		verify(dao).addPerson(personCaptor.capture());
		assertEquals(1, personCaptor.getValue().getId());
		assertEquals("James", personCaptor.getValue().getFirstName());
		assertEquals("Bridges", personCaptor.getValue().getSurname());
		
		//Verify the actual return value
		assertEquals(1, actual.getBody().getId());
		assertEquals("James", actual.getBody().getFirstName());
		assertEquals("Bridges", actual.getBody().getSurname());
	}
	
	//TODO:
	public void test_process_invalid() {
		
	}
}

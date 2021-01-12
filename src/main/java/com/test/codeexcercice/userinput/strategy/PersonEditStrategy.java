package com.test.codeexcercice.userinput.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.model.Person;
import com.test.codeexcercice.model.Response;

public class PersonEditStrategy implements PersonStrategy<Person>{
	
	@Autowired
	private PersonDao dao;
	
	@Override
	public Response<Person> process(String params) {
		
		String[] data = params.split(",");
		Person person = new Person(data[0], data[1]);
		Response<Person> response = new Response<>();
		response.setBody(dao.editPerson(person));
		response.setResultMessage("Persons edit success");
		return response;

	}
}

package com.test.codeexcercice.userinput.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.model.Person;
import com.test.codeexcercice.model.Response;

public class PersonDeleteStrategy implements PersonStrategy<Person>{

	@Autowired
	private PersonDao dao;
	
	@Override
	public Response<Person> process(String param) {
		Person person = new Person(Integer.valueOf(param));
		Response<Person> response = new Response<>();
		response.setBody(dao.deletePerson(person));
		response.setResultMessage("Persons delete success");
		return response;
	}
}

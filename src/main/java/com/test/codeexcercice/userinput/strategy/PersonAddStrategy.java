package com.test.codeexcercice.userinput.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.model.Person;
import com.test.codeexcercice.model.Response;

public class PersonAddStrategy implements PersonStrategy<Person> {

	@Autowired
	private PersonDao dao;

	public Response<Person> process(String params) {
		String[] data = this.getParams(params);
		//TODO: validate
		Person person = new Person(Integer.valueOf(data[0]),data[1], data[2]);
		Response<Person> response = new Response<>();
		response.setBody(dao.addPerson(person));
		response.setResultMessage("Persons Add success");
		return response;
	}
	
	private void validate() {
		//TODO:
		//Check if necessary params are present
		//If not throw a checked exception and handle in the calling method 
	}
}

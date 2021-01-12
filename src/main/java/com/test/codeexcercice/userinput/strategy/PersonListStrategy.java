package com.test.codeexcercice.userinput.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.model.Person;
import com.test.codeexcercice.model.Response;

public class PersonListStrategy implements PersonStrategy<List<Person>> {

	
	@Autowired
	private PersonDao dao;
	
	@Override
	public Response<List<Person>> process(String params) {
		Response<List<Person>> response = new Response<>();
		response.setBody(dao.listPersons());
		response.setResultMessage("Persons list success");
		return response;
	}
}

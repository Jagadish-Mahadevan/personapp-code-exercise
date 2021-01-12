package com.test.codeexcercice.userinput.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.model.Response;

@Service
public class PersonCountStrategy implements PersonStrategy<Integer> {

	@Autowired
	private PersonDao dao;
	
	@Override
	public Response<Integer> process(String params) {
		Response<Integer> response = new Response<>();
		response.setResultMessage("Persons count queried successfully.");
		response.setBody(dao.countPersons());
		return response;
	}

}

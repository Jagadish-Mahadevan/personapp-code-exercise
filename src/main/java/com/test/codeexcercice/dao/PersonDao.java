package com.test.codeexcercice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.codeexcercice.model.Person;

public class PersonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Person addPerson(Person person) {
		int rowCount = jdbcTemplate.update("INSERT INTO PERSON (id, firstname, surname) values (?,?,?)", 
				person.getId(), person.getFirstName(), person.getSurname());
		if(rowCount == 1) {
			return person;
		} else {
			throw new RuntimeException();
		}
	}
	
	public Person editPerson(Person person) {
		int rowCount = jdbcTemplate.update("UPDATE PERSON SET firstname=?, surname=? where id=?", 
				person.getFirstName(), person.getSurname(), person.getId());
		if(rowCount == 1) {
			return person;
		} else {
			throw new RuntimeException();
		}
	}
	
	public Person deletePerson(Person person) {
		int rowCount = jdbcTemplate.update("delete from PERSON where id=?", person.getId());
		if(rowCount == 1) {
			return person;
		} else {
			throw new RuntimeException();
		}
	}
	
	public List<Person> listPersons() {
		return jdbcTemplate.query("select id, firstname, surname from PERSON", new RowMapper<Person>(){  
		    @Override  
		    public Person mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));  
		        return person;  
		    }
		});
	}
	
	public int countPersons() {
		return jdbcTemplate.queryForObject("select count(id) from person", Integer.class);
	}
}

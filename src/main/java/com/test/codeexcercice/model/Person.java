package com.test.codeexcercice.model;

public class Person {
	
	private int id;
	private String firstName;
	private String surname;

	public Person(int id) {
		this.id = id;
	}

	public Person(String firstName, String surname) {
		super();
		this.firstName = firstName;
		this.surname = surname;
	}
	public Person(int id, String firstName, String surname) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", surname=" + surname + "]";
	}
}

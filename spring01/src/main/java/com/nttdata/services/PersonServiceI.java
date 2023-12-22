package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Person;

public interface PersonServiceI {
	
	void newPerson(Person person);
	
	void remPerson(Person person);
	
	public List<Person> getAllPeople();
	
	public List<Person> getPersonByName(final String name);
	
	public List<Person> getPersonByApartment(final Long apartmentId);
}

package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Person;

public interface PersonServiceI {
	
	void newPerson(Person person);
	
	void removePerson(Person person);
	
	void removePersonById(Long id);
	
	void removePersonByIdentityDoc(String identityDoc);
	
	public List<Person> getAllPeople();
	
	public List<Person> getPersonByName(final String name);
	
	public List<Person> getPersonByApartmentId(final Long apartmentId);
}

package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Person;

public interface PersonServiceI {
	
	public void newPerson(Person person);
	
	public void removePerson(Person person);
	
	public void removePersonById(Long id);
	
	public void removePersonByIdentityDoc(String identityDoc);
	
	public List<Person> getAllPeople();
	
	public List<Person> getPersonByFloorLevel(final Integer level);
	
	public List<Person> getPersonByApartmentLetter(final Character letter);
	
	public Person getPersonByIdentityDoc(final String identityDoc);
	
	public List<Person> getPersonByName(final String name);
	
	public List<Person> getPersonBySurname(final String surname);
	
	public List<Person> getPersonByApartmentId(final Long apartmentId);
}

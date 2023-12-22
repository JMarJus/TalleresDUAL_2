package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Person;
import com.nttdata.persistence.PersonRepositoryI;

@Service
public class PersonServiceImpl implements PersonServiceI {

	@Autowired
	private PersonRepositoryI personRepository;

	@Override
	public void newPerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public void remPerson(Person person) {
		personRepository.delete(person);
	}

	@Override
	public List<Person> getAllPeople() {
		return personRepository.findAll();
	}

	@Override
	public List<Person> getPersonByName(String name) {
		return personRepository.findByName(name);
	}

	@Override
	public List<Person> getPersonByApartment(Long apartmentId) {
		return personRepository.findByApartmentId(apartmentId);
	}
}

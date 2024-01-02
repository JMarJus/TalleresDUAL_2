package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Apartment;
import com.nttdata.persistence.ApartmentRepositoryI;
import com.nttdata.persistence.FloorRepositoryI;
import com.nttdata.persistence.Person;
import com.nttdata.persistence.PersonRepositoryI;

@Service
public class PersonServiceImpl implements PersonServiceI {

	@Autowired
	private PersonRepositoryI personRepository;

	@Autowired
	private ApartmentRepositoryI apartmentRepository;

	@Autowired
	private FloorRepositoryI floorRepository;

	@Override
	public void newPerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public void removePerson(Person person) {
		personRepository.delete(person);
	}

	@Override
	public void removePersonById(Long id) {
		personRepository.deleteById(id);
	}

	@Override
	public void removePersonByIdentityDoc(String identityDoc) {
		personRepository.deleteByIdentityDoc(identityDoc);
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
	public List<Person> getPersonByApartmentId(Long apartmentId) {
		return personRepository.findByApartmentId(apartmentId);
	}

	@Override
	public List<Person> getPersonByFloorLevel(Integer level) {
		List<Person> people = new ArrayList<>();
		if (floorRepository.findByLevel(level) != null) {
			for (Apartment apartment: apartmentRepository.findByFloorId(floorRepository.findByLevel(level).getId())) {
				people.addAll(personRepository.findByApartmentId(apartment.getId()));
			}
		}
		return people;
	}

	@Override
	public List<Person> getPersonByApartmentLetter(Character letter) {
		List<Person> people = new ArrayList<>();
		for (Apartment apartment: apartmentRepository.findByLetter(letter)) {
			people.addAll(personRepository.findByApartmentId(apartment.getId()));
		}
		return people;
	}

	@Override
	public Person getPersonByIdentityDoc(String identityDoc) {
		return personRepository.findByIdentityDoc(identityDoc);
	}

	@Override
	public List<Person> getPersonBySurname(String surname) {
		return personRepository.findBySurname(surname);
	}
}

package com.nttdata.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryI extends JpaRepository<Person, Long> {

	public void deleteByIdentityDoc(final String identityDoc);

	public Person findByIdentityDoc(final String identityDoc);
	
	public List<Person> findByApartmentId(final Long apartmentId);
	
	public List<Person> findByName(final String name);

	public List<Person> findBySurname(final String surname);

	public List<Person> findByNameOrSurname(final String name, final String surname);

	public List<Person> findByNameAndSurname(final String name, final String surname);

}

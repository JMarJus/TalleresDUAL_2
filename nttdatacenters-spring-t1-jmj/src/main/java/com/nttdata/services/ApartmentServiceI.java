package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.persistence.Apartment;

public interface ApartmentServiceI {
	
	public void newApartment(Apartment apartment);
	
	public void removeApartment(Apartment apartment);
	
	public List<Apartment> getAllApartments();
	
	public List<Apartment> getApartmentByLetter(final Character letter);
	
	public List<Apartment> getApartmentByFloor(final Long floorId);
	
	public List<Apartment> getApartmentByFloorLevel(final Integer level);
	
	public Apartment getApartmentByPersonIdentityDoc(final String identityDoc);

	public Optional<Apartment> getApartmentById(Long id);

	public void removeApartmentById(Long id);

	public List<Apartment> getAllApartmentsSortByLetter();

	Apartment getApartmentByFloorLevelAndLetter(Integer level, Character letter);
}

package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.persistence.Apartment;

public interface ApartmentServiceI {
	
	void newApartment(Apartment apartment);
	
	void removeApartment(Apartment apartment);
	
	public List<Apartment> getAllApartments();
	
	public List<Apartment> getApartmentByFloor(final Long floorId);

	public Optional<Apartment> getApartmentById(Long id);

	void removeApartmentById(Long id);
}

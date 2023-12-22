package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Apartment;

public interface ApartmentServiceI {
	
	void newApartment(Apartment apartment);
	
	void removeApartment(Apartment apartment);
	
	public List<Apartment> getAllApartments();
	
	public List<Apartment> getApartmentByFloor(final Long floorId);
}

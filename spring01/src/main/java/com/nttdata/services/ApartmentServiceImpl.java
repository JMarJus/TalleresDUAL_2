package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Apartment;
import com.nttdata.persistence.ApartmentRepositoryI;

@Service
public class ApartmentServiceImpl implements ApartmentServiceI {

	@Autowired
	private ApartmentRepositoryI apartmentRepository;

	@Override
	public void newApartment(Apartment apartment) {
		apartmentRepository.save(apartment);
	}

	@Override
	public void removeApartment(Apartment apartment) {
		apartmentRepository.delete(apartment);
	}

	@Override
	public List<Apartment> getAllApartments() {
		return apartmentRepository.findAll();
	}

	@Override
	public List<Apartment> getApartmentByFloor(Long floorId) {
		return apartmentRepository.findByFloorId(floorId);
	}

	@Override
	public Optional<Apartment> getApartmentById(Long id) {
		return apartmentRepository.findById(id);
	}

	@Override
	public void removeApartmentById(Long id) {
		apartmentRepository.deleteById(id);
	}
}

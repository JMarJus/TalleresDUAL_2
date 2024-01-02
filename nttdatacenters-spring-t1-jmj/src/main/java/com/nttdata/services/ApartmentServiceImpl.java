package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Apartment;
import com.nttdata.persistence.ApartmentRepositoryI;
import com.nttdata.persistence.FloorRepositoryI;
import com.nttdata.persistence.PersonRepositoryI;

@Service
public class ApartmentServiceImpl implements ApartmentServiceI {

	@Autowired
	private ApartmentRepositoryI apartmentRepository;

	@Autowired
	private FloorRepositoryI floorRepository;

	@Autowired
	private PersonRepositoryI personRepository;

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

	@Override
	public List<Apartment> getApartmentByLetter(Character letter) {
		return apartmentRepository.findByLetter(letter);
	}

	@Override
	public List<Apartment> getApartmentByFloorLevel(Integer level) {
		if (floorRepository.findByLevel(level) != null) {
			return apartmentRepository.findByFloorId(floorRepository.findByLevel(level).getId());
		} else {
			return apartmentRepository.findByFloorId(Long.parseLong("0"));
		}
	}

	@Override
	public Apartment getApartmentByPersonIdentityDoc(String identityDoc) {
		if (personRepository.findByIdentityDoc(identityDoc) != null) {
			return apartmentRepository.findById(personRepository.findByIdentityDoc(identityDoc).getApartmentId()).get();
		} else {
			return null;
		}
	}
}

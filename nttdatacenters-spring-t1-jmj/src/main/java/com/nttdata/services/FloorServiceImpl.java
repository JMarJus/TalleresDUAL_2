package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.ApartmentRepositoryI;
import com.nttdata.persistence.Floor;
import com.nttdata.persistence.FloorRepositoryI;
import com.nttdata.persistence.PersonRepositoryI;

@Service
public class FloorServiceImpl implements FloorServiceI {

	@Autowired
	private FloorRepositoryI floorRepository;

	@Autowired
	private ApartmentRepositoryI apartmentRepository;

	@Autowired
	private PersonRepositoryI personRepository;

	@Override
	public void newFloor(Floor floor) {
		floorRepository.save(floor);
	}

	@Override
	public void removeFloor(Floor floor) {
		floorRepository.delete(floor);
	}

	@Override
	public Optional<Floor> getFloor(Long id) {
		return floorRepository.findById(id);
	}

	@Override
	public List<Floor> getAllFloors() {
		return floorRepository.findAll();
	}

	@Override
	public List<Floor> getAllFloorsSortByLevel() {
		return floorRepository.findAll(Sort.by(Sort.Direction.DESC, "level"));
	}

	@Override
	public Floor getFloorByLevel(Integer level) {
		return floorRepository.findByLevel(level);
	}

	@Override
	public Optional<Floor> getFloorById(Long id) {
		return floorRepository.findById(id);
	}

	@Override
	public void removeFloorById(Long id) {
		floorRepository.deleteById(id);
	}

	@Override
	public Floor getFloorByPersonIdentityDoc(String identityDoc) {
		if (personRepository.findByIdentityDoc(identityDoc) != null) {
			return floorRepository.findById(apartmentRepository.findById(personRepository.findByIdentityDoc(identityDoc).getApartmentId()).get().getFloorId()).get();
		} else {
			return floorRepository.findById(Long.parseLong("0")).get();
		}
	}
	
}

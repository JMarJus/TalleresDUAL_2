package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Floor;
import com.nttdata.persistence.FloorRepositoryI;

@Service
public class FloorServiceImpl implements FloorServiceI {

	@Autowired
	private FloorRepositoryI floorRepository;

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
}
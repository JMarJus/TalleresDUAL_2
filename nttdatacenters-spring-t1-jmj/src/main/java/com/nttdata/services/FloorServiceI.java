package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.persistence.Floor;

public interface FloorServiceI {
	
	void newFloor(Floor floor);
	
	void removeFloor(Floor floor);
	
	public Optional<Floor> getFloor(final Long id);
	
	public List<Floor> getAllFloors();
	
	public Floor getFloorByLevel(final Integer level);
	
	public Floor getFloorByPersonIdentityDoc(final String identityDoc);

	Optional<Floor> getFloorById(Long id);

	void removeFloorById(Long id);
}

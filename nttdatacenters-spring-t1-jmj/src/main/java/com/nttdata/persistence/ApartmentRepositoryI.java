package com.nttdata.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepositoryI extends JpaRepository<Apartment, Long> {

	public List<Apartment> findByFloorId(final Long floorId);

	public List<Apartment> findByLetter(final Character letter);

}

package com.nttdata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepositoryI extends JpaRepository<Floor, Long> {

	public Floor findByLevel(final Integer level);

}

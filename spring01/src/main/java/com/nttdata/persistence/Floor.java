package com.nttdata.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "floor")
@Getter
@Setter
public class Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * Floor position (Level)
	 */
	@Column(name = "level", nullable = false)
	private Integer level;

	/**
	 * Number of apartments (Apartment Quantity)
	 */
	@Column(name = "apartment_qty", nullable = false)
	private Integer apartmentQty;
	
	/**
	 * Special setter for apartmentQty: The number of apartments in a floor can never be less than 0
	 * @param apartmentQty
	 */
	public void setApartmentQty(Integer apartmentQty){
		if (apartmentQty >= 0) {
			this.apartmentQty = apartmentQty;
		}
	}
}

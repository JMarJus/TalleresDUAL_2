package com.nttdata.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "apartment")
@Getter
@Setter
public class Apartment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * ID of the apartment's floor
	 */
	@Column(name = "floor_id", nullable = false)
	private Long floorId;

	/**
	 * Apartment letter (Local ID for its floor)
	 */
	@Column(name = "letter", nullable = false)
	private Character letter;
	
	/**
	 * Special setter for letter: The Character must be a letter.
	 * @param letter
	 */
	public void setLetter(Character letter){
		if (Character.isLetter(letter)) {
			this.letter = letter;
		}
	}
}

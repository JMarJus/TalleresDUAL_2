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
@Table(name = "person")
@Getter
@Setter
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * ID of the person's apartment
	 */
	@Column(name = "apartment_id", nullable = true)
	private Long apartmentId;

	/**
	 * Government identifier of the person (Identity Document)
	 */
	@Column(name = "identity_doc", nullable = false)
	private String identityDoc;

	/**
	 * First name(s) of the person
	 */
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * Last name(s) of the person
	 */
	@Column(name = "surname", nullable = true)
	private String surname;
}

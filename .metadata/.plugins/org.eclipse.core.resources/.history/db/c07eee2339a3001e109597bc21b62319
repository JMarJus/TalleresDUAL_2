package com.nttdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.controllers.AssignmentController;
import com.nttdata.persistence.Apartment;
import com.nttdata.persistence.Floor;
import com.nttdata.persistence.Person;
import com.nttdata.services.ApartmentServiceI;
import com.nttdata.services.FloorServiceI;
import com.nttdata.services.PersonServiceI;

@SpringBootApplication
public class SpringTaller01Application implements CommandLineRunner {

	@Autowired
	private PersonServiceI personService;
	
	@Autowired
	private ApartmentServiceI apartmentService;
	
	@Autowired
	private FloorServiceI floorService;

	public static void main(String[] args) {
		SpringApplication.run(SpringTaller01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		AssignmentController assignment = new AssignmentController();
		assignment.testMethod();
		
		final Floor floor = new Floor();
		floor.setLevel(2);
		floor.setApartmentQty(4);
		floorService.newFloor(floor);
		
		final Apartment apartment = new Apartment();
		apartment.setLetter('A');
		apartment.setFloorId(Long.parseLong("1"));
		apartmentService.newApartment(apartment);
		
		final Person person = new Person();
		person.setIdentityDoc("77230084V");
		person.setApartmentId(Long.parseLong("1"));
		person.setName("Juan");
		person.setSurname("Martínez Justicia");
		personService.newPerson(person);

		for (Person personGot: personService.getAllPeople()) {
			System.out.println(personGot.getId() + " | Apartament: " + personGot.getApartmentId());
			for (Apartment apartmentGot: apartmentService.getAllApartments()) {
				System.out.println(apartmentGot.getId() + " | Floor: " + apartmentGot.getFloorId());
				if (personGot.getApartmentId().equals(apartmentGot.getId())) {
					System.out.println(personService.getPersonByApartment(apartmentGot.getId()).getFirst().getName() + " " + personService.getPersonByApartment(apartmentGot.getId()).getFirst().getSurname());
					floorService.getFloor(apartmentGot.getFloorId()).ifPresent(floorGot -> System.out.println(floorGot.getLevel() + "º " + apartmentGot.getLetter()));
				}
			}
		}
	}

}

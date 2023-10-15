package caiquessantos.com.github.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import caiquessantos.com.github.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding by id!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Caíque");
		person.setLastName("Santos");
		person.setAdress("Bahia");
		person.setGernder("Male");
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		logger.info("Finding all!");
		
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("Creating a new person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating a person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting a person!");
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Name "+i);
		person.setLastName("Last name "+i);
		person.setAdress("Any adress "+i);
		person.setGernder("Any gender");
		return person;
	}

}

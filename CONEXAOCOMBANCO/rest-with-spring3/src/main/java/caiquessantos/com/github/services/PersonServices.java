package caiquessantos.com.github.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caiquessantos.com.github.exceptions.ResourceNotFoundExeption;
import caiquessantos.com.github.model.Person;
import caiquessantos.com.github.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	//faz a injeção do repositório criado
	@Autowired
	PersonRepository rp;
	
	public Person findById(Long id) {
		logger.info("Finding by id!");

		//caso n encotre nada vai lançar uma exceção costumizada
		return rp.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Nothing found!"));
	}
	
	public List<Person> findAll(){
		
		return rp.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating a new person!");
		return rp.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating a person!");
		
		Person entity = rp.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExeption("Nothing found!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return rp.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting a person!");
		Person entity = rp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Nothing found!"));
		rp.delete(entity);
	}

}

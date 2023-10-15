package caiquessantos.com.github.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import caiquessantos.com.github.model.Person;
import caiquessantos.com.github.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices ps;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findByid(@PathVariable(value = "id")String id) {
		return ps.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return ps.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return ps.create(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return ps.update(person);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value ="id")String id) {
		ps.delete(id);
	}

}

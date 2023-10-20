package caiquessantos.com.github.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import caiquessantos.com.github.data.vo.v1.PersonVO;
import caiquessantos.com.github.data.vo.v2.PersonVOV2;
import caiquessantos.com.github.services.PersonServices;


//faz o controle de todos os verbos get, post, put, delete, chamando as operações services 
//necessárias
@RestController
@RequestMapping("/person")
public class PersonController {
	
	//injeta a dependencia de service para conseguir efetuar asoperações
	@Autowired
	private PersonServices ps;

//passando o PersonVO para tornar os atributos menos acessíveis para o client
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findByid(@PathVariable(value = "id")Long id) {
		return ps.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll(){
		return ps.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO person) {
		return ps.create(person);
	}
	
	//criando um método de post para a versao 2 da api
	@PostMapping(value = "/v2" ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return ps.createV2(person);
	}
	
	@PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person) {
		return ps.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value ="id")Long id) {
		ps.delete(id);
		return ResponseEntity.noContent().build();
	}

}

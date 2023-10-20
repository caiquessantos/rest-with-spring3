package caiquessantos.com.github.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caiquessantos.com.github.data.vo.v1.PersonVO;
import caiquessantos.com.github.data.vo.v2.PersonVOV2;
import caiquessantos.com.github.exceptions.ResourceNotFoundExeption;
import caiquessantos.com.github.mapper.DozerMapper;
import caiquessantos.com.github.mapper.custom.PersonMapper;
import caiquessantos.com.github.model.Person;
import caiquessantos.com.github.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	//faz a injeção do repositório criado
	@Autowired
	PersonRepository rp;
	
	//faz a injeção do mapper customizado
	@Autowired
	PersonMapper pm;
	
	public PersonVO findById(Long id) {
		logger.info("Finding by id!");

		//caso n encotre nada vai lançar uma exceção costumizada
		var entity = rp.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Nothing found!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll(){
		
		return DozerMapper.parseListObjects(rp.findAll(), PersonVO.class);
	}
	
	//metodo para criar uma pessoa na versao 2 do código
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating a new person with V2!");
		
		var entity = pm.convertVOToEntity(person);
		rp.save(entity);
		var vo = pm.convertEntityToVO(entity);
		return vo;
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating a new person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		rp.save(entity);
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating a person!");
		
		var entity = rp.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExeption("Nothing found!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		rp.save(entity);
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting a person!");
		var entity = rp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Nothing found!"));
		rp.delete(entity);
	}

}

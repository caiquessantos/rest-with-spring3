package caiquessantos.com.github.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import caiquessantos.com.github.data.vo.v2.PersonVOV2;
import caiquessantos.com.github.model.Person;
//responsável por converter a versao 2 da VO na entidade Person para  injetar no banco de dados
@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAdress(person.getAdress());
		vo.setDate(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	} 
	
	public Person convertVOToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAdress(person.getAdress());
		//entity.setDate(new Date());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	} 
}

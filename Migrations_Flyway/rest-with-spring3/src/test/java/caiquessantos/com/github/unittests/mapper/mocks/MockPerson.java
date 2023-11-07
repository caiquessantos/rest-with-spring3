package caiquessantos.com.github.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import caiquessantos.com.github.data.vo.v1.PersonVO;
import caiquessantos.com.github.model.Person;

public class MockPerson {

	//cria mocks de entidade
    public Person mockEntity() {
        return mockEntity(0);
    }
    
    //criar mocks de VO
    public PersonVO mockVO() {
        return mockVO(0);
    }
    
    //mocka uma lista de entidades
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    //mocka uma lista de VOs
    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAdress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAdress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}

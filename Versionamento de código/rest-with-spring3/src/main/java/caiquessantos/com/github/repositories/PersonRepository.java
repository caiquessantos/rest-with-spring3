package caiquessantos.com.github.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import caiquessantos.com.github.model.Person;

//repositorio criado para fazer as 4 operações básicas de crud
public interface PersonRepository extends JpaRepository<Person, Long> {}

package com.qf.farmer.md.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.md.domain.Person;
import com.qf.farmer.md.repository.PersonRepository;
import com.qf.farmer.md.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public void doWork() {

		repository.deleteAll();

		Person person = new Person();
		person.setFirstname("Oliver");
		person.setLastname("Gierke");
		person = repository.save(person);

		List<Person> lastNameResults = repository.findByLastname("Gierke");
		List<Person> firstNameResults = repository.findByFirstnameLike("Oli*");
	}
}
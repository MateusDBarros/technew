package com.example.technew.person.service;

import com.example.technew.person.model.Person;
import com.example.technew.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;


    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void addNewPerson(Person person) {
        if (person.getName() == null || person.getName().isEmpty())
            throw new IllegalStateException("Please enter a valid name");
        if (person.getEmail() == null || person.getEmail().isEmpty())
            throw new IllegalStateException("Please enter a valid email");

        repository.addNewPerson(person);
    }

    public List<Person> getPerson() {
        return repository.getPerson();
    }

    public void updatePerson(Person person) {
        if (!repository.existById(person.getPersonID()))
            throw new IllegalStateException("User ID: " +person.getPersonID()+ " not found");
        repository.updatePerson(person);
    }

    public void deletePerson(int id) {
        if (!repository.existById(id))
            throw new IllegalStateException("User ID: " +id+ " not found");
        repository.deletePerson(id);
    }


}

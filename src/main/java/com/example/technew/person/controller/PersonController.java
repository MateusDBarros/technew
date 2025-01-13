package com.example.technew.person.controller;

import com.example.technew.person.model.Person;
import com.example.technew.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addNewPerson(@RequestBody Person person) {
        service.addNewPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added sucessfully");
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> personList = service.getPerson();
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }

    @PutMapping("{personID}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody Person person) {
        person.setPersonID(id);
        service.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).body("User with ID: " +id+ " updated successfully");
    }

    @DeleteMapping("{personID}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        service.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("User with ID: " +id+ " was delete sucessufully");
    }

}

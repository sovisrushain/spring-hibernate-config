package com.hib.springhibernatedemo.controller;

import com.hib.springhibernatedemo.model.Person;
import com.hib.springhibernatedemo.model.Request;
import com.hib.springhibernatedemo.service.PersonService;
import com.hib.springhibernatedemo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Request request) {
        return new ResponseEntity<>(personService.savePerson(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }
}
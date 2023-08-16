package com.example.CRUD;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class PersonController {

    @Autowired
    PersonRepository people;

    @RequestMapping(value ="/people", method = RequestMethod.POST)
    ResponseEntity<Person> createPerson(@RequestBody Person p)
    {
        return new  ResponseEntity<Person>(people.save(p), HttpStatus.CREATED);
    } //This Works


    @RequestMapping(value ="/people/{id}", method = RequestMethod.GET)
    ResponseEntity<Person> getPerson(@PathVariable Long id)
    {
    return new  ResponseEntity<Person>(people.findById(id).get(), HttpStatus.OK);
    } //This Works



    @RequestMapping(value = "/people", method = RequestMethod.GET)
   ResponseEntity<List<Person>> getPersonList(){
        List<Person> personList = new ArrayList<>();
        people.findAll().forEach(personList::add);
        return new  ResponseEntity<List<Person>>(personList,HttpStatus.OK);
        //This Works
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    ResponseEntity<Person> updatePerson(@RequestBody Person p){
        return new ResponseEntity<>(people.save(p),HttpStatus.OK);
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    ResponseEntity<HttpStatus> deletePerson(@PathVariable Long id){
        people.deleteById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
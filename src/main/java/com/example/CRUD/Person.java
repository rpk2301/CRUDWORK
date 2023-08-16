package com.example.CRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String firstName;
    String lastName;



    public Person() {

    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Person(Long id, String firstName, String lastName) {
       this(firstName,lastName);
        this.id = id;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
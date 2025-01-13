package com.example.technew.person.model;

public class Person {

    private int personID;
    private String name;
    private String email;


    public Person() {
    }

    public Person(int personID, String name, String email) {
        this.personID = personID;
        this.name = name;
        this.email = email;
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}

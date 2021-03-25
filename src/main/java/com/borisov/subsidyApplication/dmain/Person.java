package com.borisov.subsidyApplication.dmain;

import java.time.LocalDate;

public abstract class Person {
    
    protected String surname; //фамилия
    protected String givenName; //собственное имя
    private String patronymic; //отчество
    private LocalDate dateOfBirth;
    private Address address;

    public Person() {
        System.out.println("Person is created");
    }    
    
    public String getPersonString() {
        return surname + " " + givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
    
}

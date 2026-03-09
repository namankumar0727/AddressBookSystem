package com.naman.addressbooksystem;

import java.util.Objects;

public class ContactPerson {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        ContactPerson person = (ContactPerson) obj;

        return firstName.equalsIgnoreCase(person.firstName) &&
               lastName.equalsIgnoreCase(person.lastName) &&
               city.equalsIgnoreCase(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, city);
    }

    @Override
    public String toString() {

        return "First Name: " + firstName +
                ", Last Name: " + lastName +
                ", City: " + city +
                ", State: " + state;
    }
}
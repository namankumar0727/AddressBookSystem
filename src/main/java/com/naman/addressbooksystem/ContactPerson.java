package com.naman.addressbooksystem;

import java.time.LocalDate;
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
    private LocalDate dateAdded;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phoneNumber, String email, LocalDate dateAdded) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateAdded = dateAdded;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public LocalDate getDateAdded() { return dateAdded; }

    // Setters
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    public void displayContact() {
        System.out.println(this);
    }

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
                ", Address: " + address +
                ", City: " + city +
                ", State: " + state +
                ", Zip: " + zip +
                ", Phone: " + phoneNumber +
                ", Email: " + email +
                ", Date Added: " + dateAdded;
    }
}
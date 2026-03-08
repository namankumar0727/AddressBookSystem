package com.naman.addressbooksystem;

public class ContactPerson {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    String phoneNumber;
    String email;

    public void displayContact() {
        System.out.println("\nContact Details:");
        System.out.println("-----------------------");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}
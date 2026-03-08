package com.naman.addressbooksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookSystemApplication.class, args);
	
		System.out.println("Welcome to Address Book Program");
		
		AddressBook addressBook = new AddressBook();

        ContactPerson person = addressBook.createContact();

        System.out.println("\nContact Created Successfully!");

        System.out.println(person.firstName + " " + person.lastName);
        System.out.println(person.address);
        System.out.println(person.city + ", " + person.state);
        System.out.println("Zip: " + person.zip);
        System.out.println("Phone: " + person.phoneNumber);
        System.out.println("Email: " + person.email);
		
	}

}

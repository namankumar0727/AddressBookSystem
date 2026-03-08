package com.naman.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();

    public void addContact() {

        Scanner scanner = new Scanner(System.in);

        ContactPerson person = new ContactPerson();

        System.out.println("Enter First Name:");
        person.firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        person.lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        person.address = scanner.nextLine();

        System.out.println("Enter City:");
        person.city = scanner.nextLine();

        System.out.println("Enter State:");
        person.state = scanner.nextLine();

        System.out.println("Enter Zip:");
        person.zip = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Phone Number:");
        person.phoneNumber = scanner.nextLine();

        System.out.println("Enter Email:");
        person.email = scanner.nextLine();

        contactList.add(person);

        System.out.println("\nContact Added Successfully!");
    }

    public void displayContacts() {

        for (ContactPerson person : contactList) {
            person.displayContact();
        }
    }
}
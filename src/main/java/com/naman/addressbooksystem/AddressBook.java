package com.naman.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

  //method to add contact 
    public void addContact() {

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
    //UC-3: Edit Contact 
    
    public void editContact() {

        System.out.println("Enter First Name of Contact to Edit:");
        String name = scanner.nextLine();

        for (ContactPerson person : contactList) {

            if (person.firstName.equalsIgnoreCase(name)) {

                System.out.println("Enter New Address:");
                person.address = scanner.nextLine();

                System.out.println("Enter New City:");
                person.city = scanner.nextLine();

                System.out.println("Enter New State:");
                person.state = scanner.nextLine();

                System.out.println("Enter New Zip:");
                person.zip = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter New Phone Number:");
                person.phoneNumber = scanner.nextLine();

                System.out.println("Enter New Email:");
                person.email = scanner.nextLine();

                System.out.println("Contact Updated Successfully!");
                return;
            }
        }

        System.out.println("Contact Not Found!");
    }
    //Method to delete contact 
    public void deleteContact() {

        System.out.println("Enter First Name of Contact to Delete:");
        String name = scanner.nextLine();

        for (ContactPerson person : contactList) {

            if (person.firstName.equalsIgnoreCase(name)) {
                contactList.remove(person);
                System.out.println("Contact Deleted Successfully!");
                return;
            }
        }

        System.out.println("Contact Not Found!");
    }

    
    //Method which display contacts 
    public void displayContacts() {

        for (ContactPerson person : contactList) {
            person.displayContact();
        }
    }
}
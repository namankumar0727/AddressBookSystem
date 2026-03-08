package com.naman.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson contact) {
        contactList.add(contact);
    }

    public void displayContacts() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        for(ContactPerson contact : contactList) {
            contact.displayContact();
            System.out.println("-------------------");
        }
    }

    public void editContact(String name) {

        Scanner sc = new Scanner(System.in);

        for(ContactPerson contact : contactList) {

            if(contact.firstName.equals(name)) {

                System.out.println("Enter new Address:");
                contact.address = sc.nextLine();

                System.out.println("Enter new City:");
                contact.city = sc.nextLine();

                System.out.println("Enter new State:");
                contact.state = sc.nextLine();

                System.out.println("Enter new Zip:");
                contact.zip = sc.nextLine();

                System.out.println("Enter new Phone:");
                contact.phoneNumber = sc.nextLine();

                System.out.println("Enter new Email:");
                contact.email = sc.nextLine();

                System.out.println("Contact updated successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }

    public void deleteContact(String name) {

        for(ContactPerson contact : contactList) {

            if(contact.firstName.equals(name)) {
                contactList.remove(contact);
                System.out.println("Contact deleted successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }
}
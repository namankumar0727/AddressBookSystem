package com.naman.addressbooksystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();


    public void addContact(ContactPerson contact) {

        // Duplicate Check using Java Streams
        boolean isDuplicate = contactList.stream()
                .anyMatch(existing -> existing.equals(contact));

        if(isDuplicate) {
            System.out.println("Duplicate Contact! Person already exists in this AddressBook.");
            return;
        }

        contactList.add(contact);
        System.out.println("Contact Added Successfully");
    }


    public void displayContacts() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        contactList.forEach(contact -> {
            contact.displayContact();
            System.out.println("----------------------");
        });
    }


    public void editContact(String name, Scanner sc) {

        for(ContactPerson contact : contactList) {

            if(contact.getFirstName().equalsIgnoreCase(name)) {

                System.out.println("Enter new Address:");
                contact.setAddress(sc.nextLine());

                System.out.println("Enter new City:");
                contact.setCity(sc.nextLine());

                System.out.println("Enter new State:");
                contact.setState(sc.nextLine());

                System.out.println("Enter new Zip:");
                contact.setZip(sc.nextLine());

                System.out.println("Enter new Phone:");
                contact.setPhoneNumber(sc.nextLine());

                System.out.println("Enter new Email:");
                contact.setEmail(sc.nextLine());

                System.out.println("Contact Updated Successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }


    public void deleteContact(String name) {

        Iterator<ContactPerson> iterator = contactList.iterator();

        while(iterator.hasNext()) {

            ContactPerson contact = iterator.next();

            if(contact.getFirstName().equalsIgnoreCase(name)) {

                iterator.remove();
                System.out.println("Contact Deleted Successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }
}
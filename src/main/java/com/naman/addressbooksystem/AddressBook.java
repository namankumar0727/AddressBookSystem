package com.naman.addressbooksystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson contact) {

        if(contactList.contains(contact)) {
            System.out.println("Duplicate contact found. Cannot add.");
            return;
        }

        contactList.add(contact);
        System.out.println("Contact added successfully");
    }

    public void displayContacts() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        for(ContactPerson contact : contactList) {

            contact.displayContact();
            System.out.println("---------------------");
        }
    }

    public void editContact(String firstName, String lastName, Scanner sc) {

        for(ContactPerson contact : contactList) {

            if(contact.getFirstName().equalsIgnoreCase(firstName) &&
               contact.getLastName().equalsIgnoreCase(lastName)) {

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

                System.out.println("Contact updated successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }

    public void deleteContact(String firstName, String lastName) {

        boolean removed = contactList.removeIf(contact ->
                contact.getFirstName().equalsIgnoreCase(firstName) &&
                contact.getLastName().equalsIgnoreCase(lastName));

        if(removed)
            System.out.println("Contact deleted successfully");
        else
            System.out.println("Contact not found");
    }

    public void searchByCity(String city) {

        boolean found = false;

        for(ContactPerson contact : contactList) {

            if(contact.getCity().equalsIgnoreCase(city)) {
                contact.displayContact();
                found = true;
            }
        }

        if(!found)
            System.out.println("No contacts found in this city");
    }

    public void searchByState(String state) {

        boolean found = false;

        for(ContactPerson contact : contactList) {

            if(contact.getState().equalsIgnoreCase(state)) {
                contact.displayContact();
                found = true;
            }
        }

        if(!found)
            System.out.println("No contacts found in this state");
    }
    public void sortContactsByName() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) ->
                        c1.getFirstName().compareToIgnoreCase(c2.getFirstName()))
                .forEach(System.out::println);
    }
 // Sort contacts by City
    public void sortContactsByCity() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getCity,
                        String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }
    public List<ContactPerson> getContacts() {
        return contactList;
    }
 // Sort contacts by State
    public void sortContactsByState() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getState,
                        String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }
 // Sort contacts by Zip
    public void sortContactsByZip() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getZip))
                .forEach(System.out::println);
    }
}
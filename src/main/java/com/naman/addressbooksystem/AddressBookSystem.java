package com.naman.addressbooksystem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {

    HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    // NEW: Dictionaries
    Map<String, List<ContactPerson>> cityDictionary = new HashMap<>();
    Map<String, List<ContactPerson>> stateDictionary = new HashMap<>();


    public void addAddressBook(String name) {

        if(addressBookMap.containsKey(name)) {
            System.out.println("AddressBook already exists");
            return;
        }

        addressBookMap.put(name, new AddressBook());
        System.out.println("AddressBook added successfully");
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    public void displayAddressBooks() {

        if(addressBookMap.isEmpty()) {
            System.out.println("No AddressBooks available");
            return;
        }

        addressBookMap.keySet()
                .forEach(book -> System.out.println("AddressBook: " + book));
    }


    // NEW METHOD
    public void addPersonToDictionary(ContactPerson person) {

        cityDictionary
                .computeIfAbsent(person.getCity(), k -> new ArrayList<>())
                .add(person);

        stateDictionary
                .computeIfAbsent(person.getState(), k -> new ArrayList<>())
                .add(person);
    }


    // NEW METHOD (Using Streams)
    public void viewPersonsByCity(String city) {

        List<ContactPerson> persons = cityDictionary
                .getOrDefault(city, new ArrayList<>())
                .stream()
                .collect(Collectors.toList());

        if(persons.isEmpty()) {
            System.out.println("No persons found in city: " + city);
            return;
        }

        persons.forEach(ContactPerson::displayContact);
    }


    // NEW METHOD (Using Streams)
    public void viewPersonsByState(String state) {

        List<ContactPerson> persons = stateDictionary
                .getOrDefault(state, new ArrayList<>())
                .stream()
                .collect(Collectors.toList());

        if(persons.isEmpty()) {
            System.out.println("No persons found in state: " + state);
            return;
        }

        persons.forEach(ContactPerson::displayContact);
    }
}
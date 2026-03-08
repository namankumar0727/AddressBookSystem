package com.naman.addressbooksystem;

import java.util.HashMap;

public class AddressBookSystem {

    HashMap<String, AddressBook> addressBookMap = new HashMap<>();

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

        addressBookMap.forEach((name, book) ->
                System.out.println("AddressBook: " + name));
    }
}
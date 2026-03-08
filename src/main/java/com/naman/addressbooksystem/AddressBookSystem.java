package com.naman.addressbooksystem;

import java.util.HashMap;

public class AddressBookSystem {

    HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    public void addAddressBook(String name) {

        AddressBook addressBook = new AddressBook();
        addressBookMap.put(name, addressBook);

        System.out.println("AddressBook Added Successfully");
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    public void displayAddressBooks() {

        if(addressBookMap.isEmpty()) {
            System.out.println("No AddressBooks Available");
            return;
        }

        for(String name : addressBookMap.keySet()) {
            System.out.println("AddressBook Name: " + name);
        }
    }
}
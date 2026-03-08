
package com.naman.addressbooksystem;

import java.util.HashMap;

public class AddressBookSystem {

    HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    public void addAddressBook(String name, AddressBook addressBook) {

        addressBookMap.put(name, addressBook);

        System.out.println("AddressBook added successfully");
    }

    public AddressBook getAddressBook(String name) {

        return addressBookMap.get(name);
    }

    public void displayAddressBooks() {

        for(String name : addressBookMap.keySet()) {

            System.out.println("AddressBook Name: " + name);
        }
    }
}

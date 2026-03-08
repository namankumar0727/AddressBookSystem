package com.naman.addressbooksystem;

public class AddressBookSystemApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		System.out.println("--------------------------------");
		
		AddressBook addressBook = new AddressBook();

        addressBook.addContact();
        
        addressBook.editContact();

        addressBook.displayContacts();
        
	}

}
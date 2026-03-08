package com.naman.addressbooksystem;

import java.util.Scanner;

public class AddressBookSystemApplication {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        System.out.println("--------------------------------");

        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nChoose");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addressBook.addContact();
                    break;

                case 2:
                    addressBook.displayContacts();
                    break;

                case 3:
                    System.out.println("Exiting Address Book...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
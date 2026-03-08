package com.naman.addressbooksystem;

import java.util.Scanner;

public class AddressBookSystemApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddressBookSystem system = new AddressBookSystem();

        while(true) {

            System.out.println("\n1. Add AddressBook");
            System.out.println("2. Display AddressBooks");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.println("Enter AddressBook Name:");

                    String name = sc.nextLine();

                    AddressBook addressBook = new AddressBook();

                    system.addAddressBook(name, addressBook);

                    break;

                case 2:

                    system.displayAddressBooks();

                    break;

                case 3:

                    System.out.println("Exiting...");

                    return;

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}
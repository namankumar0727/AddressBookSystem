package com.naman.addressbooksystem;

import java.util.Scanner;

public class AddressBookSystemApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while(true) {

            System.out.println("\n1. Add AddressBook");
            System.out.println("2. Display AddressBooks");
            System.out.println("3. Add Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Edit Contact");
            System.out.println("6. Delete Contact");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.println("Enter AddressBook Name:");
                    String name = sc.nextLine();
                    system.addAddressBook(name);
                    break;

                case 2:

                    system.displayAddressBooks();
                    break;

                case 3:

                    System.out.println("Enter AddressBook Name:");
                    String abName = sc.nextLine();

                    AddressBook ab = system.getAddressBook(abName);

                    if(ab == null) {
                        System.out.println("AddressBook not found");
                        break;
                    }

                    System.out.println("Enter First Name:");
                    String firstName = sc.nextLine();

                    System.out.println("Enter Last Name:");
                    String lastName = sc.nextLine();

                    System.out.println("Enter Address:");
                    String address = sc.nextLine();

                    System.out.println("Enter City:");
                    String city = sc.nextLine();

                    System.out.println("Enter State:");
                    String state = sc.nextLine();

                    System.out.println("Enter Zip:");
                    String zip = sc.nextLine();

                    System.out.println("Enter Phone:");
                    String phone = sc.nextLine();

                    System.out.println("Enter Email:");
                    String email = sc.nextLine();

                    ContactPerson contact = new ContactPerson(
                            firstName, lastName, address,
                            city, state, zip, phone, email
                    );

                    ab.addContact(contact);

                    break;

                case 4:

                    System.out.println("Enter AddressBook Name:");
                    String displayName = sc.nextLine();

                    AddressBook displayBook = system.getAddressBook(displayName);

                    if(displayBook != null)
                        displayBook.displayContacts();
                    else
                        System.out.println("AddressBook not found");

                    break;

                case 5:

                    System.out.println("Enter AddressBook Name:");
                    String editBookName = sc.nextLine();

                    AddressBook editBook = system.getAddressBook(editBookName);

                    if(editBook == null) {
                        System.out.println("AddressBook not found");
                        break;
                    }

                    System.out.println("Enter First Name to Edit:");
                    String editName = sc.nextLine();

                    editBook.editContact(editName, sc);

                    break;

                case 6:

                    System.out.println("Enter AddressBook Name:");
                    String deleteBookName = sc.nextLine();

                    AddressBook deleteBook = system.getAddressBook(deleteBookName);

                    if(deleteBook == null) {
                        System.out.println("AddressBook not found");
                        break;
                    }

                    System.out.println("Enter First Name to Delete:");
                    String deleteName = sc.nextLine();

                    deleteBook.deleteContact(deleteName);

                    break;

                case 7:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}
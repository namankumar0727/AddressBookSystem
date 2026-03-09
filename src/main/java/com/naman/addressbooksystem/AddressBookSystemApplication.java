package com.naman.addressbooksystem;

import java.util.Scanner;

public class AddressBookSystemApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while(true) {

            System.out.println("\n1 Add AddressBook");
            System.out.println("2 Display AddressBooks");
            System.out.println("3 Use AddressBook");
            System.out.println("4 Exit");

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
                    String bookName = sc.nextLine();

                    AddressBook book = system.getAddressBook(bookName);

                    if(book == null) {
                        System.out.println("AddressBook not found");
                        break;
                    }

                    manageContacts(book, sc);
                    break;

                case 4:

                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
            AddressBookService service = new AddressBookService();

            service.retrieveContactsFromDB()
                   .forEach(System.out::println);
        }
    }


    public static void manageContacts(AddressBook book, Scanner sc) {

        while(true) {

            System.out.println("\n1 Add Contact");
            System.out.println("2 Display Contacts");
            System.out.println("3 Edit Contact");
            System.out.println("4 Delete Contact");
            System.out.println("5 Sort Contacts by Name");
            System.out.println("6 Write Contacts to CSV");
            System.out.println("7 Read Contacts from CSV");
            System.out.println("6 Write Contacts to CSV");
            System.out.println("7 Read Contacts from CSV");
            System.out.println("8 Write Contacts to JSON");
            System.out.println("9 Read Contacts from JSON");
            System.out.println("10 Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.println("Enter First Name:");
                    String first = sc.nextLine();

                    System.out.println("Enter Last Name:");
                    String last = sc.nextLine();

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

                    ContactPerson contact =
                            new ContactPerson(first,last,address,city,state,zip,phone,email);

                    book.addContact(contact);
                    break;


                case 2:

                    book.displayContacts();
                    break;


                case 3:

                    System.out.println("Enter First Name:");
                    String editFirst = sc.nextLine();

                    System.out.println("Enter Last Name:");
                    String editLast = sc.nextLine();

                    book.editContact(editFirst, editLast, sc);
                    break;


                case 4:

                    System.out.println("Enter First Name:");
                    String delFirst = sc.nextLine();

                    System.out.println("Enter Last Name:");
                    String delLast = sc.nextLine();

                    book.deleteContact(delFirst, delLast);
                    break;


                case 5:

                    book.sortContactsByName();
                    break;


                case 6:

                    AddressBookCSVService.writeContactsToCSV(
                            book.getContacts(), "contacts.csv");

                    break;


                case 7:

                    AddressBookCSVService.readContactsFromCSV("contacts.csv");

                    break;

                case 8:

                    AddressBookJsonService.writeContactsToJson(
                            book.getContacts(), "contacts.json");

                    break;

                case 9:

                    AddressBookJsonService.readContactsFromJson("contacts.json");

                    break;

                case 10:
                    return;
                    
                    

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
package com.naman.addressbooksystem;

import java.io.*;
import java.util.List;

public class AddressBookFileIO {

    public static void writeContactsToFile(List<ContactPerson> contacts, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (ContactPerson contact : contacts) {

                writer.write(
                        contact.getFirstName() + "," +
                        contact.getLastName() + "," +
                        contact.getCity() + "," +
                        contact.getState()
                );

                writer.newLine();
            }

            System.out.println("Contacts successfully written to file.");

        } catch (IOException e) {

            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readContactsFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println(
                        "First Name: " + data[0] +
                        ", Last Name: " + data[1] +
                        ", City: " + data[2] +
                        ", State: " + data[3]
                );
            }

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
package com.naman.addressbooksystem;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AddressBookCSVService {

    public static void writeContactsToCSV(List<ContactPerson> contacts, String fileName) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {

            String[] header = {"FirstName","LastName","Address","City","State","Zip","Phone","Email"};
            writer.writeNext(header);

            for(ContactPerson contact : contacts) {

                String[] data = {
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhoneNumber(),
                        contact.getEmail()
                };

                writer.writeNext(data);
            }

            System.out.println("Contacts written to CSV successfully");

        } catch(Exception e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }


    public static void readContactsFromCSV(String fileName) {

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

            List<String[]> records = reader.readAll();

            for(String[] record : records) {

                System.out.println(
                        "First Name: " + record[0] +
                        ", Last Name: " + record[1] +
                        ", Address: " + record[2] +
                        ", City: " + record[3] +
                        ", State: " + record[4] +
                        ", Zip: " + record[5] +
                        ", Phone: " + record[6] +
                        ", Email: " + record[7]
                );
            }

        } catch(Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }
}
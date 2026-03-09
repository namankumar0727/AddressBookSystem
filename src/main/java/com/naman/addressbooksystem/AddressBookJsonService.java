
package com.naman.addressbooksystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class AddressBookJsonService {

    public static void writeContactsToJson(List<ContactPerson> contacts, String fileName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(fileName)) {

            gson.toJson(contacts, writer);

            System.out.println("Contacts written to JSON successfully");

        } catch (Exception e) {

            System.out.println("Error writing JSON: " + e.getMessage());
        }
    }


    public static void readContactsFromJson(String fileName) {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(fileName)) {

            Type contactListType = new TypeToken<List<ContactPerson>>(){}.getType();

            List<ContactPerson> contacts = gson.fromJson(reader, contactListType);

            if(contacts == null || contacts.isEmpty()) {
                System.out.println("No contacts found in JSON file");
                return;
            }

            contacts.forEach(System.out::println);

        } catch (Exception e) {

            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}
package com.naman.addressbooksystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {

    public List<ContactPerson> retrieveContactsFromDB() {

        List<ContactPerson> contacts = new ArrayList<>();

        String query = "SELECT * FROM contact_person";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery()) {

            while(rs.next()) {

                ContactPerson contact = new ContactPerson(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email")
                );

                contacts.add(contact);
            }

        } catch(Exception e) {

            System.out.println("Error retrieving contacts: " + e.getMessage());
        }

        return contacts;
    }

    public boolean updateContactCity(String firstName, String newCity) {

        String query = "UPDATE contact_person SET city=? WHERE first_name=?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, newCity);
            statement.setString(2, firstName);

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch(Exception e) {

            System.out.println("Error updating contact: " + e.getMessage());
        }

        return false;
    }


    public ContactPerson getContactByName(String firstName) {

        String query = "SELECT * FROM contact_person WHERE first_name=?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, firstName);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {

                return new ContactPerson(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
            }

        } catch(Exception e) {

            System.out.println("Error retrieving contact: " + e.getMessage());
        }

        return null;
    }
}
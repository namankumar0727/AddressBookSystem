package com.naman.addressbooksystem;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {

    // Existing methods remain unchanged...


    // UC20 - Add new contact to DB with transaction
    public boolean addContactToDatabase(ContactPerson contact) {

        String query = "INSERT INTO contact_person " +
                "(first_name, last_name, address, city, state, zip, phone, email, date_added) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {

            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, contact.getFirstName());
                statement.setString(2, contact.getLastName());
                statement.setString(3, contact.getAddress());
                statement.setString(4, contact.getCity());
                statement.setString(5, contact.getState());
                statement.setString(6, contact.getZip());
                statement.setString(7, contact.getPhoneNumber());
                statement.setString(8, contact.getEmail());
                statement.setDate(9, Date.valueOf(contact.getDateAdded()));

                statement.executeUpdate();

                connection.commit();

                return true;

            } catch (Exception e) {

                connection.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
            }

        } catch (Exception e) {

            System.out.println("Error inserting contact: " + e.getMessage());
        }

        return false;
    }
}
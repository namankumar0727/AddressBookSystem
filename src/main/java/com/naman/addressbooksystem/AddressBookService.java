package com.naman.addressbooksystem;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {

    // Retrieve all contacts from DB
    public List<ContactPerson> retrieveContactsFromDB() {

        List<ContactPerson> contacts = new ArrayList<>();

        String query = "SELECT * FROM contact_person";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery()) {

            while(rs.next()) {

                Date date = rs.getDate("date_added");
                LocalDate dateAdded = date != null ? date.toLocalDate() : null;

                ContactPerson contact = new ContactPerson(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        dateAdded
                );

                contacts.add(contact);
            }

        } catch(Exception e) {

            System.out.println("Error retrieving contacts: " + e.getMessage());
        }

        return contacts;
    }

    // Retrieve contacts between two dates
    public List<ContactPerson> getContactsByDateRange(String startDate, String endDate) {

        List<ContactPerson> contacts = new ArrayList<>();

        String query = "SELECT * FROM contact_person WHERE date_added BETWEEN ? AND ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                Date date = rs.getDate("date_added");
                LocalDate dateAdded = date != null ? date.toLocalDate() : null;

                ContactPerson contact = new ContactPerson(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        dateAdded
                );

                contacts.add(contact);
            }

        } catch(Exception e) {

            System.out.println("Error retrieving contacts by date range: " + e.getMessage());
        }

        return contacts;
    }

    // UC19: Count contacts by city using DB function COUNT()
    public int countContactsByCity(String city) {

        String query = "SELECT COUNT(*) FROM contact_person WHERE city = ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, city);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return rs.getInt(1);
            }

        } catch(Exception e) {

            System.out.println("Error counting contacts by city: " + e.getMessage());
        }

        return 0;
    }

    // UC19: Count contacts by state using DB function COUNT()
    public int countContactsByState(String state) {

        String query = "SELECT COUNT(*) FROM contact_person WHERE state = ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, state);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return rs.getInt(1);
            }

        } catch(Exception e) {

            System.out.println("Error counting contacts by state: " + e.getMessage());
        }

        return 0;
    }
}
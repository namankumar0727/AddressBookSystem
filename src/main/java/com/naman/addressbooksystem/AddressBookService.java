package com.naman.addressbooksystem;

import java.sql.*;
import java.time.LocalDate;
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
                        rs.getString("email"),
                        rs.getDate("date_added").toLocalDate()
                );

                contacts.add(contact);
            }

        } catch(Exception e) {

            System.out.println("Error retrieving contacts: " + e.getMessage());
        }

        return contacts;
    }


    public List<ContactPerson> getContactsByDateRange(String startDate, String endDate) {

        List<ContactPerson> contacts = new ArrayList<>();

        String query = "SELECT * FROM contact_person WHERE date_added BETWEEN ? AND ?";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                ContactPerson contact = new ContactPerson(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDate("date_added").toLocalDate()
                );

                contacts.add(contact);
            }

        } catch(Exception e) {

            System.out.println("Error retrieving contacts by date range: " + e.getMessage());
        }

        return contacts;
    }
}
package com.naman.addressbooksystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {

    AddressBookService service = new AddressBookService();

    // Test 1: Retrieve all contacts from DB
    @Test
    public void givenDatabase_WhenRetrieved_ShouldReturnContacts() {

        List<ContactPerson> contacts = service.retrieveContactsFromDB();

        Assertions.assertNotNull(contacts);
    }

    // Test 2: Retrieve contacts added within a date range
    @Test
    public void givenDateRange_WhenRetrieved_ShouldReturnContacts() {

        List<ContactPerson> contacts =
                service.getContactsByDateRange("2024-01-01","2025-12-31");

        Assertions.assertNotNull(contacts);
    }

    // Test 3: Count contacts by city using DB COUNT function
    @Test
    public void givenCity_WhenCounted_ShouldReturnContactCount() {

        int count = service.countContactsByCity("Bhopal");

        Assertions.assertTrue(count >= 0);
    }

    // Test 4: Count contacts by state using DB COUNT function
    @Test
    public void givenState_WhenCounted_ShouldReturnContactCount() {

        int count = service.countContactsByState("MP");

        Assertions.assertTrue(count >= 0);
    }

    // Test 5: Validate retrieved contact fields
    @Test
    public void givenDatabase_WhenRetrieved_ShouldContainValidContactData() {

        List<ContactPerson> contacts = service.retrieveContactsFromDB();

        if(!contacts.isEmpty()) {

            ContactPerson contact = contacts.get(0);

            Assertions.assertNotNull(contact.getFirstName());
            Assertions.assertNotNull(contact.getLastName());
        }
    }
}
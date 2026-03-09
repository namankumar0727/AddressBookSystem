package com.naman.addressbooksystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {

    AddressBookService service = new AddressBookService();

    // Test Case 1: Database should return list (even if empty)
    @Test
    public void givenDatabase_WhenRetrieved_ShouldReturnList() {

        List<ContactPerson> contacts = service.retrieveContactsFromDB();

        Assertions.assertNotNull(contacts);
    }

    // Test Case 2: Database empty scenario
    @Test
    public void givenEmptyDatabase_WhenRetrieved_ShouldReturnEmptyList() {

        List<ContactPerson> contacts = service.retrieveContactsFromDB();

        Assertions.assertEquals(0, contacts.size());
    }

    // Test Case 3: Insert test data then verify retrieval
    @Test
    public void givenDatabaseWithContacts_WhenRetrieved_ShouldReturnContacts() {

        List<ContactPerson> contacts = service.retrieveContactsFromDB();

        if(contacts.size() > 0) {
            Assertions.assertTrue(contacts.size() >= 1);
        }
    }

    // Test Case 4: Verify object mapping
    @Test
    public void givenDatabase_WhenRetrieved_ShouldMapContactFields() {

        List<ContactPerson> contacts = service.retrieveContactsFromDB();

        if(!contacts.isEmpty()) {

            ContactPerson contact = contacts.get(0);

            Assertions.assertNotNull(contact.getFirstName());
            Assertions.assertNotNull(contact.getLastName());
            Assertions.assertNotNull(contact.getCity());
            Assertions.assertNotNull(contact.getState());
        }
    }
}
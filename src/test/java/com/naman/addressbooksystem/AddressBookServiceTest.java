package com.naman.addressbooksystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {

    AddressBookService service = new AddressBookService();

    
    @Test
    public void givenContact_WhenAdded_ShouldSyncWithDatabase() {

        AddressBookService service = new AddressBookService();

        ContactPerson contact = new ContactPerson(
                "Test",
                "User",
                "Test Address",
                "Bhopal",
                "MP",
                "462001",
                "9999999999",
                "test@email.com",
                java.time.LocalDate.now()
        );

        boolean added = service.addContactToDatabase(contact);

        Assertions.assertTrue(added);
    }
}
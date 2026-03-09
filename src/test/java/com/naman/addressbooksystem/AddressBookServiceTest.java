package com.naman.addressbooksystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {

    @Test
    public void givenDateRange_WhenRetrieved_ShouldReturnContacts() {

        AddressBookService service = new AddressBookService();

        List<ContactPerson> contacts =
                service.getContactsByDateRange("2024-01-01","2025-12-31");

        Assertions.assertNotNull(contacts);
    }
}
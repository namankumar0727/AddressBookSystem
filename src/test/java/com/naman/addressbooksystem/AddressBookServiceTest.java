package com.naman.addressbooksystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookServiceTest {

    @Test
    public void givenContact_WhenUpdated_ShouldSyncWithDB() {

        AddressBookService service = new AddressBookService();

        String name = "Naman";
        String newCity = "Delhi";

        boolean updated = service.updateContactCity(name, newCity);

        Assertions.assertTrue(updated);

        ContactPerson contactFromDB = service.getContactByName(name);

        Assertions.assertEquals(newCity, contactFromDB.getCity());
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("2", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);

        assertTrue(contactService.contactTable.contains(contact));
        assertTrue(contactService.contactTable.get(contact.getId()).getId().equals("2"));
        assertTrue(contactService.contactTable.get(contact.getId()).getFirstName().equals("Tony"));
        assertTrue(contactService.contactTable.get(contact.getId()).getLastName().equals("Stark"));
        assertTrue(contactService.contactTable.get(contact.getId()).getPhone().equals("1234567"));
        assertTrue(contactService.contactTable.get(contact.getId()).getAddress().equals("111 Secret Hideout"));

    }

    @Test
    void testContactDeletedFromHashTable() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("3", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        contactService.deleteContact(contact.getId());
        assertTrue(!contactService.contactTable.contains(contact));
    }

    @Test
    void testUpdateFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("4", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertTrue(contactService.contactTable.get(contact.getId()).getFirstName().equals("Tony"));
        contactService.updateContactFirstName("4", "Anthony");
        assertTrue(contactService.contactTable.get(contact.getId()).getFirstName().equals("Anthony"));
    }

    @Test
    void testIfFirstNameTooLongWhenUpdating() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("8", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName("8", "Tony-Iron-Man");;
        });
    }

    @Test
    void testUpdateLastName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("5", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertTrue(contactService.contactTable.get(contact.getId()).getLastName().equals("Stark"));
        contactService.updateContactLastName("5", "Iron_Man");
        assertTrue(contactService.contactTable.get(contact.getId()).getLastName().equals("Iron_Man"));
    }

    @Test
    void testIfLastNameTooLongWhenUpdating() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("9", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactLastName("9", "Iron-Man-Stark-Dude");;
        });
    }

    @Test
    void testUpdatePhone() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("6", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertTrue(contactService.contactTable.get(contact.getId()).getPhone().equals("1234567"));
        contactService.updateContactPhone("6", "911");
        assertTrue(contactService.contactTable.get(contact.getId()).getPhone().equals("911"));
    }

    @Test
    void testIfPhoneTooLongWhenUpdating() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("10", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactPhone("10", "123456789013");;
        });
    }

    @Test
    void testUpdateAddress() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("7", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertTrue(contactService.contactTable.get(contact.getId()).getAddress().equals("111 Secret Hideout"));
        contactService.updateContactAddress("7", "117 Secret Hideout");
        assertTrue(contactService.contactTable.get(contact.getId()).getAddress().equals("117 Secret Hideout"));
    }

    @Test
    void testIfAddressTooLongWhenUpdating() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("11", "Tony", "Stark", "1234567", "111 Secret Hideout");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactAddress("11", "111 Secret Hideout 111 Secret Hideout 111 Secret Hideout");;
        });
    }



}
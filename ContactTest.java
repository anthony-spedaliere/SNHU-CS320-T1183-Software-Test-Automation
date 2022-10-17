import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testIfFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony The Iron Man", "Stark", "1234567", "111 Secret Hideout");
        });
    }

    @Test
    void testIfLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony", "Stark The Iron Man", "1234567", "111 Secret Hideout");
        });
    }

    @Test
    void testIfPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony", "Stark", "12345678901112", "111 Secret Hideout");
        });
    }

    @Test
    void testIfAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony", "Stark", "1234567", "111 Secret Hideout 111 Secret Hideout 111 Secret Hideout 111 Secret Hideout 111 Secret Hideout");
        });
    }

    @Test
    void testIfFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Stark", "1234567", "111 Secret Hideout");
        });
    }

    @Test
    void testIfLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony", null, "1234567", "111 Secret Hideout");
        });
    }

    @Test
    void testIfPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony", "Stark", null, "111 Secret Hideout");
        });
    }

    @Test
    void testIfAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Tony", "Stark", "1234567", null);
        });
    }

    @Test
    void testIdUnique() {
        Contact tony = new Contact("1", "Tony", "Stark", "1234567", "111 Secret Hideout");
        assertThrows(IllegalArgumentException.class, () -> {
            Contact peter = new Contact("1", "Peter", "Parker", "1234567", "111 Secret Hideout");
        });
    }


}
import java.util.Hashtable;

public class ContactService {

    // Table to hold the contact objects
    static Hashtable<String, Contact> contactTable = new Hashtable<>();

    public void addContact(Contact contact) {
        String id = contact.getId();

        // check if id exists in hashtable
        if(contactTable.get(id) != null) {
            System.out.println("The id is already in use. Please use a different id.");
        } else {
            contactTable.put(id, contact);
        }
    }

    public void deleteContact(String id) {

        // check if id exists in hashtable
        if(contactTable.get(id) != null) {
            contactTable.remove(id);
        } else {
            System.out.println("Id does not exist.");
        }
    }

    public void updateContactFirstName(String id, String firstName) {
        Contact contact = contactTable.get(id);

        // validate new last name
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name.");
        }

        // check if id exists in hashtable
        if(contactTable.get(id) != null) {
            contact.setFirstName(firstName);
        } else {
            System.out.println("Id does not exist.");
        }
    }

    public void updateContactLastName(String id, String lastName) {
        Contact contact = contactTable.get(id);

        // validate new last name
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name.");
        }

        // check if id exists in hashtable
        if(contactTable.get(id) != null) {
            contact.setLastName(lastName);
        } else {
            System.out.println("Id does not exist.");
        }
    }

    public void updateContactPhone(String id, String phone) {
        Contact contact = contactTable.get(id);

        // validate new last name
        if(phone == null || phone.length() > 10) {
            throw new IllegalArgumentException("Invalid phone.");
        }

        // check if id exists in hashtable
        if(contactTable.get(id) != null) {
            contact.setPhone(phone);
        } else {
            System.out.println("Id does not exist.");
        }
    }

    public void updateContactAddress(String id, String address) {
        Contact contact = contactTable.get(id);

        // validate new last name
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address.");
        }

        // check if id exists in hashtable
        if(contactTable.get(id) != null) {
            contact.setAddress(address);
        } else {
            System.out.println("Id does not exist.");
        }
    }
}

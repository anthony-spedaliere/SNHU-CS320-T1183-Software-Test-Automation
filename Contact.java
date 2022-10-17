import java.util.HashSet;
import java.util.Set;

public class Contact {

    // class fields
    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    // hash set to hold unique id's
    private static Set<String> uniqueIds = new HashSet<String>();

    Contact(String id, String firstName, String lastName, String phone, String address) {

            // validate parameters
            if(id == null || id.length() > 10 || uniqueIds.contains(id)) {
                throw new IllegalArgumentException("Invalid id");
            }

            if(firstName == null || firstName.length() > 10) {
                throw new IllegalArgumentException("Invalid first name.");
            }

            if(lastName == null || lastName.length() > 10) {
                throw new IllegalArgumentException("Invalid last name.");
            }

            if(phone == null || phone.length() > 10) {
                throw new IllegalArgumentException("Invalid phone.");
            }

            if(address == null || address.length() > 30) {
                throw new IllegalArgumentException("Invalid address.");
            }

            // initialize fields
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
            this.id = id;
            uniqueIds.add(id);
    }

    // getters and setters for class fields
    public String getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

}

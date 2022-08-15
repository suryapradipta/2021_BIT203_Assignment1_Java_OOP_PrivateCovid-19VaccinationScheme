/**
 * Administrator concrete subclass of User
 * defines a simple object type that represents a Healthcare Administrator.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public class Administrator extends User {
    private String staffID;

    /**
     * The default constructor used to initialise the default value.
     */
    public Administrator() {
        this("unknown", "unknown", "unknown", "unknown", "unknown");
    }

    /**
     * A constructor with five argument,
     * which is used to initialise super attribute
     * and Administrator object.
     * @param username accept and initialize new value to username.
     * @param password accept and initialize new value to password.
     * @param email accept and initialize new value to email.
     * @param fullName accept and initialize new value to fullName.
     * @param staffID accept and initialize new value to staffID.
     */
    public Administrator(String username, String password, String email, String fullName, String staffID) {
        super(username, password, email, fullName);
        this.staffID = staffID;
    }

    /**
     * The getStaffID getter method, which is used to get
     * the staff ID of Administrator object.
     * @return a String staff ID value of Administrator object.
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * The setStaffID setter method, which is used to set a new value staff ID attribute.
     * @param staffID to assign a parameter value to the staff ID attribute.
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the Administrator object.
     * @return String detail information of the Administrator object.
     */
    @Override
    public String toString() {
        return super.toString() +
            "\nStaff ID: " + staffID;
    }
}
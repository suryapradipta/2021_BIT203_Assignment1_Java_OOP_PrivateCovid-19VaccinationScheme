package BIT203.Assignment1;

/**
 * User is abstract class
 * defines a simple object type that represents a User
 * and superclass of Patient and Administrator class.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public abstract class User {
    private String username;
    private String password;
    private String email;
    private String fullName;

    /**
     * A constructor with four argument,
     * which is used to initialise User attribute for derived class.
     * @param username initialize username of User.
     * @param password initialize password of User.
     * @param email initialize email of User.
     * @param fullName initialize full name of User.
     */
    public User(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     * The getUsername getter method, which is used to get
     * the username of Derived object.
     * @return a String value of username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * The getPassword getter method, which is used to get
     * the password of Derived object.
     * @return a String value of username.
     */
    public String getPassword() {
        return password;
    }

    /**
     * The getEmail getter method, which is used to get
     * the email of Derived object.
     * @return a String value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * The getFullName getter method, which is used to get
     * the fullName of Derived object.
     * @return a String value of fullName.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * The setUsername setter method, which is used to
     * assign new value to username attribute.
     * @param username to assign a parameter value to the username attribute.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * The setPassword setter method, which is used to
     * assign new value to password attribute.
     * @param password to assign a parameter value to the password attribute.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The setEmail setter method, which is used to
     * assign new value to email attribute.
     * @param email to assign a parameter value to the email attribute.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The setFullName setter method, which is used to
     * assign new value to fullName attribute.
     * @param fullName to assign a parameter value to the fullName attribute.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the User for derived class.
     * @return String detail information of the User.
     */
    @Override
    public String toString() {
        return "User information:" +
            "\nUsername: " + username +
            "\nPassword: " + password +
            "\nEmail: " + email +
            "\nFull name: " + fullName;
    }
}

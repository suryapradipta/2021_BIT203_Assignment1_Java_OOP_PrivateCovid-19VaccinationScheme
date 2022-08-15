import java.util.ArrayList;

/**
 * Patient concrete subclass of User
 * defines a simple object type that represents a Patient.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public class Patient extends User{
    private String ICPassport;
    // ArrayList to hold collection of Vaccination
    private final ArrayList<Vaccination> vaccinations;

    /**
     * The default constructor used to initialise the default value.
     */
    public Patient() {
        this("unknown", "unknown", "unknown", "unknown", "unknown");
    }

    /**
     * A constructor with five argument,
     * which is used to initialise super attribute
     * and Administrator object.
     * @param username accept and initialize username of Patient.
     * @param password accept and initialize password of Patient.
     * @param email accept and initialize email of Patient.
     * @param fullName accept and initialize full name of Patient.
     * @param ICPassport accept and initialize ICPassport of Patient.
     */
    public Patient(String username, String password, String email, String fullName, String ICPassport) {
        super(username, password, email, fullName);
        this.ICPassport = ICPassport;
        // Instantiate a new ArrayList object of vaccinations
        this.vaccinations = new ArrayList<>();
    }

    /**
     * The getICPassport getter method, which is used to get
     * the IC or Passport of Patient object
     * @return a String value of ICPassport.
     */
    public String getICPassport() {
        return ICPassport;
    }

    /**
     * The getVaccinations getter method, which is used to get
     * the vaccination object in the collection.
     * @return an Object of vaccination.
     */
    public ArrayList<Vaccination> getVaccinations() {
        return vaccinations;
    }

    /**
     * The setVaccinations setter method, which is used to
     * add a new object to Vaccination collection.
     * @param newVaccinations to assign a parameter value to the vaccination object.
     */
    public void setVaccinations(Vaccination newVaccinations) {
        this.vaccinations.add(newVaccinations);
    }

    /**
     * The setICPassport setter method, which is used to
     * assign new value to ICPassport attribute.
     * @param ICPassport to assign a parameter value to the ICPassport attribute.
     */
    public void setICPassport(String ICPassport) {
        this.ICPassport = ICPassport;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the Patient object.
     * @return String detail information of the Patient object.
     */
    @Override
    public String toString() {
        return super.toString() +
            "\nIC Passport: " + ICPassport;
    }
}

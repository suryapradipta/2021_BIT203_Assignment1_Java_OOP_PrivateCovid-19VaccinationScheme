package BIT203.Assignment1;

import java.util.ArrayList;

/**
 * Vaccine class defines a simple object type that represents a Vaccine.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public class Vaccine {
    private String vaccineID;
    private String manufacturer;
    private String vaccineName;
    // ArrayList to hold collection of Batch
    private final ArrayList<Batch> batches;
    /**
     * The default constructor used to initialise the default value.
     */
    public Vaccine() {
        this("unknown", "unknown", "unknown");
    }

    /**
     * A constructor with three argument,
     * which is used to initialise attribute of Vaccine object.
     * @param vaccineID accept and initialize new value to vaccineID.
     * @param manufacturer accept and initialize new value to manufacturer.
     * @param vaccineName accept and initialize new value to vaccineName.
     */
    public Vaccine(String vaccineID, String manufacturer, String vaccineName) {
        this.vaccineID = vaccineID;
        this.manufacturer = manufacturer;
        this.vaccineName = vaccineName;
        // Instantiate a new ArrayList object of administrators and batches
        this.batches = new ArrayList<>();
    }

    /**
     * The getBatches getter method, which is used to get
     * the Batch object in the collection.
     * @return an Object of Batch.
     */
    public ArrayList<Batch> getBatches() {
        return batches;
    }

    /**
     * The setBatches setter method, which is used to
     * add a new object to Batch collection.
     * @param inBatch to assign a parameter value to the Batch object.
     */
    public void setBatch(Batch inBatch) {
        this.batches.add(inBatch);
    }

    /**
     * The getVaccineID getter method, which is used to get
     * the vaccineID of Vaccine object
     * @return a String value of vaccineID.
     */
    public String getVaccineID() {
        return vaccineID;
    }

    /**
     * The getManufacturer getter method, which is used to get
     * the manufacturer of Vaccine object
     * @return a String value of manufacturer.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * The getVaccineName getter method, which is used to get
     * the vaccineName of Vaccine object
     * @return a String value of vaccineName.
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * The setVaccineID setter method, which is used to
     * assign new value to vaccineID attribute.
     * @param vaccineID to assign a parameter value to the vaccineID attribute.
     */
    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    /**
     * The setManufacturer setter method, which is used to
     * assign new value to manufacturer attribute.
     * @param manufacturer to assign a parameter value to the manufacturer attribute.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * The setVaccineName setter method, which is used to
     * assign new value to vaccineName attribute.
     * @param vaccineName to assign a parameter value to the vaccineName attribute.
     */
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the Vaccine object.
     * @return String detail information of the Vaccine object.
     */
    @Override
    public String toString() {
        return vaccineName + " vaccine, developed by " + manufacturer;
    }
}



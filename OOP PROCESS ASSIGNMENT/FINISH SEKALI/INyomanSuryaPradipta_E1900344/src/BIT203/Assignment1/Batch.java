package BIT203.Assignment1;

import java.util.ArrayList;

/**
 * Batch class defines a simple object type that represents a Batch.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public class Batch {
    private int batchNo;
    private String expiryDate;
    private int quantityAvailable;
    private int quantityAdministered;
    // ArrayList to hold collection of Vaccination
    private final ArrayList<Vaccination> vaccinations;

    /**
     * The default constructor used to initialise the default value.
     */
    public Batch() {
        this(0,"",0,0);
    }

    /**
     * A constructor with four argument,
     * which is used to initialise attribute of Batch object.
     * @param batchNo accept and initialize new value to batchNo.
     * @param expiryDate accept and initialize new value to expiryDate.
     * @param quantityAvailable accept and initialize new value to quantityAvailable.
     * @param quantityAdministered accept and initialize new value to quantityAdministered.
     */
    public Batch(int batchNo, String expiryDate, int quantityAvailable, int quantityAdministered) {
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.quantityAvailable = quantityAvailable;
        this.quantityAdministered = quantityAdministered;
        // Instantiate a new ArrayList object of vaccinations
        this.vaccinations = new ArrayList<>();
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
     * The getBatchNo getter method, which is used to get
     * the batch number of Batch object
     * @return an int value of batch number.
     */
    public int getBatchNo() {
        return batchNo;
    }

    /**
     * The getExpiryDate getter method, which is used to get
     * the expiry date of Batch object
     * @return a String value of expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * The getQuantityAvailable getter method, which is used to get
     * the quantity available of Batch object
     * @return an int value of quantity available.
     */
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    /**
     * The getQuantityAdministered getter method, which is used to get
     * the quantity administered of Batch object
     * @return an int value of quantity administered.
     */
    public int getQuantityAdministered() {
        return quantityAdministered;
    }

    /**
     * The setBatchNo setter method, which is used to
     * assign new value to batchNo attribute.
     * @param batchNo to assign a parameter value to the batchNo attribute.
     */
    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * The setExpiryDate setter method, which is used to
     * assign new value to expiryDate attribute.
     * @param expiryDate to assign a parameter value to the expiryDate attribute.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * The setQuantityAvailable setter method, which is used to
     * assign new value to quantityAvailable attribute.
     * @param quantityAvailable to assign a parameter value to the quantityAvailable attribute.
     */
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * The setQuantityAdministered setter method, which is used to
     * assign new value to quantityAdministered attribute.
     * @param quantityAdministered to assign a parameter value to the quantityAdministered attribute.
     */
    public void setQuantityAdministered(int quantityAdministered) {
        this.quantityAdministered = quantityAdministered;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the Batch object.
     * @return String detail information of the Batch object.
     */
    @Override
    public String toString() {
        return "Batch information:" +
            "\nBatch number: " + batchNo +
            "\nExpiry date: " + expiryDate +
            "\nQuantity available: " + quantityAvailable + "\n";
    }
}

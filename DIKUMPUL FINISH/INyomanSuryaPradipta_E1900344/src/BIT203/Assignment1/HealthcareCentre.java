package BIT203.Assignment1;

import java.io.*;
import java.util.ArrayList;

/**
 * HealthcareCentre class defines a simple object type that represents a HealthcareCentre.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public class HealthcareCentre implements Serializable {
    private String centreName;
    private String address;
    // ArrayList to hold collection of Administrator and Batch
    private final ArrayList<Administrator> administrators;
    private final ArrayList<Batch> batches;

    /**
     * A constructor with two argument,
     * which is used to initialise HealthcareCentre object.
     * @param centreName accept and initialize new value to centreName.
     * @param address accept and initialize new value to address.
     */
    public HealthcareCentre(String centreName, String address) {
        this.centreName = centreName;
        this.address = address;
        // Instantiate a new ArrayList object of administrators and batches
        this.administrators = new ArrayList<>();
        this.batches = new ArrayList<>();
    }

    /**
     * The getAdministrators getter method, which is used to get
     * the Administrator object in the collection.
     * @return an Object of Administrator.
     */
    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    /**
     * The setAdministrator setter method, which is used to
     * add a new object to Administrator collection.
     * @param inAdmin to assign a parameter value to the Administrator object.
     */
    public void setAdministrator(Administrator inAdmin) {
        this.administrators.add(inAdmin);
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
    public void setBatches(Batch inBatch) {
        this.batches.add(inBatch);
    }

    /**
     * The getCentreName getter method, which is used to get
     * the centreName of HealthcareCentre object
     * @return a String value of centreName.
     */
    public String getCentreName() {
        return centreName;
    }

    /**
     * The getAddress getter method, which is used to get
     * the address of HealthcareCentre object
     * @return a String value of address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * The setCentreName setter method, which is used to
     * assign new value to centreName attribute.
     * @param centreName to assign a parameter value to the centreName attribute.
     */
    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    /**
     * The setAddress setter method, which is used to
     * assign new value to address attribute.
     * @param address to assign a parameter value to the address attribute.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the HealthcareCentre object.
     * @return String detail information of the HealthcareCentre object.
     */
    @Override
    public String toString() {
        return centreName + " is located at " + address;
    }

    // writing serializable objects instead of characters
//    public static boolean writeHealthcareCentreObjects(ArrayList<HealthcareCentre> healthcareCentreArrayList, String fileName) {
//        FileOutputStream fos = null;
//        try {
//            // assume file will be overwritten
//            fos = new FileOutputStream(fileName);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//
//            for (HealthcareCentre hc : healthcareCentreArrayList) {
//                oos.writeObject(hc);
//            }
//            oos.flush(); // throws IOException
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    // a method to read objects from a file
//    public static ArrayList<HealthcareCentre> readHealthcareCentreObjects(String filename) {
//        ArrayList<HealthcareCentre> healthcareCentreArrayList = new ArrayList<HealthcareCentre>();
//
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(filename);
//            ois = new ObjectInputStream(fis);
//            HealthcareCentre healthcareCentre = null;
//            do {
//                try {
//                    healthcareCentre = (HealthcareCentre) ois.readObject();
//                    if (healthcareCentre != null)
//                        healthcareCentreArrayList.add(healthcareCentre);
//                } catch (Exception e)      // wrong object, or end of file
//                {
//                    healthcareCentre = null;        // set item to null
//                }
//            } while (healthcareCentre != null);
//        } // end of try, catch exceptions as usual
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return healthcareCentreArrayList;
//    }
}


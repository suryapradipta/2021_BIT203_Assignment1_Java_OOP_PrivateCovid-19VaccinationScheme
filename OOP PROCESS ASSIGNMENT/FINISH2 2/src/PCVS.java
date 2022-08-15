/**
 * The PCVS class defines an object which is
 *  * the container of the Room object.
 *  Private Covid-19 Vaccination Scheme
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

public class PCVS {
    // ArrayList to hold collection of HealthcareCentre, User, and Vaccine
    private final ArrayList<HealthcareCentre> PCVSHealthcareCentres;
    private final ArrayList<User> PCVSUsers;
    private final ArrayList<Vaccine> PCVSVaccines;


    public PCVS() {
        // Instantiate a new ArrayList object
        PCVSUsers = new ArrayList<>();
        PCVSVaccines = new ArrayList<>();
        PCVSHealthcareCentres = new ArrayList<>();

        // Add two valid hard-coded Healthcare Centre values
        PCVSHealthcareCentres.add(new HealthcareCentre("Balimed Hospital", "Jl. Mahendradatta No.57 X"));
        PCVSHealthcareCentres.add(new HealthcareCentre( "Prima Medika Hospital", "Jl. Raya Sesetan No.10"));

        // Add two valid hard-coded Vaccine values
        PCVSVaccines.add(new Vaccine("JNJ", "Janssen Pharmaceutical Companies", "Johnson & Johnson"));
        PCVSVaccines.add(new Vaccine("ASZ", "AstraZeneca, University of Oxford", "AstraZeneca"));
    }


    /**
     * The ArrayList<User> getter method,
     * which is used to get User collection objects.
     * @return an Object of User collection.
     */
    public ArrayList<User> getPCVSUsers() {
        return PCVSUsers;
    }

    /**
     * The ArrayList<HealthcareCentre> getter method,
     * which is used to get Healthcare Centre collection objects.
     * @return an Object of Healthcare Centre collection.
     */
    public ArrayList<HealthcareCentre> getPCVSHealthcareCentres() {
        return PCVSHealthcareCentres;
    }

    /**
     * The ArrayList<Vaccine> getter method,
     * which is used to get Vaccine collection objects.
     * @return an Object of Vaccine collection.
     */
    public ArrayList<Vaccine> getPCVSVaccines() {
        return PCVSVaccines;
    }

    /**
     * The addUser setter method,
     * which is used to add new object user to User collection
     * @param newUser to assign the parameter value
     *                in the add() method from ArrayList.
     */
    public void addUser(User newUser)
    {
        PCVSUsers.add(newUser);
    }


    /**
     * The getAllCentreName service method,
     * which is used to traverse the Healthcare Centre collection
     * and get all the centre names.
     * @return a String centre names of Healthcare Centre collection.
     */
    public String getAllCentreName() {
        return range(0, getPCVSHealthcareCentres().size())
            .mapToObj(i -> (i + 1) + ". " + getPCVSHealthcareCentres().get(i).getCentreName() + "\n")
            .collect(joining());
    }

    /**
     * The userNameValidation service method,
     * which is used to compare username from User collection.
     * @param username attribute to compare.
     * @return boolean value true for equal, false for not equal.
     */
    public boolean userNameValidation(String username) {
        return range(0, getPCVSUsers().size())
            .anyMatch(i -> getPCVSUsers().get(i).getUsername().equalsIgnoreCase(username));

        /* REAL
        for (int i = 0; i < getPCVSUsers().size(); i++)
            if (getPCVSUsers().get(i).getUsername().equalsIgnoreCase(username))
                return true;
        return false;
        * */
    }

    /**
     * The validationAdminLogin service method,
     * which is used to compare the username and password entered
     * with the object Administrator in the HealthcareCentre collection.
     * @param username first attribute to compare.
     * @param password second attribute to compare.
     * @return an int index of HealthcareCentre object.
     */
    public int validationAdminLogin(String username, String password)
    {
        // Traverse HealthcareCentre collection
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) {
            // Save all index of HealthcareCentre object to temporary variable
            HealthcareCentre tempHC = getPCVSHealthcareCentres().get(i);
            // Traverse Administrator collection from temporary HealthcareCentre
            for(int j =0; j < tempHC.getAdministrators().size(); j++) {
                // Compare username
                if (tempHC.getAdministrators().get(j).getUsername().equals(username))
                    // Compare password
                    if(tempHC.getAdministrators().get(j).getPassword().equals(password))
                        // Get index of Healthcare Centre object
                        return i;
            }
        }
        // Cannot find HealthcareCentre object
        return -1;
    }

    /**
     * The getAllVaccinesID service method,
     * which is used to get all vaccine ID from Vaccine collection
     * @return String vaccine ID of vaccine collection.
     */
    public String getAllVaccinesID() {
        return range(0, getPCVSVaccines().size())
            .mapToObj(i -> (i + 1) + ". " + getPCVSVaccines().get(i).getVaccineID() + "\n")
            .collect(joining());
    }

    /**
     * The validationPatientLogin service method,
     * which is used to compare the username and password entered
     * with the object Patient in the User collection.
     * @param username first attribute to compare.
     * @param password second attribute to compare.
     * @return an int index of Patient object.
     */
    public int validationPatientLogin(String username, String password) {
        // Traverse the User collection
        for (int i = 0; i < getPCVSUsers().size(); i++) {
            // Downcast User collection to Patient object
            if (getPCVSUsers().get(i) instanceof Patient patient) {
                // Compare username
                if(patient.getUsername().equals(username))
                    // Compare password
                    if(patient.getPassword().equals(password))
                        // Get index of Patient object
                        return i;
            }
        }
        // Cannot find Patient object
        return -1;
    }

    /**
     * The getAllVaccines service method,
     * which is used to get all vaccine object from Vaccine collection
     * @return String value vaccine objet .toString() from vaccine collection.
     */
    public String getAllVaccines() {
        // Traverse Vaccine collection
        return range(0, getPCVSVaccines().size())
            // Get all Vaccine object in the collection
            .mapToObj(i -> (i + 1) + ". " + getPCVSVaccines().get(i) + "\n")
            .collect(joining());
    }

    /**
     * The equalsBatch service method,
     * which is used to compare the Batch object in HealthcareCentre collection
     * to the Batch object in the Vaccine collection
     * to get HealthcareCentre that offering vaccines.
     * @param batch object to compare.
     * @return an int value of index from HealthcareCentre object.
     */
    public int equalsBatch(Batch batch) {
        return range(0, getPCVSHealthcareCentres().size())
            .filter(i -> range(0, getPCVSHealthcareCentres().get(i).getBatches().size())
                .anyMatch(j -> getPCVSHealthcareCentres().get(i)
                    .getBatches().get(j).equals(batch)))
            .findFirst().orElse(-1);

        /* ASLI
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) {
            HealthcareCentre tempHC = getPCVSHealthcareCentres().get(i);
            for (int j = 0; j < tempHC.getBatches().size(); j++) {
                if (tempHC.getBatches().get(j).equals(batch))
                    return i;
            }
        }
        */
    }

    /**
     * The splitToArray service method,
     * which is used to split expiry date attribute from Batch object
     * @param str String to split to array.
     * @return an array value of split String
     */
    public static int[] splitToArray(String str) {
        String[] splitArray = str.split(" ");
        return Arrays.stream(splitArray).mapToInt(Integer::parseInt).toArray();

        /*ASLI
        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
        */
    }

    /**
     * The findBatch service method,
     * which is used to compare Batch from HealthcareCentre and Vaccine collection.
     * Validation the quantity available and the expiry date in a real time.
     * @param indexHC the index HealthCareCentre from user to compare
     * @param indexVC the index Vaccine from user to compare
     * @return a String of Batch object from Vaccine collection
     */
    public String findBatch(int indexHC, int indexVC) {
        StringBuilder all = new StringBuilder();
        // Get HealthcareCentre object from collection by index input user
        HealthcareCentre tempHC = getPCVSHealthcareCentres().get(indexHC-1);
        // Get Vaccine object from collection by index input user
        Vaccine tempVaccine = getPCVSVaccines().get(indexVC-1);

        // Traverse Batch object in HealthcareCentre collection
        for (int i = 0; i < tempHC.getBatches().size(); i++) {
            // Get the expiryDate attribute from Batch object
            // and split from String to array
            int[] splitExpiryDate = splitToArray(tempHC.getBatches().get(i).getExpiryDate());
            // Real time
            Calendar today = Calendar.getInstance();
            Calendar expires = Calendar.getInstance();
            // Set expires by expiry date attribute
            expires.set(splitExpiryDate[2], splitExpiryDate[0], splitExpiryDate[1]);

            // Traverse Batch object in Vaccine collection
            for(int j = 0; j < tempVaccine.getBatches().size(); j++) {
                // Compare Batch from HealthcareCentre and Vaccine
                if (tempHC.getBatches().get(i).equals(tempVaccine.getBatches().get(j)) &&
                    tempHC.getBatches().get(i).getQuantityAvailable() > 0 &&
                    !today.after(expires)) {
                    all.append("" + "\n").append(tempVaccine.getBatches().get(j));
                }
            }
        }
        return all.toString();
    }

    /**
     * The findBatch service method,
     * which is used to compare Batch from HealthcareCentre and Vaccine collection
     * to get the Batch index with the same Batch number.
     * @param indexHC the index HealthCareCentre from user to compare.
     * @param indexVC the index Vaccine from user to compare.
     * @param selectBatchNum the index Batch from user input to compare.
     * @return an int of Batch object from Vaccine collection.
     */
    public int findBatch(int indexHC, int indexVC, int selectBatchNum) {
        // Save index HealthcareCentre object based on user input
        HealthcareCentre HC = getPCVSHealthcareCentres().get(indexHC-1);
        // Save index Vaccine object based on user input
        Vaccine VC = getPCVSVaccines().get(indexVC-1);
        // Traverse Batch object in HealthcareCentre collection
        return range(0, HC.getBatches().size())
            // Traverse Batch object in Vaccine collection
            .flatMap(i -> range(0, VC.getBatches().size()))
            // Equals batch number
            .filter(j -> selectBatchNum == VC.getBatches().get(j).getBatchNo())
            // Not equals batch number
            .findFirst().orElse(-1);

        /*REAL
        HealthcareCentre HC = getPCVSHealthcareCentres().get(indexHC-1);
        Vaccine VC = getPCVSVaccines().get(indexVC-1);
        for (int i = 0; i < HC.getBatches().size(); i++) {
            for(int j = 0; j < VC.getBatches().size(); j++) {
                if (selectBatchNum ==  VC.getBatches().get(j).getBatchNo()) {
                    return j;
                }
            }
        }
        return -1;
        * */
    }

    /**
     * The getNumOfPendingByPatient service method,
     * which is used to calculate pending Vaccination status.
     * @return an int value of number of pending appointments.
     */
    public int getNumOfPendingByPatient() {
        // Initialization num of pending to zero
        int numOfPending = 0;
        // Traverse User collection
        for (int i = 0; i < getPCVSUsers().size(); i++) {
            // Get Patient object
            if (getPCVSUsers().get(i) instanceof Patient tempPatient) {
                // Traverse Vaccination in Patient object
                numOfPending += range(0, tempPatient.getVaccinations().size())
                    // Equals
                    .filter(j -> tempPatient.getVaccinations().get(j).getStatus().equals("pending"))
                    // Increment
                    .count();
            }
        }
        return numOfPending;

        /*ASLI
        int numOfPending = 0;
        for (int i = 0; i < getPCVSUsers().size(); i++) {
            if (getPCVSUsers().get(i) instanceof Patient tempPatient) {
                for(int j = 0; j < ((Patient) getPCVSUsers().get(i)).getVaccinations().size(); j ++ ) {
                    if(tempPatient.getVaccinations().get(j).getStatus().equals("pending"))
                        numOfPending++;
                }
            }
        }
        return numOfPending;*/
    }

    /**
     * The getQuantityAdministered service method,
     * which is used to calculate the number of quantity administered
     * Batch in the Vaccine collection.
     * @return an int value of number quantity administered.
     */
    public int getQuantityAdministered() {
        // Traverse Vaccine collection
        return getPCVSVaccines()
            .stream()
            // Get Batch in the Vaccine collection
            .mapToInt(tempVC -> tempVC.getBatches().stream()
                // Count quantity administered in Batch
                .mapToInt(Batch::getQuantityAdministered).sum()).sum();

        /*ASLI
        int qtyAdministered = 0;
        for (int i = 0; i < getPCVSVaccines().size(); i++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size();j++) {
                qtyAdministered+= tempVC.getBatches().get(j).getQuantityAdministered();
            }
        }
        return qtyAdministered;*/
    }

    /**
     * The appointmentDate service method,
     * which is used to set the local time and compare the appointment date with the expiration date
     * from Batch expiry date and appointment date from user input.
     * @param indexHC the index HealthCareCentre to get Batch object.
     * @return a boolean value true if appointment is come first before expires and vice versa.
     */
    public boolean appointmentDate(int indexHC, String appointmentDate) {
        // Get object HealthcareCentre by index input user in the HealthcareCentre collection
        HealthcareCentre tempHC = getPCVSHealthcareCentres().get(indexHC-1);

        // Traverse Batch collection in the HealthcareCentre collection
        for (int i = 0; i < tempHC.getBatches().size(); i++) {
            // Split all Batch expiry date using method splitToArray
            int[] splitExpiryDate = splitToArray(tempHC.getBatches().get(i).getExpiryDate());
            // Create object expires to get local time from Calendar
            Calendar expires = Calendar.getInstance();
            // Set expires using expiry date from Batch
            expires.set(splitExpiryDate[2], splitExpiryDate[0], splitExpiryDate[1]);

            // Split appointment date from user input
            int[] splitAppointmentDate = splitToArray(appointmentDate);
            // Create object appointment to get local time from Calendar
            Calendar appointment = Calendar.getInstance();
            // Set appointment date using array return value from splitToArray method
            appointment.set(splitAppointmentDate[2], splitAppointmentDate[0], splitAppointmentDate[1]);
            // Appointment is come first before expires
            if(expires.after(appointment))
                return false;
        }
        // Expires come first before appointment
        return true;
    }

    /**
     * The setQuantityAdministered setter method,
     * which is used to set Batch quantity administered attribute.
     * @param inQty the value to set quantity administered.
     */
    public void setQuantityAdministered(int inQty) {
        // Traverse the Vaccine collection and Batch collection
        getPCVSVaccines().forEach(tempVaccine -> tempVaccine.getBatches()
            // Set quantity administered with inQty value
            .forEach(tempBatch -> tempBatch.setQuantityAdministered(inQty)));

        /*Real
        * for (int i = 0; i < getPCVSVaccines().size(); i++) {
            Vaccine tempVaccine = getPCVSVaccines().get(i);
            for (int j = 0; j < tempVaccine.getBatches().size(); j++) {
                Batch tempBatch = tempVaccine.getBatches().get(j);
                tempBatch.setQuantityAdministered(inQty);
            }
        }*/
    }















    public int getNumOfPendingByBatch(int iBatchNo) {
        int numOfPending = 0;
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                if (tempVC.getBatches().get(j).getBatchNo() == iBatchNo) {
                    Batch tempBatch = tempVC.getBatches().get(j);
                    for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                        if (tempBatch.getVaccinations().get(k).getStatus().equals("pending"))
                            numOfPending++;

                    }
                }
            }
        }
        return numOfPending;
    }
    public int getNumOfPendingByBatch() {
        int numOfPending = 0;
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                Batch tempBatch = tempVC.getBatches().get(j);
                for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                    if (tempBatch.getVaccinations().get(k).getStatus().equals("pending"))
                        numOfPending++;

                }
            }
        }
        return numOfPending;
    }




























    // HEALTHCARE COLLECTION END













    public String DebuggloginPatient() {
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < getPCVSUsers().size(); i++) {
            if (getPCVSUsers().get(i) instanceof Patient patient) {
                all.append(i).append(". ").append(patient).append("\n");
            }
        }
        return all.toString();
    }


}


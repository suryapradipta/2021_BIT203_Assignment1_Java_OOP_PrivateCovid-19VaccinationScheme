/**
 * The PCVS Console Program implements
 * the Private Covid-19 Vaccination Scheme application which consists of various menus:
 * Sign up, Record new vaccine batch, Request vaccination appointment,
 * View vaccine batch information, View vaccination appointment status,
 * Display detail of all users, and Display detail of all vaccination appointments.
 *
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */


import java.util.*;
import java.util.stream.Collectors;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.stream.IntStream.range;

public class PCVSConsole {

    // Visible attributes to the current class and other static methods
    private static final Scanner input = new Scanner(in);
    private static final PCVS pcvs = new PCVS();
    private static int signUp, selectCentreName;
    private static int iAdmin, selectVaccineID;
    private static int record;
    private static int iBatchNum;
    private static String selectVacID;
    private static Integer admID = 0;
    private static Integer vID = 0;

    /**
     * The main method which makes use to display
     * input and output from the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        int menu = 0;
        while (menu != 8) {
            boolean menuExc = false;
            while(!menuExc) // Loop until User select the sign-up menu
                // Exception validation
                try {
                    // User menu choices
                    out.println("\n(PCVS) Private Covid-19 Vaccination Menu:");
                    out.println("1. Sign up");
                    out.println("2. Record new vaccine batch");
                    out.println("3. Request vaccination appointment");
                    out.println("4. View vaccine batch information");
                    out.println("5. View vaccination appointment status");
                    out.println("6. Display detail of all users");
                    out.println("7. Display detail of all vaccination appointments");
                    out.println("8. Quit the program.");
                    out.print("Menu of choices: ");
                    menu = input.nextInt();
                    input.nextLine();
                    menuExc = true; // No exception is thrown
                }
                catch (InputMismatchException e) {
                    out.println("\nInvalid input! Try again");
                    input.next();
                }

            switch (menu) {
                case 1 -> {
                    boolean signUpExc = false;
                    while(!signUpExc) // Loop until User select the sign-up menu
                        try {
                            // Sign up menu user
                            out.println("\nSign up menu:");
                            out.println("1. Sign up as Healthcare Administrator");
                            out.println("2. Sign up as Patient");
                            out.print("Menu of choices: ");
                            signUp = input.nextInt();
                            // Skip the new line character
                            input.nextLine();
                            signUpExc = true; // No exception is thrown
                        }
                        catch (InputMismatchException e) {
                            out.println("\nInvalid input! Try again");
                            input.next();
                        }
                    if(signUp == 1) {
                        boolean centreNameExc = false;
                        while(!centreNameExc) // Loop until Administrator account is recorded
                            // Exception validation
                            try {
                                // Sign up for Healthcare Administrator account
                                out.println("\nCreate your Healthcare Administrator account");
                                out.print(pcvs.getAllCentreName());
                                out.print("Select the centre name: ");
                                // Record index centre name from Admin
                                selectCentreName = input.nextInt();
                                // Skip the new line character
                                input.nextLine();
                                // Get centre name from User collection by index input Admin
                                out.println("\n" + pcvs.getPCVSHealthcareCentres().get(selectCentreName-1) + "\n");
                                // Call static method sign up to record User object
                                signUpUser();
                                centreNameExc = true; // No exception is thrown
                            }
                            catch (InputMismatchException e) {
                                out.println("\nInvalid input! Try again");
                                input.next();
                            }


                    }
                    else if(signUp == 2) {
                        // Sign up for Patient account
                        out.println("\nCreate your Patient account");
                        // Call static method sign up to record User object
                        signUpUser();
                    }

                }
                case 2 -> {
                    // Sign in for Healthcare Administrator account
                    out.println("\nSign in");
                    out.println("Use your Healthcare Administrator account");
                    // Input account Admin information
                    out.print("Enter username: ");
                    String username = input.nextLine();
                    out.print("Enter password: ");
                    String password = input.nextLine();
                    // Validate the input user's username and password
                    // and save the return index from validationAdminLogin method.
                    iAdmin = pcvs.validationAdminLogin(username, password);
                    // Invalid username or password
                    if (iAdmin == -1) {
                        out.println("\nCan't find your Healthcare Administrator account");
                    }
                    else {
                        // Get centre name by index from login username and password validation
                        out.println("\n" + pcvs.getPCVSHealthcareCentres().get(iAdmin).getCentreName());
                        // Show all vaccines type
                        out.print(pcvs.getAllVaccinesID());
                        out.print("Select the vaccine ID: ");
                        // Save the input user for index vaccine id
                        selectVaccineID = input.nextInt();
                        // Skip the new line character
                        input.nextLine();
                        // Show vaccine name and manufacture vaccine object
                        // from Vaccine collection by index input user
                        out.println("\n" + pcvs.getPCVSVaccines().get(selectVaccineID-1));
                        // Call method recordBatch to record batch object
                        recordBatch();
                    }
                }
                case 3 -> {
                    // Sign in for Patient account
                    out.println("\nSign in");
                    out.println("Use your Patient account");
                    // Input account Patient information
                    out.print("Enter username: ");
                    String username = input.nextLine();
                    out.print("Enter password: ");
                    String password = input.nextLine();
                    // Validate the input user's username and password
                    // and save the return index from validationPatientLogin method.
                    int iPatient = pcvs.validationPatientLogin(username, password);
                    // Invalid username or password
                    if(iPatient == -1) {
                        out.println("\nCan't find your Patient account");
                    } else {
                        boolean repeat = true;
                        int viewHC = 0;
                        while(repeat) { // Loop until Patient select HealthcareCentre to view
                            // Get Patient's full name by return index from validationPatientLogin method
                            out.println("\nWelcome, " + pcvs.getPCVSUsers().get(iPatient).getFullName());
                            out.println("\nVaccination appointment menu:");
                            out.println("1. View available vaccines");
                            out.print("Menu of choices: ");
                            int view = input.nextInt();
                            // Skip the new line character
                            input.nextLine();
                            if(view == 1) {
                                // Get all the vaccine object from Vaccine Collection
                                out.print("\n" + pcvs.getAllVaccines());
                                out.print("Record vaccine: ");
                                record = input.nextInt(); // Save index vaccine from user input
                                // Skip the new line character
                                input.nextLine();
                                out.println();
                                // Save object vaccine by index from user input
                                Vaccine tempVaccine = pcvs.getPCVSVaccines().get(record-1);
                                // Create an ArrayList so that Health Centers offering vaccines
                                // don't display duplicate Health Centers
                                ArrayList<Integer> tempHC = new ArrayList<>();
                                // Traverse the Batch object in the Vaccine collection
                                // by index from user input to compare
                                tempVaccine.getBatches().stream()
                                    // Get index HealthcareCentre object from equalsBatch method
                                    .mapToInt(pcvs::equalsBatch)
                                    .filter(iBatch -> !tempHC.contains(iBatch))
                                    .forEach(iBatch -> {
                                        // If the HealthcareCenter is not in the collection
                                        out.println(iBatch + 1 + ". " + pcvs.getPCVSHealthcareCentres().get(iBatch));
                                        // Add to temporary HealthcareCentre collection
                                        tempHC.add(iBatch);
                                    });
                                out.println("Press 3 to back vaccination appointment menu");
                                out.print("Select a healthcare centre to view: ");
                                viewHC = input.nextInt();
                                input.nextLine(); // Skip the new line character
                                // Patient can back to vaccination appointment menu
                                if(viewHC != 3)
                                    repeat = false;
                            }
                        }
                        // Show the batches of vaccines that have quantity available
                        // and not yet expired based on HealthcareCentre and Vaccine index input user
                        out.println(pcvs.findBatch(viewHC, record));
                        out.print("Select batch number: ");
                        // Save user input batch number
                        int iBatchNo = input.nextInt();
                        input.nextLine();
                        // Save return index from method findBatch
                        int iBatch = pcvs.findBatch(viewHC, record, iBatchNo);
                        // Get Vaccine object based on user input
                        Vaccine tempVC = pcvs.getPCVSVaccines().get(record-1);
                        // Get Batch expiry date from return index of findBatch
                        out.println("\nExpiry date: " + tempVC.getBatches().get(iBatch).getExpiryDate());
                        // Calculate quantity available by number of pending and administered vaccination
                        int qty = pcvs.getNumOfPendingByPatient() + pcvs.getQuantityAdministered();
                        out.println("Quantity available: " + qty);

                        // Create vaccination object
                        Vaccination vaccination = new Vaccination();
                        boolean dateExc = false;
                        while(!dateExc) // Repeat until the Vaccination information input is valid
                            try {
                                // User input vaccination information
                                out.println("\nRequest an appointment");
                                out.print("Enter upcoming date (mm dd yyyy): ");
                                // Set attribute vaccination object
                                vaccination.setAppointmentDate(input.nextLine());
                                // Validate appointment date user input
                                boolean appointment = pcvs.appointmentDate(viewHC, vaccination.getAppointmentDate());
                                while(!appointment) {
                                    out.println("\nAppointment date after the batch expiration date!");
                                    out.print("Enter another upcoming date (mm dd yyyy): ");
                                    vaccination.setAppointmentDate(input.nextLine());
                                    // Validate new appointment date
                                    appointment = pcvs.appointmentDate(viewHC, vaccination.getAppointmentDate());
                                }
                                dateExc = true; // No exception is thrown
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                out.println("\nInvalid input! Try again");
                            }
                        // Set Vaccination object attributes
                        vaccination.setVaccinationID(generateVaccinationID());
                        vaccination.setStatus("pending");
                        // Vaccination is created for Patient object
                        Patient tempPatient = (Patient) pcvs.getPCVSUsers().get(iPatient);
                        tempPatient.setVaccinations(vaccination);
                        // Vaccination is created for Batch object
                        tempVC.getBatches().get(iBatch).setVaccinations(vaccination);
                        out.println("\nThe vaccination is recorded for the patient and the batch");
                    }
                }

                case 4 -> {
                    // Sign in for Healthcare Administrator account
                    out.println("\nSign in");
                    out.println("Use your Healthcare Administrator account");
                    // Input account Admin information
                    out.print("Enter username: ");
                    String username = input.nextLine();
                    out.print("Enter password: ");
                    String password = input.nextLine();
                    // Validate the input user's username and password
                    // and save the return index from validationAdminLogin method.
                    iAdmin = pcvs.validationAdminLogin(username, password);
                    // Invalid username or password
                    if (iAdmin == -1) {
                        out.println("\nCan't find your Healthcare Administrator account");
                    }
                    else {
                        boolean firstLoop = true, secondLoop, thirdLoop;
                        while(firstLoop) {
                            // Show HealthcareCentre name based on admin index
                            out.println("\n" + pcvs.getPCVSHealthcareCentres().get(iAdmin).getCentreName() + "\n");
                            // Create Batch ArrayList to maintain temporary Batch object
                            // don't display duplicate Batch with the same index
                            ArrayList<Batch> tempBatchCollection = new ArrayList<>();
                            // Traverse Vaccine collection
                            for(int i = 0; i < pcvs.getPCVSVaccines().size(); i ++) {
                                // Save current all Vaccine object in temporary vaccine variable
                                Vaccine tempVaccine = pcvs.getPCVSVaccines().get(i);
                                // Traverse Batch collection in Vaccine collection
                                for(int j = 0; j < tempVaccine.getBatches().size(); j++) {
                                    // Save current all Batch object in temporary batch variable
                                    Batch tempBatch = tempVaccine.getBatches().get(j);
                                    // Traverse Vaccination collection in Batch collection
                                    range(0, tempBatch.getVaccinations().size())
                                        // Get pending status
                                        .filter(k -> tempBatch.getVaccinations().get(k).getStatus().equals("pending"))
                                        // Check Batch object in the temporary Batch collection
                                        .filter(k -> !tempBatchCollection.contains(tempBatch))
                                        .forEach(k -> {
                                            // Not in Batch collection
                                            out.print(tempBatch + "\n");
                                            // Add to temporary Batch collection
                                            tempBatchCollection.add(tempBatch);
                                    });
                                }
                            }

                            out.print("Select batch number: ");
                            iBatchNum = input.nextInt();
                            input.nextLine(); // Skip the new line character
                            secondLoop = true;
                            while(secondLoop) {
                                // Traverse Vaccine collection
                                pcvs.getPCVSVaccines()
                                    // Traverse Batch collection in Vaccine collection
                                    .forEach(tempVaccine -> range(0, tempVaccine.getBatches().size())
                                        // Same Batch number
                                        .filter(j -> tempVaccine.getBatches().get(j).getBatchNo() == iBatchNum)
                                        .mapToObj(j -> tempVaccine.getBatches().get(j)).forEach(tempBatch -> {
                                            // Show information
                                            out.println("Batch expiry date: " + tempBatch.getExpiryDate());
                                            out.println("Number of available: " + tempBatch.getQuantityAvailable());
                                            out.println("Administered vaccinations: " + tempBatch.getQuantityAdministered());
                                            out.println("Number of pending: " + pcvs.getNumOfPendingByBatch(iBatchNum));
                                            out.println("\nList of vaccinations:");
                                            out.println(Arrays.toString(tempBatch.getVaccinations().toArray())
                                                // Remove brackets from the output of .toString() ArrayList
                                                .replace("[", "")
                                                .replace("]", "")
                                                .replace(", ", "\n"));
                                        }));

                                out.println("Press 0 to view another batch ");
                                out.print("Select vaccination ID: ");
                                selectVacID = input.nextLine();
                                if(selectVacID.equals("0"))
                                    // Admin my choose to view different batch
                                    secondLoop = false;

                                else {
                                    thirdLoop = true;
                                    while(thirdLoop) {
                                        // Traverse Vaccine collection
                                        pcvs.getPCVSVaccines()
                                            // Traverse Batch collection in Vaccine collection
                                            .forEach(tempVaccine -> tempVaccine.getBatches()
                                                // Traverse Vaccination collection in Batch collection
                                                .forEach(tempBatch -> tempBatch.getVaccinations().stream()
                                                    // Same Vaccination ID
                                                    .filter(tempVaccination -> tempVaccination.getVaccinationID().equals(selectVacID))
                                                    .forEach(tempVaccination -> {
                                                        // Show information
                                                        out.println("\n" + tempVaccine);
                                                        out.println("\n" + tempBatch);
                                                        // Traverse User collection
                                                        range(0, pcvs.getPCVSUsers().size()).forEach(x -> {
                                                            // Downcast User object to Patient
                                                            if (pcvs.getPCVSUsers().get(x) instanceof Patient tempPatient) {
                                                                // Traverse Vaccination in Patient collection
                                                                range(0, ((Patient) pcvs.getPCVSUsers().get(x)).getVaccinations().size())
                                                                    // Same Vaccination object
                                                                    .filter(y -> tempVaccination.equals(tempPatient.getVaccinations().get(y)))
                                                                    // Show Patient information
                                                                    .mapToObj(y -> tempPatient).forEach(out::println);
                                                            }
                                                        });
                                                    })));



                                        out.println("\n1. View another vaccination: ");
                                        out.println("2. Confirm vaccination");
                                        out.println("3. Record vaccination administered");
                                        out.println("4. Log out");
                                        out.print("Menu of choices: ");
                                        int selectVaccination = input.nextInt();
                                        input.nextLine();
                                        out.println();
                                        // Close all loops, so admin can log out
                                        if(selectVaccination == 4) {
                                            firstLoop = false;
                                            secondLoop = false;
                                            thirdLoop = false;
                                        }
                                        // Close third loop to view different vaccination
                                        else if(selectVaccination == 1)
                                            thirdLoop = false;
                                        // Close all loop to confirm vaccination
                                        else if(selectVaccination == 2) {
                                            // Call static method confirmVaccination
                                            // to confirm or reject appointment
                                            confirmVaccination();
                                            thirdLoop = false;
                                            secondLoop = false;
                                            firstLoop = false;
                                        }
                                        else if(selectVaccination == 3) {
                                            // Call method recordVaccinationAdministered
                                            // to record vaccination administered
                                            recordVaccinationAdministered();
                                            thirdLoop =false;
                                            secondLoop = false;
                                            firstLoop = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                case 5 -> {
                    // Sign in for Patient account
                    out.println("\nSign in");
                    out.println("Use your Patient account");
                    // Input account Patient information
                    out.print("Enter username: ");
                    String username = input.nextLine();
                    out.print("Enter password: ");
                    String password = input.nextLine();
                    // Validate the input user's username and password
                    // and save the return index from validationPatientLogin method.
                    int iPatient = pcvs.validationPatientLogin(username, password);
                    // Invalid username or password
                    if (iPatient == -1) {
                        out.println("\nCan't find your Patient account");
                    }
                    else {
                        // Get Patient's full name by return index from validationPatientLogin method
                        out.println("\nWelcome, " + pcvs.getPCVSUsers().get(iPatient).getFullName());
                        out.println("\nVaccination appointment menu:");
                        out.println("1. View status of vaccination appointment ");
                        out.print("Menu of choices: ");
                        int view = input.nextInt();
                        input.nextLine();
                        if (view == 1) {
                            // Create ArrayList to maintain Patient object and Patient status
                            // so no duplicates output with the same index
                            ArrayList<Patient> patients = new ArrayList<>();
                            ArrayList<String> statusPatients = new ArrayList<>();

                            // Traverse User collection
                            range(0, pcvs.getPCVSUsers().size()).filter(x -> pcvs.getPCVSUsers().get(x) instanceof Patient)
                                // Downcast User collection to Patient object by return index value
                                // from validationPatientLogin method
                                .mapToObj(x -> (Patient) pcvs.getPCVSUsers().get(iPatient))
                                .forEach(tempPatient -> {
                                    // Traverse Vaccination collection in Patient object
                                    tempPatient.getVaccinations().stream().map(Vaccination::getStatus)
                                        .filter(status -> !statusPatients.contains(status))
                                        .forEach(status -> {
                                            // Not in statusPatients collection
                                            out.println("\nYour appointment status: " + status);
                                            // Add to statusPatients collection
                                            statusPatients.add(status);
                                        });
                                    if (!patients.contains(tempPatient)) {
                                        // Patient not yet aggregation with Vaccination
                                        if (tempPatient.getVaccinations().size() == 0) {
                                            out.println("\nSorry, you haven't made an vaccination appointment");
                                            // Add to patients collection
                                            patients.add(tempPatient);
                                        }
                                    }
                                });
                        }
                    }
                }

                case 6 -> {
                    out.println("\n1. Original sequence ");
                    out.println("2. Sorted according to full name");
                    out.print("Menu of choices: ");
                    int view = input.nextInt();
                    input.nextLine();
                    if(view == 1) {
                        // Traverse User collection
                        range(0, pcvs.getPCVSUsers().size())
                            .filter(x -> pcvs.getPCVSUsers().get(x) instanceof Patient)
                            // Downcast User to Patient
                            .mapToObj(x -> (Patient) pcvs.getPCVSUsers().get(x))
                            // Show information
                            .map(tempPatient -> "\n" + tempPatient)
                            .forEach(out::println);
                    }
                    else if(view == 2) {
                        // Create ArrayList to maintain Patient object
                        // so no duplicates output with the same index
                        ArrayList<Patient> patients = range(0, pcvs.getPCVSUsers().size())
                            .filter(x -> pcvs.getPCVSUsers().get(x) instanceof Patient)
                            // Downcast User to Patient
                            .mapToObj(x -> (Patient) pcvs.getPCVSUsers().get(x))
                            // Sort by Patient's full name
                            .sorted(Comparator.comparing(Patient::getFullName))
                            .collect(Collectors.toCollection(ArrayList::new));

                        // Traverse Patient collection
                        for (Iterator<Patient> iterator = patients.iterator(); iterator.hasNext(); ) {
                            Patient patient = iterator.next();
                            // Show all Patient information
                            String s = "\n" + patient;
                            out.println(s);
                        }
                    }
                }

                case 7 -> {
                    out.println("\nVaccination appointments:\n");
                    // Traverse Vaccine collection
                    pcvs.getPCVSVaccines()
                        // Save current all index of Vaccine collection
                        // Traverse Batch collection in Vaccine collection
                        .forEach(tempVaccine -> tempVaccine.getBatches()
                            // Traverse Vaccination in Batch collection
                            .forEach(tempBatch -> tempBatch.getVaccinations()
                                .forEach(tempVaccination -> {
                                    // Show Vaccination information
                                    out.print(tempVaccination);
                                    out.println("Remarks: " + tempVaccination.getRemarks() + "\n");
                                })));
                }

                case 8 -> out.println("\nThank you");
                default -> out.println("\nInvalid choice! Try another menu");

                case 19 -> { //5 - Debug all HC + admin
                    for (int i = 0; i < pcvs.getPCVSHealthcareCentres().size(); i++) {
                        out.println("\n===================");
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        out.println(pcvs.getPCVSHealthcareCentres().get(i));
                        for (int j = 0; j < HC.getAdministrators().size(); j++) {
                            out.println(HC.getAdministrators().get(j));
                        }
                    }
                }

                case 18 -> { // 6 - all user(admin patient)
                    for (int i = 0; i < pcvs.getPCVSUsers().size(); i++) {
                        out.println(pcvs.getPCVSUsers().get(i));
                    }
                }

                case 17 -> {// 9 get patient
                    out.println(pcvs.DebuggloginPatient());
                }

                case 16 -> { // 11 HC Batch
                    for(int i =0; i < pcvs.getPCVSHealthcareCentres().size(); i++) {
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        out.println("\n===================");
                        out.println("index: " + i + pcvs.getPCVSHealthcareCentres().get(i));
                        out.println();
                        for (int j = 0; j < HC.getBatches().size(); j++) {
                            out.println("[" + j + "] " +HC.getBatches().get(j));
                            out.println();
                        }
                    }
                }
                case 15 -> { // 8 VC Batch
                    for (int i = 0; i < pcvs.getPCVSVaccines().size(); i++) {
                        out.println("\n===================");
                        Vaccine VC = pcvs.getPCVSVaccines().get(i);
                        out.println(pcvs.getPCVSVaccines().get(i));
                        for (int j = 0; j < VC.getBatches().size(); j++) {
                            out.println("[" + j + "] " +VC.getBatches().get(j));
                        }
                    }
                }

                case 14 ->  {
                    for(int i = 0; i < pcvs.getPCVSVaccines().size(); i ++) {
                        Vaccine tempVC = pcvs.getPCVSVaccines().get(i);
                        for(int j = 0; j < tempVC.getBatches().size(); j++) {
                            Batch tempBatch = tempVC.getBatches().get(j);
                            out.println("[" + j + "] " + tempBatch);
                            for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                                out.println("[" + k + "] " +Arrays.toString(tempBatch.getVaccinations().toArray()).replace("[", "").replace("]", ""));
                            }
                        }
                    }
                }

                case 13-> {
                    for (int x = 0; x < pcvs.getPCVSUsers().size(); x++) {
                        if (pcvs.getPCVSUsers().get(x) instanceof Patient tempPatient) {
                            for (int y = 0; y < ((Patient) pcvs.getPCVSUsers().get(x)).getVaccinations().size(); y++) {
                                for (int i = 0; i < pcvs.getPCVSVaccines().size(); i++) {
                                    Vaccine tempVaccine = pcvs.getPCVSVaccines().get(i);
                                    for (int j = 0; j < tempVaccine.getBatches().size(); j++) {
                                        Batch tempBatch = tempVaccine.getBatches().get(j);
                                        for (int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                                            out.println(tempPatient.getVaccinations());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                case 12-> {
                    out.println(pcvs.getNumOfPendingByPatient());
                    out.println(pcvs.getQuantityAdministered());
                }
            }
        }
    }
    /**
     * Calculates the length of the Administrator ID.
     * Returns two positive integers + id, zero , or one integer + id.
     * @return a String with the increment of id.
     */
    public static String generateStaffID() {
        // if length id 1 digit add with 00 + id
        String id = (admID.toString().length() == 1) ? ("00" + admID)
            // if length id 2 digit add with 0 + id
            : ((admID.toString().length() == 2) ? ("0" + admID)
            : admID.toString());
        admID++; // increment
        return "ADM" + id;
    }

    /**
     * Calculates the length of the Vaccination ID.
     * Returns two positive integers + id, zero , or one integer + id.
     * @return a String with the increment of id.
     */
    public static String generateVaccinationID() {
        // if length id 1 digit add with 00 + id
        String id = (vID.toString().length() == 1) ? ("00" + vID)
            // if length id 2 digit add with 0 + id
            : ((vID.toString().length() == 2) ? ("0" + vID)
            : vID.toString());
        vID++; // increment
        return "V" + id;
    }

    /**
     * Enter user information, set to Patient and Administrator attributes object.
     * Save to the User and Healthcare collections.
     */
    public static void signUpUser() {
        // Create object Patient and Administrator
        Patient patient = new Patient();
        Administrator admin = new Administrator();
        // User input information
        out.print("Enter username: ");
        String username = input.nextLine();
        // Validate username input
        while (pcvs.userNameValidation(username)) {
            out.println("That username is taken. Try another.");
            out.print("Enter username: ");
            username = input.nextLine();
        }
        // User input information
        out.print("Enter password: ");
        String password = input.nextLine();
        out.print("Enter email: ");
        String email = input.nextLine();
        out.print("Enter full name: ");
        String fullName = input.nextLine();

        if (signUp == 2) {
            // Set the Patient object's attributes
            patient.setUsername(username);
            patient.setPassword(password);
            patient.setEmail(email);
            patient.setFullName(fullName);
            out.print("Enter IC or passport: ");
            patient.setICPassport(input.nextLine());
            // Record the Patient object to User collection
            pcvs.addUser(patient);
            out.println("\nSign up success! A Patient account is created.");
        } else if (signUp == 1) {
            // Set the Administrator object's attributes
            admin.setUsername(username);
            admin.setPassword(password);
            admin.setEmail(email);
            admin.setFullName(fullName);
            admin.setStaffID(generateStaffID());
            // Record the Administrator object to User collection
            pcvs.addUser(admin);
            // Record the Administrator object to HealthcareCentre Collection
            pcvs.getPCVSHealthcareCentres().get(selectCentreName - 1).setAdministrator(admin);
            out.println("\nSign up success! A Healthcare Administrator account is created.");
        }

    }

    /**
     * Enter user information, set to Patient and Administrator attributes object.
     * Save to the User and Healthcare collections.
     */
    public static void recordBatch() {
        // Create object Batch
        Batch batch = new Batch();
        boolean batchExc = false;
        while(!batchExc) // Loop Batch object is created ad record to the Vaccine and HealthcareCentre collection
            // Exception validation
            try {
                // Input Batch information
                // and set to the Batch object attributes
                out.print("Enter batch number: ");
                batch.setBatchNo(input.nextInt());
                input.nextLine();
                out.print("Enter expiry date (mm dd yyyy): ");
                batch.setExpiryDate(input.nextLine());
                out.print("Quantity of doses available: ");
                batch.setQuantityAvailable(input.nextInt());
                // Record Batch object to Vaccine collection by selected index
                pcvs.getPCVSVaccines().get(selectVaccineID - 1).setBatch(batch);
                // Record Batch object to HealthcareCentre collection by selected index
                pcvs.getPCVSHealthcareCentres().get(iAdmin).setBatches(batch);
                out.println("\nThe batch is recorded for the vaccine and healthcare centre");
                batchExc = true;
            }
            catch (InputMismatchException e) {
                out.println("\nInvalid input! Try again");
                input.next();
            }
    }

    /**
     * Allow a Healthcare Administrator to view vaccine batch information
     * before confirm, reject, or administered appointment request.
     */
    public static void viewVaccineBatchInformation() {
        // Traverse Vaccine collection
        pcvs.getPCVSVaccines()
            // Traverse Batch collection in Vaccine collection
            .forEach(tempVC -> range(0, tempVC.getBatches().size())
                // Same Batch number
                .filter(j -> tempVC.getBatches().get(j).getBatchNo() == iBatchNum)
                .mapToObj(j -> tempVC.getBatches().get(j)).forEach(tempBatch -> {
                    // Show information
                    out.println("Batch expiry date: " + tempBatch.getExpiryDate());
                    out.println("Number of available: " + tempBatch.getQuantityAvailable());
                    out.println("Administered vaccinations: " + tempBatch.getQuantityAdministered());
                    out.println("Number of pending: " + pcvs.getNumOfPendingByBatch(iBatchNum));
                    out.println("\nList of vaccinations:");
                    out.println(Arrays.toString(tempBatch.getVaccinations().toArray())
                        // Remove brackets from the output of .toString() ArrayList
                        .replace("[", "")
                        .replace("]", "")
                        .replace(", ", "\n"));
                }));

        out.print("Select vaccination ID: ");
        selectVacID = input.nextLine();
        // Traverse Vaccine collection
        pcvs.getPCVSVaccines()
            // Traverse Batch collection in Vaccine collection
            .forEach(tempVaccine -> tempVaccine.getBatches()
                // Traverse Vaccination collection in Batch collection
                .forEach(tempBatch -> tempBatch.getVaccinations().stream()
                    // Same Vaccination ID
                    .filter(tempVaccination -> tempVaccination.getVaccinationID().equals(selectVacID))
                    // Traverse User collection
                    .forEach(tempVaccination -> range(0, pcvs.getPCVSUsers().size())
                        .forEach(x -> {
                            // Downcast User to Patient
                            if (pcvs.getPCVSUsers().get(x) instanceof Patient tempPatient) {
                                range(0, ((Patient) pcvs.getPCVSUsers().get(x)).getVaccinations().size())
                                    // Same Vaccination object
                                    .filter(y -> tempVaccination.equals(tempPatient.getVaccinations().get(y)))
                                    .forEach(y -> {
                                        // Show information
                                        out.println("\nFull name: " + tempPatient.getFullName());
                                        out.println("IC or passport number: " + tempPatient.getICPassport());
                                        out.println("Batch number: " + tempBatch.getBatchNo());
                                        out.println("Expiry date: " + tempBatch.getExpiryDate());
                                        out.println(tempVaccine);
                                    });
                            }
                        }))));
    }

    /**
     * Record that vaccination has been administered to a Patient
     */
    public static void recordVaccinationAdministered() {
        viewVaccineBatchInformation();
        out.println("\n1. Confirm the vaccination has been administered");
        out.print("Menu of choices: ");
        int choice = input.nextInt();
        input.nextLine();
        int count = 0;
        if(choice == 1) {
            // Traverse User collection
            for (int x = 0; x < pcvs.getPCVSUsers().size(); x++) {
                // Downcast User collection to Patient collection
                if (pcvs.getPCVSUsers().get(x) instanceof Patient tempPatient) {
                    // Traverse Vaccination collection in Patient collection
                    for (int y = 0; y < tempPatient.getVaccinations().size(); y++) {
                        Vaccination tempVaccination = tempPatient.getVaccinations().get(y);
                        // Same Vaccination ID
                        if (tempPatient.getVaccinations().get(y).getVaccinationID().equals(selectVacID)) {
                            // Set Vaccination attributes
                            tempPatient.getVaccinations().get(y).setStatus("administered");
                            out.print("\nEnter remarks: ");
                            count++;
                            // Call method setQuantityAdministered to set the quantity administered
                            pcvs.setQuantityAdministered(count);
                            String remarks = input.nextLine();
                            tempVaccination.setRemarks(remarks);
                            out.println("\nThe vaccination status is set to 'administered'");
                        }
                    }
                }
            }
        }
    }

    /**
     * Confirm or reject vaccination appointment request.
     */
    public static void confirmVaccination() {
        viewVaccineBatchInformation();
        out.println("\n1. Confirm the vaccination date");
        out.println("2. Reject the appointment request");
        out.print("Menu of choices: ");
        int choice = input.nextInt();
        input.nextLine();
        // Traverse User collection
        range(0, pcvs.getPCVSUsers().size())
            .filter(x -> pcvs.getPCVSUsers().get(x) instanceof Patient)
            // Downcast User collection to Patient
            .mapToObj(x -> (Patient) pcvs.getPCVSUsers().get(x))
            // Traverse Vaccination collection in Patient collection
            .forEach(tempPatient -> range(0, tempPatient.getVaccinations().size())
                .forEach(y -> {
                    Vaccination tempVaccination = tempPatient.getVaccinations().get(y);
                    // Same Vaccination ID
                    if (tempPatient.getVaccinations().get(y).getVaccinationID().equals(selectVacID)) {
                        if (choice == 1) {
                            // Confirm the vaccination date
                            tempPatient.getVaccinations().get(y).setStatus("confirmed");
                            out.println("\nThe status is set to 'confirmed' and a confirmation email will be sent to patient");
                        } else if (choice == 2) {
                            // Reject the appointment date
                            tempPatient.getVaccinations().get(y).setStatus("rejected");
                            out.print("\nEnter remarks: ");
                            String remarks = input.nextLine();
                            tempVaccination.setRemarks(remarks);
                            out.println("\nThe status is set to 'rejected' and an email sent to the patient");
                        }

                    }
                }));
    }
}
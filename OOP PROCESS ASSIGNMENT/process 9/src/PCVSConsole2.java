import java.util.*;

public class PCVSConsole2 {

    private static Scanner input = new Scanner(System.in);
    private static PCVS pcvs = new PCVS();
    private static int signUp, selectCentreName; //uc1
    private static int iAdmin, selectVaccineID; // uc2
    private static int record, iBatch; //uc 3
    private static int iBatchNum; //uc 4
    private static Integer admID = 0;
    private static Integer vID = 0;


    private static String generateStaffID() {
        String id = admID.toString().length() == 1 ? ("00" + admID)
            : admID.toString().length() == 2 ? ("0" + admID) : admID.toString();
        admID = admID + 1;
        String finalResult = "ADM" + id;
        return finalResult;
    }

    private static String generateVaccinationID() {
        String id = vID.toString().length() == 1 ? ("00" + vID)
            : vID.toString().length() == 2 ? ("0" + vID) : vID.toString();
        vID = vID + 1;
        String finalResult = "V" + id;
        return finalResult;
    }

    public static void signUpUser() {
        Patient patient = new Patient();
        Administrator admin = new Administrator();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        while(pcvs.validateUsername(username)) {
            System.out.println("That username is taken. Try another.");
            System.out.print("Enter username: ");
            username = input.nextLine();
        }
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter full name: ");
        String fullName = input.nextLine();

        if (signUp == 2) {
            patient.setUsername(username);
            patient.setPassword(password);
            patient.setEmail(email);
            patient.setFullName(fullName);
            System.out.print("Enter IC or passport: ");
            patient.setICPassport(input.nextLine());
            pcvs.addUser(patient); // record patient to User collection
            System.out.println("\nSign up success! A Patient account is created.");
        }
        else if (signUp == 1) {
            admin.setUsername(username);
            admin.setPassword(password);
            admin.setEmail(email);
            admin.setFullName(fullName);
            admin.setStaffID(generateStaffID()); // UC3

            pcvs.addUser(admin); // add admin to User
            pcvs.getPCVSHealthcareCentres().get(selectCentreName-1).setAdministrator(admin); // UC3 set admin to healthcare centre
            System.out.println("\nSign up success! A Healthcare Administrator account is created.");
        }

    }

    public static void recordBatch() {
        Batch batch = new Batch();
        System.out.print("Enter batch number: ");
        batch.setBatchNo(input.nextInt());
        input.nextLine();
        System.out.print("Enter expiry date (mm dd yyyy): ");
        batch.setExpiryDate(input.nextLine());
        System.out.print("Quantity of doses available: ");
        batch.setQuantityAvailable(input.nextInt());

        pcvs.getPCVSVaccines().get(selectVaccineID-1).setBatch(batch); //Batch to Vaccine
        pcvs.getPCVSHealthcareCentres().get(iAdmin).setBatches(batch); //Batch to HealthcareCentre
        System.out.println("\nThe batch is recorded for the vaccine and healthcare centre");
    }








    public static void main(String[] args) {
        int menu = 0;
        while (menu != 20) {
            boolean menuExc = false;
            while(!menuExc)
                try {
                    System.out.println("\n(PCVS) Private Covid-19 Vaccination Menu:");
                    System.out.println("1. Sign up");
                    System.out.println("2. Record new vaccine batch");
                    System.out.println("3. Request vaccination appointment");
                    System.out.println("4. View vaccine batch information");
                    System.out.println("20. Quit the program.");
                    System.out.print("Menu of choices: ");
                    menu = input.nextInt();
                    input.nextLine();
                    menuExc = true;
                }
                catch (InputMismatchException mismatchException) {
                    System.out.println("\nInvalid choice! Try again");
                    input.next();
                }

            switch (menu) {
                case 1 -> {
                    boolean signUpExc = false;
                    while(!signUpExc)
                        try {
                            System.out.println("\nSign up menu:");
                            System.out.println("1. Sign up as Healthcare Administrator");
                            System.out.println("2. Sign up as Patient");
                            System.out.print("Menu of choices: ");
                            signUp = input.nextInt();
                            input.nextLine();
                            signUpExc = true;
                        }
                        catch (InputMismatchException mismatchException) {
                            System.out.println("\nInvalid choice! Try again");
                            input.next();
                        }
                    if(signUp == 1) {
                        boolean centNameExc = false;
                        while(!centNameExc)
                            try {
                                System.out.println("\nCreate your Healthcare Administrator account");
                                System.out.print(pcvs.getAllCentreName());
                                System.out.print("Select the centre name: ");
                                selectCentreName = input.nextInt();
                                input.nextLine();

                                System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(selectCentreName-1)); // show healthcare centre
                                signUpUser();
                                centNameExc = true;
                            }
                            catch (InputMismatchException mismatchException) {
                                System.out.println("\nInvalid choice! Try again");
                                input.next();
                            }


                    }
                    else if(signUp == 2) {
                        System.out.println("\nCreate your Patient account");
                        signUpUser();
                    }

                }
                case 2 -> {
                    System.out.println("\nSign in");
                    System.out.println("Use your Healthcare Administrator account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();

                    iAdmin = pcvs.loginAdmin(username, password);
                    if (iAdmin == -1) {
                        System.out.println("\nCan't find your Healthcare Administrator account");
                    }
                    else {
                        System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(iAdmin).getCentreName());
                        System.out.print(pcvs.getAllVaccinesID());
                        System.out.print("Select the vaccine ID: ");
                        selectVaccineID = input.nextInt();
                        input.nextLine();
                        System.out.println("\n" + pcvs.getPCVSVaccines().get(selectVaccineID-1));
                        recordBatch();
                    }
                }
                case 3 -> {
                    System.out.println("\nSign in");
                    System.out.println("Use your Patient account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    int iPatient = pcvs.loginPatient(username, password);
                    if(iPatient == -1) {
                        System.out.println("\nCan't find your Patient account");
                    } else {
                        boolean repeat = true;
                        int viewHC = 0;
                        while(repeat) {
                            System.out.println("\nWelcome, " + pcvs.getPCVSUsers().get(iPatient).getFullName());
                            System.out.println("\nVaccination appointment menu:");
                            System.out.println("1. View available vaccines");
                            System.out.print("Menu of choices: ");
                            int view = input.nextInt();
                            input.nextLine();
                            if(view == 1) {
                                System.out.print("\n" + pcvs.getAllVaccines());
                                System.out.print("Record vaccine: ");
                                record = input.nextInt(); // ======================
                                input.nextLine();
                                System.out.println();
                                Vaccine VC = pcvs.getPCVSVaccines().get(record-1); //cara akses vaksind dari record supaya gak pake if lagi
                                //System.out.println("\nDEBUG " + VC); //print jenis vaccine
                                ArrayList<Integer> tempHC = new ArrayList<>(); // balimed // puri
                                VC.getBatches().stream().mapToInt(batch -> pcvs.findVaccineToHealthcareCentre(batch))
                                    .filter(index -> !tempHC.contains(index))
                                    .forEach(index -> {
                                    System.out.println(index + 1 + ". " + pcvs.getPCVSHealthcareCentres().get(index));
                                    tempHC.add(index);
                                });
                                System.out.println("4. Back to vaccination appointment menu");
                                System.out.print("Select a healthcare centre to view: ");
                                viewHC = input.nextInt();
                                input.nextLine();
                                if(viewHC != 4 )
                                    repeat = false;
                            }
                        }
                        /*if(pcvs.findBatch(viewHC, record) != null) {
                            System.out.println(pcvs.findBatch(viewHC, record));
                            System.out.print("Select batch number: ");
                            int selectBatchNum = input.nextInt();
                            input.nextLine();
                            iBatch = pcvs.findBatch(viewHC, record, selectBatchNum);
                            Vaccine tempVC = pcvs.getPCVSVaccines().get(record-1);
                            System.out.println("\nExpiry date: " + tempVC.getBatches().get(iBatch).getExpiryDate());
                            int qty = pcvs.getNumOfPending() + batch.getQuantityAdministered();
                            System.out.println("Quantity available: " + qty);
                        }
                        else {
                            System.out.println("\nNo batches available");
                        }*/
                        System.out.println(pcvs.findBatch(viewHC, record));
                        System.out.print("Select batch number: ");
                        int selectBatchNum = input.nextInt();
                        input.nextLine();
                        iBatch = pcvs.findBatch(viewHC, record, selectBatchNum);
                        Vaccine tempVC = pcvs.getPCVSVaccines().get(record-1);
                        System.out.println("\nExpiry date: " + tempVC.getBatches().get(iBatch).getExpiryDate());
                        int qty = pcvs.getNumOfPending() + pcvs.getQuantityAdministered();
                        System.out.println("Quantity available: " + qty);

                        Vaccination vaccination = new Vaccination();
                        System.out.println("\nRequest an appointment");
                        System.out.print("Enter upcoming date (mm dd yyyy): ");
                        vaccination.setAppointmentDate(input.nextLine());
                        boolean appointment = pcvs.appointmentDate(viewHC,record, vaccination.getAppointmentDate());
                        while(!appointment) {
                            System.out.println("Appointment date after the batch expiration date!");
                            System.out.print("Enter another upcoming date (mm dd yyyy): ");
                            vaccination.setAppointmentDate(input.nextLine());
                            appointment = pcvs.appointmentDate(viewHC, record, vaccination.getAppointmentDate());
                        }
                        vaccination.setVaccinationID(generateVaccinationID());
                        vaccination.setStatus("pending");

                        Patient tempPatient = (Patient) pcvs.getPCVSUsers().get(iPatient);
                        tempPatient.setVaccinations(vaccination);
                        //System.out.println(tempPatient.getVaccinations());


                        tempVC.getBatches().get(iBatch).setVaccinations(vaccination);
                        //System.out.println(tempVC.getBatches().get(iBatch).getVaccinations());
                        System.out.println("\nThe vaccination is recorded for the patient and the batch");

                    }
                }

                case 4 -> {
                    // UC 4.2 login
                    System.out.println("\nSign in");
                    System.out.println("Use your Healthcare Administrator account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    // Validation
                    iAdmin = pcvs.loginAdmin(username, password);
                    if (iAdmin == -1) {
                        System.out.println("\nCan't find your Healthcare Administrator account");
                    }
                    else {
                        boolean loop1 = true;
                        boolean loop2 = true;
                        boolean ulangPertama = true;
                        while(ulangPertama) {

                        }

                        while(loop1){
                            // find centre name
                            System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(iAdmin).getCentreName());

                            //show list available vaccine batch
                            System.out.println("\n" + pcvs.findBatch());

                            //UC 4.3
                            System.out.print("Select batch number: ");
                            iBatchNum = input.nextInt();
                            input.nextLine();


                            for(int i = 0; i < pcvs.getPCVSVaccines().size(); i ++) {
                                Vaccine tempVC = pcvs.getPCVSVaccines().get(i);
                                for(int j = 0; j < tempVC.getBatches().size(); j++) {
                                    if(tempVC.getBatches().get(j).getBatchNo() == iBatchNum) {
                                        Batch tempBatch = tempVC.getBatches().get(j);

                                        // UC 4.3 System Response

                                        System.out.println("\nExpiry date: " + tempBatch.getExpiryDate());
                                        System.out.println("Number of available: " + tempBatch.getQuantityAvailable());
                                        System.out.println("Administered vaccinations: " + tempBatch.getQuantityAdministered());


                                        for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                                            int numOfPending = 0;
                                            if(tempBatch.getVaccinations().get(k).getStatus().equals("pending"))
                                                numOfPending++;
                                            System.out.println("Num of pending: " + numOfPending);

                                            //UC 4.3 System Response
                                            System.out.println("\nList of vaccinations:");
                                            System.out.println(Arrays.toString(tempBatch.getVaccinations().toArray()).replace("[", "").replace("]", ""));
                                        }
                                    }
                                }
                            }
                            //UC4.3 A
                            System.out.println("\n0. View another batch: ");
                            //UC 4.4
                            System.out.print("Select vaccination ID: ");
                            String selectVacID = input.nextLine();
                            if(selectVacID.equals("0"));
                                //viewBatch();
                            else {
                                for(int i = 0; i < pcvs.getPCVSVaccines().size(); i++) {
                                    Vaccine tempVC = pcvs.getPCVSVaccines().get(i);
                                    for(int j = 0; j < tempVC.getBatches().size(); j++) {
                                        Batch tempBatch = tempVC.getBatches().get(j);
                                        for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                                            Vaccination tempVT = tempBatch.getVaccinations().get(k);
                                            if(tempVT.getVaccinationID().equals(selectVacID)) {
                                                System.out.println("\n" + tempVC);
                                                System.out.println(tempBatch);
                                            }
                                        }

                                    }

                                }
                                ArrayList<Integer> tempUser = new ArrayList<>();
                                for (int i = 0; i < pcvs.getPCVSUsers().size(); i++) {
                                    if (pcvs.getPCVSUsers().get(i) instanceof Patient tempPatient) {
                                        for(int j = 0; j < ((Patient) pcvs.getPCVSUsers().get(i)).getVaccinations().size(); j ++ ) {
                                            int iVacBatch= pcvs.findVaccinationBatch(tempPatient.getVaccinations().get(j)); // jika vaccination sama
                                            if(iVacBatch > -1) {
                                                if(!tempUser.contains(iVacBatch)) {
                                                    System.out.println(tempPatient);
                                                    tempUser.add(iVacBatch);
                                                }
                                            }
                                        }
                                    }
                                }
                                // select vaccineation id
                                // loop vaccine
                                // loop batch
                                // loop vaccination
                                // jika input vaccination sama dengan vaccination id loop
                                // tampilkan batch

                            }

                        }

                        /*boolean diffVac = true;
                        while(diffVac) {
                            // save the set of indexes to the collection, so as not to create duplicates
                            ArrayList<Integer> tempUser = new ArrayList<>();

                            for (int i = 0; i < pcvs.getPCVSUsers().size(); i++) {
                                if (pcvs.getPCVSUsers().get(i) instanceof Patient tempPatient) {
                                    for(int j = 0; j < ((Patient) pcvs.getPCVSUsers().get(i)).getVaccinations().size(); j ++ ) {

                                        int iVacBatch= pcvs.findVaccinationBatch(tempPatient.getVaccinations().get(j)); // jika vaccination sama

                                        for(int k = 0; k < pcvs.getPCVSVaccines().size(); k++ ) {
                                            if(iVacBatch > -1) {
                                                Patient tempPatient2 = (Patient) pcvs.getPCVSUsers().get(i);
                                                if(!tempUser.contains(iVacBatch)) {
                                                    System.out.println("\nVaccination batch");
                                                    Vaccine tempVaccine = pcvs.getPCVSVaccines().get(k);
                                                    System.out.println(tempVaccine);
                                                    System.out.println(tempVaccine.getBatches().get(iVacBatch));
                                                    System.out.println(tempPatient2);
                                                    tempUser.add(iVacBatch);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            System.out.println("\n1. View another vaccination: ");
                            System.out.println("2. Confirm vaccination");
                            System.out.println("3. Record vaccination administered");
                            System.out.println("4. Log out");
                            System.out.print("Menu of choices: ");
                            int selectVaccination = input.nextInt();
                            if(selectVaccination == 4)
                                diffVac = false;
                            else if(selectVaccination ==1)
                                viewListVaccinations();
                            else if(selectVaccination ==2) {


                            }
                            else if(selectVaccination ==3) {

                            }
                        }

                         */



                    }
                }

                // vaccine batch vaccination
                // patient vaccination



//expires ngikutin date vaccine terakhir diinput










                case 19 -> { //5 - Debug all HC + admin
                    for (int i = 0; i < pcvs.getPCVSHealthcareCentres().size(); i++) {
                        System.out.println("\n===================");
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        System.out.println(pcvs.getPCVSHealthcareCentres().get(i));
                        for (int j = 0; j < HC.getAdministrators().size(); j++) {
                            System.out.println(HC.getAdministrators().get(j));
                        }
                    }
                }

                case 18 -> { // 6 - all user(admin patient)
                    for (int i = 0; i < pcvs.getPCVSUsers().size(); i++) {
                        System.out.println(pcvs.getPCVSUsers().get(i));
                    }
                }

                case 17 -> {// 9 get patient
                    System.out.println(pcvs.DebuggloginPatient());
                }

                case 16 -> { // 11 HC Batch
                    for(int i =0; i < pcvs.getPCVSHealthcareCentres().size(); i++) {
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        System.out.println("\n===================");
                        System.out.println("index: " + i + pcvs.getPCVSHealthcareCentres().get(i));
                        System.out.println();
                        for (int j = 0; j < HC.getBatches().size(); j++) {
                            System.out.println("[" + j + "] " +HC.getBatches().get(j));
                            System.out.println();
                        }
                    }
                }
                case 15 -> { // 8 VC Batch
                    for (int i = 0; i < pcvs.getPCVSVaccines().size(); i++) {
                        System.out.println("\n===================");
                        Vaccine VC = pcvs.getPCVSVaccines().get(i);
                        System.out.println(pcvs.getPCVSVaccines().get(i));
                        for (int j = 0; j < VC.getBatches().size(); j++) {
                            System.out.println("[" + j + "] " +VC.getBatches().get(j));
                        }
                    }
                }

                case 14 ->  {
                    for(int i = 0; i < pcvs.getPCVSVaccines().size(); i ++) {
                        Vaccine tempVC = pcvs.getPCVSVaccines().get(i);
                        for(int j = 0; j < tempVC.getBatches().size(); j++) {
                            Batch tempBatch = tempVC.getBatches().get(j);
                            System.out.println("[" + j + "] " + tempBatch);
                            for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                                System.out.println("[" + k + "] " +Arrays.toString(tempBatch.getVaccinations().toArray()).replace("[", "").replace("]", ""));
                            }
                        }
                    }
                }






            }
        }

    }
}

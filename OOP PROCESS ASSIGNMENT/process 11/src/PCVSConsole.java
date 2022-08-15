
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class PCVSConsole {

    private static Scanner input = new Scanner(System.in);
    private static PCVS pcvs = new PCVS();
    private static int selectCentreName, selectVaccineID, record;


    public static void main(String[] args) {
        int menu = 0;
        while (menu != 20) {
            System.out.println("\n(PCVS) Private Covid-19 Vaccination Menu:");
            System.out.println("1. Sign up");
            System.out.println("2. Record new vaccine batch");
            System.out.println("3. Request vaccination appointment");
            System.out.println();
            System.out.println("5. Debug get all healthcareCentre and admin ");
            System.out.println("6. Debug get all User");
            System.out.println("7. DEBUGG HEalthcare + admin + batch");
            System.out.println("11. Debugg Healthcare + batch");
            System.out.println("8. Debugg Vaccine + batch");
            System.out.println("9. Debugg Instance of Patient");
            System.out.println("14. Debugg validate expiry date");
            System.out.println("20. Quit the program.");
            System.out.print("Menu of choices: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1 -> {
                    System.out.println("\nSign up menu:");
                    System.out.println("1. Sign up as Healthcare Administrator");
                    System.out.println("2. Sign up as Patient");
                    System.out.print("Menu of choices: ");
                    int signup = input.nextInt();
                    input.nextLine();
                    char category;
                    if(signup == 1) {
                        System.out.println("\nCreate your Healthcare Administrator account");
                        System.out.print(pcvs.getAllCentreName());
                        System.out.print("Select the healthcare centre: ");
                        int choice = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        if (choice == 1) {
                            category = 'a';
                            selectCentreName = 1;
                            System.out.println(pcvs.getPCVSHealthcareCentres().get(0));
                            signUpUser(category);
                        } else if (choice == 2) {
                            category = 'a';
                            selectCentreName = 2;
                            System.out.println(pcvs.getPCVSHealthcareCentres().get(1));
                            signUpUser(category);
                        } else if (choice == 3) {
                            category = 'a';
                            selectCentreName = 3;
                            System.out.println(pcvs.getPCVSHealthcareCentres().get(2));
                            signUpUser(category);
                        }
                    }
                    else if(signup == 2) {
                        category = 'p';
                        System.out.println("\nCreate your Patient account");
                        signUpUser(category);
                    }
                }
                case 2 -> {
                    System.out.println("\nSign in");
                    System.out.println("Use your Healthcare Administrator account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    int indexUser = pcvs.loginAdmin(username, password);
                    if (indexUser == -1) {
                        System.out.println("\nCan't find your Healthcare Administrator account");
                    } else {
                        System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(indexUser).getCentreName());
                        System.out.print(pcvs.getAllVaccinesID());
                        System.out.print("Select the vaccine ID: ");
                        selectVaccineID = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        if (selectVaccineID == 1) {
                            System.out.println(pcvs.getPCVSVaccines().get(0));
                            inputBatch(indexUser);
                        } else if (selectVaccineID == 2) {
                            System.out.println(pcvs.getPCVSVaccines().get(1));
                            inputBatch(indexUser);
                        } else if (selectVaccineID == 3) {
                            System.out.println(pcvs.getPCVSVaccines().get(2));
                            inputBatch(indexUser);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\nSign in");
                    System.out.println("Use your Patient account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    int idx = pcvs.loginPatient(username, password);
                    if(idx == -1) {
                        System.out.println("\nCan't find your Patient account");
                    } else {
                        boolean repeat = true;
                        int viewHC = 0;
                        while(repeat) {
                            System.out.println("\nWelcome, " + pcvs.getPCVSUsers().get(idx).getFullName());
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
                                Vaccine VC = pcvs.getPCVSVaccines().get(record-1); //cara akses vaksind dari record supaya gak pake if lagi
                                System.out.println("\nDEBUG " + VC); //print jenis vaccine
                                ArrayList<Integer> tempHC = new ArrayList<>(); // balimed // puri
                                for (int i = 0; i < VC.getBatches().size(); i++) {
                                    int index = pcvs.findVaccineToHealthcareCentre(VC.getBatches().get(i));
                                    if(!tempHC.contains(index))
                                    {
                                        System.out.println(index+1 + ". "+ pcvs.getPCVSHealthcareCentres().get(index));
                                        tempHC.add(index);
                                    }
                                }
                                System.out.println("4. Back to vaccination appointment menu");
                                System.out.print("Select a healthcare centre to view: ");
                                viewHC = input.nextInt();
                                input.nextLine();
                                if(viewHC != 4 )
                                    repeat = false;
                            }
                        }
                        System.out.println(pcvs.findBatch(viewHC, record));
                        System.out.println("Select batch number: ");
                        int selectBatchNum = input.nextInt();
                        input.nextLine();
                        int index = pcvs.findBatch(viewHC, record, selectBatchNum);
                        Vaccine tempVC = pcvs.getPCVSVaccines().get(record-1); 
                        System.out.println(tempVC.getBatches().get(index).getExpiryDate());


                        /*
                        slect hc
                        select vaccine
                        tampilkan batch

                        select hc
                        select vaccine
                        select batch
                        batch.get quantity

                        */





                    }







                }

                case 5 -> {
                    for (int i = 0; i < pcvs.getPCVSHealthcareCentres().size(); i++) {
                        System.out.println("\n===================");
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        System.out.println(pcvs.getPCVSHealthcareCentres().get(i));
                        for (int j = 0; j < HC.getAdministrators().size(); j++) {
                            System.out.println(HC.getAdministrators().get(j));
                        }
                    }
                }
                case 6 -> {
                    //System.out.println(pcvs.getAllPatient());
//                    Debug patient

                    for (int i = 0; i < pcvs.getPCVSUsers().size(); i++) {
                        System.out.println(pcvs.getPCVSUsers().get(i));
                    }
                }
                case 7 -> {
                    for (int i = 0; i < pcvs.getPCVSHealthcareCentres().size(); i++) {
                        System.out.println("\n===================");
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        System.out.println("index: " + i + pcvs.getPCVSHealthcareCentres().get(i));
                        System.out.println();
                        for (int j = 0; j < HC.getAdministrators().size(); j++) {
                            System.out.println("index: " + j + HC.getAdministrators().get(j));
                            System.out.println();
                            for (int k = 0; k < HC.getBatches().size(); k++) {
                                System.out.println("index: " + k + HC.getBatches().get(k));
                                System.out.println();
                            }
                        }
                    }
                }

                case 8 -> {
                    for (int i = 0; i < pcvs.getPCVSVaccines().size(); i++) {
                        System.out.println("\n===================");
                        Vaccine VC = pcvs.getPCVSVaccines().get(i);
                        System.out.println(pcvs.getPCVSVaccines().get(i));
                        for (int j = 0; j < VC.getBatches().size(); j++) {
                            System.out.println("[" + j + "] " +VC.getBatches().get(j));
                        }
                    }
                }

                case 9 -> {
                    System.out.println(pcvs.DebuggloginPatient());
                }

                case 11 -> {
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

                case 13->{
                    //DEBUG
                    for (int i = 0; i < pcvs.getPCVSVaccines().size(); i++) {
                        Vaccine VC = pcvs.getPCVSVaccines().get(i);
                        System.out.println(VC);
                        for (int j = 0; j < VC.getBatches().size(); j++) {
                            System.out.println("[" + i + "] " + pcvs.findHealthcareCentre(VC.getBatches().get(j)));
                        }
                    }

                }

                case 14 -> {
                    HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(0);
                    for(int i = 0; i < HC.getBatches().size(); i++) {

                        int[] array = method(HC.getBatches().get(i).getExpiryDate());
                        for (int j = 0; j < array.length; j++) {
                            System.out.println("[" + j + "] " +  array[j] + " ");
                        }

                        Calendar today = Calendar.getInstance();
                        Calendar expires = Calendar.getInstance();
                        expires.set(array[2], array[0], array[1]);
                        // mm0 dd1 yyyy2

                        if(HC.getBatches().get(i).getQuantityAvailable() > 0 && !today.after(expires)) {
                            System.out.println(HC.getBatches().get(i));
                        }

                    }
                }

                case 15-> {
                    HealthcareCentre tempHC = pcvs.getPCVSHealthcareCentres().get(0); // masih error karena tampilan rumah sakit acak
                    System.out.println(tempHC);
                    for(int i = 0; i < tempHC.getBatches().size(); i++) {
                        int[] splitExpiryDate = method(tempHC.getBatches().get(i).getExpiryDate());

                        Calendar today = Calendar.getInstance();
                        Calendar expires = Calendar.getInstance();
                        expires.set(splitExpiryDate[2], splitExpiryDate[0], splitExpiryDate[1]);

                        if(tempHC.getBatches().get(i).getQuantityAvailable() > 0 && !today.after(expires)) {
                            System.out.println(tempHC.getBatches().get(i));
                        }

                    }

                }

                case 16-> {
                    System.out.println(pcvs.getPCVSHealthcareCentres().get(0));
                }






            }
        }
    }

    public static Integer count = 0;
    public static String generateStaffID() {

        String res5 = count.toString().length() == 1 ? ("00" + count)
            : count.toString().length() == 2 ? ("0" + count) : count.toString();
        count = count + 1;
        String finalResult = "ADM" + res5;
        return finalResult;
    }

    public static void signUpUser(char category) {
        Patient newPatient = new Patient();
        Administrator newAdmin = new Administrator();

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

        if (category == 'p') {
            newPatient.setUsername(username);
            newPatient.setPassword(password);
            newPatient.setEmail(email);
            newPatient.setFullName(fullName);
            System.out.print("Enter IC or passport: ");
            newPatient.setICPassport(input.nextLine());
            pcvs.addUser(newPatient);
            System.out.println("\nSign up success! A Patient account is created.");
        } else if (category == 'a') {
            newAdmin.setUsername(username);
            newAdmin.setPassword(password);
            newAdmin.setEmail(email);
            newAdmin.setFullName(fullName);
            newAdmin.setStaffID(generateStaffID());
            pcvs.addUser(newAdmin);

            if (selectCentreName == 1)
                pcvs.getPCVSHealthcareCentres().get(0).setAdministrator(newAdmin);
            else if (selectCentreName == 2)
                pcvs.getPCVSHealthcareCentres().get(1).setAdministrator(newAdmin);
            else if (selectCentreName == 3)
                pcvs.getPCVSHealthcareCentres().get(2).setAdministrator(newAdmin);

            System.out.println("\nSign up success! A Healthcare Administrator account is created.");
        }
    }

    public static void inputBatch(int index) {
        Batch newBatch = new Batch();

        System.out.print("Enter batch number: ");
        newBatch.setBatchNo(input.nextInt());
        input.nextLine();
        System.out.print("Enter expiry date (mm dd yyyy): ");
        newBatch.setExpiryDate(input.nextLine());
        System.out.print("Quantity of doses available: ");
        newBatch.setQuantityAvailable(input.nextInt());

        if(selectVaccineID == 1)
            pcvs.getPCVSVaccines().get(0).setBatch(newBatch);
        else if(selectVaccineID == 2)
            pcvs.getPCVSVaccines().get(1).setBatch(newBatch);
        else if(selectVaccineID == 3 )
            pcvs.getPCVSVaccines().get(2).setBatch(newBatch);

        if(index == 0)
            pcvs.getPCVSHealthcareCentres().get(0).setBatches(newBatch);
        else if(index == 1)
            pcvs.getPCVSHealthcareCentres().get(1).setBatches(newBatch);
        else if(index == 2)
            pcvs.getPCVSHealthcareCentres().get(2).setBatches(newBatch);

        System.out.println("\nThe batch is recorded for the vaccine and healthcare centre");
    }

    static int[] method(String str)
    {
        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }
}


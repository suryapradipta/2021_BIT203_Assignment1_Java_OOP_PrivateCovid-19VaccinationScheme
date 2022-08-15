//Ini perlu bikin array list berbeda untuk nyimpen admin dan patient?

import java.util.Scanner;

public class PCVSConsole {

    private static Scanner input = new Scanner(System.in);
    private static PCVS pcvs = new PCVS();
    private static int selectCentreName, selectVaccineID;


    public static void main(String[] args) {
        int menu = 0;
        while (menu != 10) {
            System.out.println("\nPrivate Covid-19 Vaccination Menu:");
            System.out.println("1. Sign up");
            System.out.println("2. Record new vaccine batch");
            System.out.println("3. Request vaccination appointment");
            System.out.println();
            System.out.println();
            System.out.println("4. Debugg Vaccine + batch");
            System.out.println("5. Debug get all healthcareCentre and admin ");
            System.out.println("6. Debug get all patient");
            System.out.println("7. DEBUGG HEalthcare + admin + batch");
            System.out.println("10. Quit the program.");
            System.out.print("Menu of choices: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1 -> {
                    System.out.println("\nCreate your Healthcare Administrator account");
                    System.out.println(pcvs.getAllCentreName());
                    System.out.println("Press 0 to sign up as Patient");
                    System.out.print("Select the healthcare centre: ");
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    char category;
                    if(choice == 0) {
                        category = 'p';
                        System.out.println("Create your Patient account");
                        signUpUser(category);
                    }
                    else if(choice == 1) {
                        category = 'a';
                        selectCentreName = 1;
                        System.out.println(pcvs.getPCVSHealthcareCentres().get(0));
                        signUpUser(category);
                        //System.out.println(pcvs.getPCVSHealthcareCentres().get(0).getCentreName());
                    }
                    else if(choice == 2) {
                        category = 'a';
                        selectCentreName = 2;
                        System.out.println(pcvs.getPCVSHealthcareCentres().get(1));
                        signUpUser(category);
                    }
                    else if(choice == 3) {
                        category = 'a';
                        selectCentreName = 3;
                        System.out.println(pcvs.getPCVSHealthcareCentres().get(2));
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
                    if(indexUser == -1) {
                        System.out.println("\nCan't find your Healthcare Administrator account");
                    }
                    else {
                        System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(indexUser).getCentreName());
                        System.out.print(pcvs.getAllVaccines());
                        System.out.print("Select the vaccine ID: ");
                        selectVaccineID = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        if(selectVaccineID == 1) {
                            System.out.println(pcvs.getPCVSVaccines().get(0));
                            inputBatch(indexUser);
                        }
                        else if(selectVaccineID == 2) {
                            System.out.println(pcvs.getPCVSVaccines().get(1));
                            inputBatch(indexUser);
                        }
                        else if(selectVaccineID == 3) {
                            System.out.println(pcvs.getPCVSVaccines().get(2));
                            inputBatch(indexUser);
                        }
                    }
                }
                case 3-> {
                    System.out.println("\nSign in");
                    System.out.println("Use your Patient account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();



                }
                case 4 -> {
                    for(int i = 0; i< pcvs.getPCVSVaccines().size(); i++) {
                        System.out.println("\n===================");
                        Vaccine VC = pcvs.getPCVSVaccines().get(i);
                        System.out.println(pcvs.getPCVSVaccines().get(i));
                        for(int j = 0; j< VC.getBatches().size(); j++) {
                            System.out.println(VC.getBatches().get(j));
                        }
                    }
                }
                case 5-> {
                    for(int i = 0; i< pcvs.getPCVSHealthcareCentres().size(); i++) {
                        System.out.println("\n===================");
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        System.out.println(pcvs.getPCVSHealthcareCentres().get(i));
                        for(int j = 0; j< HC.getAdministrators().size(); j++) {
                            System.out.println(HC.getAdministrators().get(j));
                        }
                    }
                }
                case 6 -> {
                    //System.out.println(pcvs.getAllPatient());
//                    Debug patient

                    for(int i = 0; i< pcvs.getPCVSUsers().size(); i++) {
                            System.out.println(pcvs.getPCVSUsers().get(i));
                    }
                }
                case 7 -> {
                    for(int i = 0; i< pcvs.getPCVSHealthcareCentres().size(); i++) {
                        System.out.println("\n===================");
                        HealthcareCentre HC = pcvs.getPCVSHealthcareCentres().get(i);
                        System.out.println("index: " + i +  pcvs.getPCVSHealthcareCentres().get(i));
                        System.out.println();
                        for(int j = 0; j< HC.getAdministrators().size(); j++) {
                            System.out.println("index: " + j + HC.getAdministrators().get(j));
                            System.out.println();
                            for(int k = 0; k < HC.getBatces().size(); k++) {
                                System.out.println("index: " + k + HC.getBatces().get(k));
                                System.out.println();
                            }

                        }
                    }
                }

                case 8 -> {



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
        System.out.print("Enter expiry date: ");
        newBatch.setExpiryDate(input.nextInt());
        System.out.print("Quantity of doses available: ");
        newBatch.setQuantityAvailable(input.nextInt());

        if(selectVaccineID == 1)
            pcvs.getPCVSVaccines().get(0).setBatch(newBatch);
        else if(selectVaccineID == 2)
            pcvs.getPCVSVaccines().get(1).setBatch(newBatch);
        else if(selectVaccineID == 3 )
            pcvs.getPCVSVaccines().get(2).setBatch(newBatch);

        if(index == 0)
            pcvs.getPCVSHealthcareCentres().get(0).setBatces(newBatch);
        else if(index == 1)
            pcvs.getPCVSHealthcareCentres().get(1).setBatces(newBatch);
        else if(index == 2)
            pcvs.getPCVSHealthcareCentres().get(2).setBatces(newBatch);

        System.out.println("\nThe batch is recorded for the vaccine and healthcare centre");
    }
}


import java.util.Scanner;

public class PCVSConsole {

    public static void main(String[] args) {
        HealthcareCentre centreName1 = new HealthcareCentre("Balimed Hospital", "Jl. Mahendradatta No.57 X");
        HealthcareCentre centreName2 = new HealthcareCentre("RSIA Puri Bunda", "Jl. Gatot Subroto VI No.19");
        HealthcareCentre centreName3 = new HealthcareCentre("Prima Medika Hospital", "Jl. Raya Sesetan No.10");


        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to Vaccination App\n");
        PCVS pcvs = new PCVS(20);
        int menu = 0;
        while (menu != 7) {
            System.out.println("\nVaccination Menu:");
            System.out.println("1. Sign up");
            System.out.println("2. Record new vaccine batch");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. Cek data User");
            System.out.println("6. Cek data Healthcare");
            System.out.println("7. Quit the program.");
            System.out.print("Menu of choices: ");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> {
                    System.out.println("\nCreate your Healthcare Administrator account");
                    System.out.println("1. " + centreName1.getCentreName());
                    System.out.println("2. " + centreName2.getCentreName());
                    System.out.println("3. " + centreName3.getCentreName());
                    System.out.println("Press 0 to create account for Patient");
                    System.out.print("Select the healthcare centre: ");
                    int choice = input.nextInt();
                    input.nextLine();
                    if(choice != 0) {
                        if(choice == 1) {
                            System.out.println(centreName1);
                            System.out.println("\nHealthcare Administrator Sign Up");
                            System.out.print("Enter username: ");
                            String username = input.nextLine();
                            System.out.print("Enter password: ");
                            String password = input.nextLine();
                            System.out.print("Enter email: ");
                            String email = input.nextLine();
                            System.out.print("Enter full name: ");
                            String fullName = input.nextLine();
                            String staffID = generateStaffID();
                            Administrator newAdmin = new Administrator(username, password, email, fullName,staffID);
                            HealthcareCentre adminCentre = new HealthcareCentre(centreName1.getCentreName(), centreName1.getAddress(), newAdmin);
                            if(pcvs.signUpUser(newAdmin) && pcvs.addAdmin(adminCentre))
                                System.out.println("\nSign up success! A Healthcare Administrator account is created.");
                            else
                                System.out.println("\nSign up failed!");
                        }

                        else if(choice == 2) {
                            System.out.println(centreName2);
                            System.out.println("\nHealthcare Administrator Sign Up");
                            System.out.print("Enter username: ");
                            String username = input.nextLine();
                            System.out.print("Enter password: ");
                            String password = input.nextLine();
                            System.out.print("Enter email: ");
                            String email = input.nextLine();
                            System.out.print("Enter full name: ");
                            String fullName = input.nextLine();
                            String staffID = generateStaffID();
                            Administrator newAdmin = new Administrator(username, password, email, fullName,staffID);
                            HealthcareCentre adminCentre = new HealthcareCentre(centreName2.getCentreName(), centreName2.getAddress(), newAdmin);
                            if(pcvs.signUpUser(newAdmin) && pcvs.addAdmin(adminCentre))
                                System.out.println("\nSign up success! A Healthcare Administrator account is created.");
                            else
                                System.out.println("\nSign up failed!");
                        }

                        else if(choice == 3) {
                            System.out.println(centreName3);
                            System.out.println("\nHealthcare Administrator Sign Up");
                            System.out.print("Enter username: ");
                            String username = input.nextLine();
                            while(pcvs.findAccount(username)) {
                                System.out.println("Username telah diambil");
                                System.out.print("Enter username: ");
                                 username = input.nextLine();

                            }
                            System.out.print("Enter password: ");
                            String password = input.nextLine();
                            System.out.print("Enter email: ");
                            String email = input.nextLine();
                            System.out.print("Enter full name: ");
                            String fullName = input.nextLine();
                            String staffID = generateStaffID();
                            Administrator newAdmin = new Administrator(username, password, email, fullName,staffID);
                            HealthcareCentre adminCentre = new HealthcareCentre(centreName3.getCentreName(), centreName3.getAddress(), newAdmin);
                            if(pcvs.signUpUser(newAdmin) && pcvs.addAdmin(adminCentre))
                                System.out.println("\nSign up success! A Healthcare Administrator account is created.");
                            else
                                System.out.println("\nSign up failed!");
                        }
                    }

                    else {

                        System.out.println("\nPatient Sign Up");
                        System.out.print("Enter username: ");
                        String username = input.nextLine();
                        System.out.print("Enter password: ");
                        String password = input.nextLine();
                        System.out.print("Enter email: ");
                        String email = input.nextLine();
                        System.out.print("Enter full name: ");
                        String fullName = input.nextLine();
                        System.out.print("Enter IC or passport: ");
                        String ICPassport = input.nextLine();
                        Patient newPatient = new Patient(username, password, email, fullName, ICPassport);
                        if(pcvs.signUpUser(newPatient))
                            System.out.println("\nSign up success! A Patient account is created.");
                        else
                            System.out.println("\nSign up failed!");
                    }
                }
                case 2 -> {
                    System.out.println("\nSign in");
                    System.out.println("Use your Healthcare Administrator account");
                    System.out.print("Enter username: ");
                    String username = input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    System.out.println(pcvs.findAccount(username, password));



                }
                case 5 -> {
                    System.out.println(pcvs.getAll());
                }
                case 6 -> {
                    System.out.println(pcvs.getCentre());
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


}

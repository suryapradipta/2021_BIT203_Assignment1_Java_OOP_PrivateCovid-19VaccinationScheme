import java.util.Scanner;

public class PCVSConsole {

    private static Scanner input = new Scanner(System.in);
    private static PCVS pcvs = new PCVS();
    private static int selectCentreName;
    public static void main(String[] args) {




        int menu = 0;
        while (menu != 7) {
            System.out.println("\nVaccination Menu:");
            System.out.println("\t1. Sign up");
            System.out.println("\t2. Record new vaccine batch");
            System.out.println("\t3. ");
            System.out.println("\t4. ");
            System.out.println("\t5. ");
            System.out.println("\t6. Get all patient");
            System.out.println("\t7. Quit the program.");
            System.out.print("Menu of choices: ");
            menu = input.nextInt();
            input.nextLine();

            String username, password, email, fullName, ICPassport;
            char category;

            switch (menu) {
                case 1 -> {
                    System.out.println("\nCreate your Healthcare Administrator account");
                    System.out.println(pcvs.getAllHealthcareCentres());
                    System.out.println("Press 0 to sign up as Patient");
                    System.out.print("Select the healthcare centre: ");
                    int choice = input.nextInt();
                    input.nextLine();
                    if(choice == 0) {
                        category = 'p';
                        System.out.println("\nCreate your Patient account");
                        signUpUser(category);
                    }
                    else if(choice == 1) {
                        category = 'a';
                        selectCentreName = 1;
                        System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(0));
                        signUpUser(category);
                    }
                    else if(choice == 2) {
                        category = 'a';
                        selectCentreName = 2;
                        System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(1));
                        signUpUser(category);
                    }
                    else if(choice == 3) {
                        category = 'a';
                        selectCentreName = 3;
                        System.out.println("\n" + pcvs.getPCVSHealthcareCentres().get(2));
                        signUpUser(category);
                    }

                }
                case 4 -> {
                    System.out.println(pcvs.getPCVSHealthcareCentres().get(0).getCentreName());
                }
                case 5-> {
                    System.out.println(pcvs.getAllHealthcareCentres());
                }
                case 6 -> {
                    System.out.println(pcvs.getAllPatient());
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
            System.out.println();
            System.out.println(newPatient);
            System.out.println("\nSign up success! A Patient account is created.");
        } else if (category == 'a') {
            newAdmin.setUsername(username);
            newAdmin.setPassword(password);
            newAdmin.setEmail(email);
            newAdmin.setFullName(fullName);
            newAdmin.setStaffID(generateStaffID());
            pcvs.addUser(newAdmin);
            System.out.println();
            System.out.println(newAdmin);

            if (selectCentreName == 1)
                pcvs.getPCVSHealthcareCentres().get(0).setAdministrator(newAdmin);
            else if (selectCentreName == 2)
                pcvs.getPCVSHealthcareCentres().get(1).setAdministrator(newAdmin);
            else if (selectCentreName == 3)
                pcvs.getPCVSHealthcareCentres().get(2).setAdministrator(newAdmin);

            System.out.println("\nSign up success! A Healthcare Administrator account is created.");
        }
    }
}


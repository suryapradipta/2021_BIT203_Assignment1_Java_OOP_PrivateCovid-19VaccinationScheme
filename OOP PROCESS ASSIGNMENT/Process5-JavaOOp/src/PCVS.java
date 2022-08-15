import java.util.ArrayList;

public class PCVS {
    private ArrayList<HealthcareCentre> PCVSHealthcareCentres; // array list to hold collection healthcare centre
    private ArrayList<User> PCVSUsers;
    private ArrayList<Vaccine> PCVSVaccines;


    /*
     * Constructor
     * */
    public PCVS() {
        PCVSHealthcareCentres = new ArrayList<>(); // instantiate a new array object
        PCVSHealthcareCentres.add(new HealthcareCentre("Balimed Hospital", "Jl. Mahendradatta No.57 X"));
        PCVSHealthcareCentres.add(new HealthcareCentre("RSIA Puri Bunda", "Jl. Gatot Subroto VI No.19"));
        PCVSHealthcareCentres.add(new HealthcareCentre( "Prima Medika Hospital", "Jl. Raya Sesetan No.10"));

        PCVSUsers = new ArrayList<>();

        PCVSVaccines = new ArrayList<>();
        PCVSVaccines.add(new Vaccine("JNJ", "Janssen Pharmaceutical Companies", "Johnson & Johnson"));
        PCVSVaccines.add(new Vaccine("ASZ", "AstraZeneca, University of Oxford", "AstraZeneca"));
        PCVSVaccines.add(new Vaccine("MOD", "Moderna, NIAID", "Moderna"));

    }







    // USER COLLECTION
    public ArrayList<User> getPCVSUsers() {
        return PCVSUsers;
    }


    public void addUser(User newUser)
    {
        PCVSUsers.add(newUser);
    }

    public String DEBUGgetAllPatient() {
        String all = "";
        for (int i = 0; i < PCVSUsers.size(); i++) { // looping
            all += i+1  + ". " + PCVSUsers.get(i) + "\n";
        }
        return all;
    }
    // USER COLLECTION END










    // HEALTHCARE COLLECTION
    public ArrayList<HealthcareCentre> getPCVSHealthcareCentres() { // getter
        return PCVSHealthcareCentres;
    }

    public String getAllCentreName() {
        String all = "";
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) { // looping
            all += i+1  + ". " + getPCVSHealthcareCentres().get(i).getCentreName() + "\n";
        }
        return all;
    }


    /*public Object findVaccineBatch() {
        for(int i = 0; i < getPCVSVaccines().size(); i++) {
            Vaccine VC = getPCVSVaccines().get(i);
            for (int j = 0; j < VC.getBatches().size(); j++) {
                return VC.getBatches().get(j);
            }
        }
        return null;
    }*/

    public String findHealthcareCentre(Batch batch) {
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) {
            HealthcareCentre HC = getPCVSHealthcareCentres().get(i);
            for (int j = 0; j < HC.getBatches().size(); j++) {
                if(HC.getBatches().get(j).equals(batch))
                    return "[" + i  + "] " + HC;
            }
        }
        return null;
    }





    public int findHealthcareCentreBatch(Batch batch) {
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) {
            HealthcareCentre HC = getPCVSHealthcareCentres().get(i);
            for (int j = 0; j < HC.getBatches().size(); j++) {
                if(HC.getBatches().get(j).equals(batch))
                    return i;
            }
        }
        return -1;
    }

    public int findVaccineBatch(int index) {
        Vaccine VC = getPCVSVaccines().get(index);
        for (int j = 0; j < VC.getBatches().size(); j++) {
            findHealthcareCentreBatch(VC.getBatches().get(j));
            return j;
        }
        return -1;
    }

    // HEALTHCARE COLLECTION END











    //VALIDATION USER LOGIN
    /*public String findUser(String username, String password)
    {
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++)
        {
            HealthcareCentre HC = getPCVSHealthcareCentres().get(i);
            for(int j =0; j < HC.getAdministrators().size(); j++) {
                if (HC.getAdministrators().get(j).getUsername().equals(username))
                    if(HC.getAdministrators().get(j).getPassword().equals(password))
                        return HC.getCentreName();
            }
        }
        return null;
    }*/
    public int loginAdmin(String username, String password)
    {
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++)
        {
            HealthcareCentre HC = getPCVSHealthcareCentres().get(i);
            for(int j =0; j < HC.getAdministrators().size(); j++) {
                if (HC.getAdministrators().get(j).getUsername().equals(username))
                    if(HC.getAdministrators().get(j).getPassword().equals(password))
                        return i;
            }
        }
        return -1;
    }


    public String DebuggloginPatient() {
        String all = "";
        for (int i = 0; i < getPCVSUsers().size(); i++) {
            if (getPCVSUsers().get(i) instanceof Patient) {
                Patient patient = (Patient) getPCVSUsers().get(i);
                all += i + ". " + patient + "\n";
            }
        }
        return all;
    }


    public int loginPatient(String username, String password) {

        for (int i = 0; i < getPCVSUsers().size(); i++) {
            if (getPCVSUsers().get(i) instanceof Patient) {
                Patient patient = (Patient) getPCVSUsers().get(i); //downcast
                if(patient.getUsername().equals(username))
                    if(patient.getPassword().equals(password))
                    return i;
            }
        }
        return -1;
    }















        // VALIDATION USER LOGIN END











        //VACCINE
        public ArrayList<Vaccine> getPCVSVaccines() {
            return PCVSVaccines;
        }

        public String getAllVaccinesID() {
            String all = "";
            for (int i = 0; i < getPCVSVaccines().size(); i++) { // looping
                all += i+1  + ". " + getPCVSVaccines().get(i).getVaccineID() + "\n";
            }
            return all;
        }

        public String getAllVaccines() {
            String all = "";
            for (int i = 0; i < getPCVSVaccines().size(); i++) { // looping
                all += i+1  + ". " + getPCVSVaccines().get(i) + "\n";
            }
            return all;
        }


        public String availableVaccines() {
            String all = "";
            int number = 1;
            for (int i = 0; i < getPCVSVaccines().size(); i++) {
                Vaccine VC = getPCVSVaccines().get(i);
                for (int j = 0; j < VC.getBatches().size(); j++) {
                    if(VC.getBatches().get(j).getQuantityAvailable() > 0)
                        all += number++ + ". "+ VC.getVaccineName() +
                             " vaccine available in  " + VC.getBatches().get(j).getQuantityAvailable() +
                            " quantities" + "\n";
                }
            }
            return all;
            // jika tidak null, maka akan tampilkan vaccine
        }



        //VACIINE END






        // VALIDATION USEERNAME
        public boolean validateUsername(String username) {
            for (int i = 0; i < getPCVSUsers().size(); i++)
                if (getPCVSUsers().get(i).getUsername().equalsIgnoreCase(username))
                    return true;
            return false;
        }

        //VALIDATION USERNAME END



    }


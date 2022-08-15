import java.util.*;

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

    public ArrayList<Vaccine> getPCVSVaccines() {
        return PCVSVaccines;
    }

    public String getAllCentreName() {
        String all = "";
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) { // looping
            all += i+1  + ". " + getPCVSHealthcareCentres().get(i).getCentreName() + "\n";
        }
        return all;
    }



    public HealthcareCentre findHealthcareCentre(Batch batch) {
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) {
            HealthcareCentre HC = getPCVSHealthcareCentres().get(i);

            for (int j = 0; j < HC.getBatches().size(); j++) {
                if(HC.getBatches().get(j).equals(batch))
                    return  HC; // to string
            }
        }
        return null;


    }
    public int findVaccineToHealthcareCentre(Batch batch) { // coba return integer
        for (int i = 0; i < getPCVSHealthcareCentres().size(); i++) {
            HealthcareCentre HC = getPCVSHealthcareCentres().get(i);

            for (int j = 0; j < HC.getBatches().size(); j++) {
                if (HC.getBatches().get(j).equals(batch))
                    return i; // to string
            }
        }
        return -1;
    }

    public int findVaccinationBatch(Vaccination vaccination) {
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                Batch tempBatch = tempVC.getBatches().get(j);

                for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                    if(tempBatch.getVaccinations().get(k).equals(vaccination))
                        return k;
                }

            }
        }
        return -1;
    }



    public int findVaccinationID(int iBatchNum, String vacID){
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                if(tempVC.getBatches().get(j).getBatchNo() == iBatchNum) {
                    Batch tempBatch = tempVC.getBatches().get(j);
                    for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                        if(tempBatch.getVaccinations().get(k).getVaccinationID().equals(vacID))
                            return k;
                    }
                }
            }
        }
        return -1;
    }


    static int[] method(String str) // split array
    {
        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

    public boolean appointmentDate(int indexHC, int indexVC, String appointmentDate) {
        HealthcareCentre HC = getPCVSHealthcareCentres().get(indexHC-1);

        for (int i = 0; i < HC.getBatches().size(); i++) {
            int[] splitExpiryDate = method(HC.getBatches().get(i).getExpiryDate()); // split to array expiry date
            Calendar expires = Calendar.getInstance();
            expires.set(splitExpiryDate[2], splitExpiryDate[0], splitExpiryDate[1]);

            int[] splitAppointmentDate = method(appointmentDate);
            Calendar appointment = Calendar.getInstance();
            appointment.set(splitAppointmentDate[2], splitAppointmentDate[0], splitAppointmentDate[1]);
            if(expires.after(appointment))
                return false;
        }

        return true;
    }


    public String findBatch(int indexHC, int indexVC) { // nyari batch di use case3.5
        StringBuilder all = new StringBuilder();
        HealthcareCentre HC = getPCVSHealthcareCentres().get(indexHC-1);
        Vaccine VC = getPCVSVaccines().get(indexVC-1);


        for (int i = 0; i < HC.getBatches().size(); i++) {

            int[] splitExpiryDate = method(HC.getBatches().get(i).getExpiryDate()); // split to array expiry date
            Calendar today = Calendar.getInstance();
            Calendar expires = Calendar.getInstance();
            expires.set(splitExpiryDate[2], splitExpiryDate[0], splitExpiryDate[1]);

            for(int j = 0; j < VC.getBatches().size(); j++) {
                if (HC.getBatches().get(i).equals(VC.getBatches().get(j)) &&
                    HC.getBatches().get(i).getQuantityAvailable() > 0 &&
                    !today.after(expires)) {
                        all.append("" + "\n").append(VC.getBatches().get(j)).append("\n");
                    //return Arrays.toString(VC.getBatches().toArray()).replace("[", "").replace("]", "");

                }
            }
        }
        return all.toString();
    }


    public int findBatch(int indexHC, int indexVC, int selectBatchNum) { // select batch number to show expiry date
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
    }
   /* public String findBatch() {
        String all = "";
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            all += tempVC + "\n";
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                int[] splitExpiryDate = method(tempVC.getBatches().get(j).getExpiryDate()); // split to array expiry date
                Calendar today = Calendar.getInstance();
                Calendar expires = Calendar.getInstance();
                expires.set(splitExpiryDate[2], splitExpiryDate[0], splitExpiryDate[1]);
                if (tempVC.getBatches().get(j).getQuantityAvailable() > 0 &&
                    !today.after(expires)) {
                    all += tempVC.getBatches().get(j) + "\n";
                }
            }
        }
        return all;
    }*/

    public String findBatch() {
        String all = "";
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            //all += "" + "\n" + tempVC;
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                Batch tempBatch = tempVC.getBatches().get(j);
                for(int k = 0; k < tempBatch.getVaccinations().size(); k++) {
                    if(tempBatch.getVaccinations().get(k).getStatus().equals("pending")) {
                        all+= tempBatch + "\n";
                    }
                }
            }
        }
        return all;
    }


    public int getNumOfPending() {
        int numOfPending = 0;
        for (int i = 0; i < getPCVSUsers().size(); i++) {
            if (getPCVSUsers().get(i) instanceof Patient) {
                Patient tempPatient = (Patient) getPCVSUsers().get(i);
                for(int j = 0; j < ((Patient) getPCVSUsers().get(i)).getVaccinations().size(); j ++ ) {
                    if(tempPatient.getVaccinations().get(j).getStatus().equals("pending"))
                        numOfPending++;
                }
            }
        }
        return numOfPending;
    }

    public int getQuantityAdministered() {
        int qtyAdministered = 0;
        for (int i = 0; i < getPCVSVaccines().size(); i++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size();j++) {
                qtyAdministered+= tempVC.getBatches().get(j).getQuantityAdministered();
            }
        }
        return qtyAdministered;

    }


    /*public String selectBatch(int inIndex) {
        String all = "";
        for(int i = 0; i < getPCVSVaccines().size(); i ++) {
            Vaccine tempVC = getPCVSVaccines().get(i);
            for(int j = 0; j < tempVC.getBatches().size(); j++) {
                if(tempVC.getBatches().get(j).getBatchNo() == inIndex) {
                    return tempVC.getBatches().get(inIndex).getExpiryDate();
                    tempVC.getBatches().get(inIndex).getQuantityAvailable();
                }
            }
        }
    }*/




















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


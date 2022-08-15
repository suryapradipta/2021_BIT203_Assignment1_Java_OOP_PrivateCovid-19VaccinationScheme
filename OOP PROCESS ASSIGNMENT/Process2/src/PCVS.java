import java.util.ArrayList;

public class PCVS {
    private ArrayList<HealthcareCentre> PCVSHealthcareCentres; // array list to hold collection healthcare centre
    private ArrayList<User> PCVSUsers; // Apakah boleh satu saja pakai koleksi user atau pakai koleksi admin dan patient?

    public PCVS() {
        PCVSHealthcareCentres = new ArrayList<>(); // instantiate a new array object
        PCVSHealthcareCentres.add(new HealthcareCentre("Balimed Hospital", "Jl. Mahendradatta No.57 X"));
        PCVSHealthcareCentres.add(new HealthcareCentre("RSIA Puri Bunda", "Jl. Gatot Subroto VI No.19"));
        PCVSHealthcareCentres.add(new HealthcareCentre( "Prima Medika Hospital", "Jl. Raya Sesetan No.10"));
        PCVSUsers = new ArrayList<>();
    }

    /*public ArrayList<HealthcareCentre> getPCVSHealthcareCentres() { // Getter
        for (int i = 0; i < PCVSHealthcareCentres.size(); i++) {
            System.out.println(getPCVSHealthcareCentres().get(i));
        }

        return PCVSHealthcareCentres;
    }*/

    public void setEmployees() //setter
    {
        if (PCVSHealthcareCentres == null)
            PCVSHealthcareCentres =  new ArrayList<HealthcareCentre>();
    }

    public ArrayList<HealthcareCentre> getPCVSHealthcareCentres() { // getter
        return PCVSHealthcareCentres;
    }

    public String getAllHealthcareCentres() {
        String all = "";
        for (int i = 0; i < PCVSHealthcareCentres.size(); i++) { // looping
                all += i+1  + ". " + PCVSHealthcareCentres.get(i)+ "\n";
        }
        return all;
    }


    public ArrayList<User> getPCVSUsers() {
        return PCVSUsers;
    }

    public void setPCVSUser(ArrayList<User> PCVSUsers) {
        this.PCVSUsers = PCVSUsers;
    }
    public void addUser(User newUser)
    {
        PCVSUsers.add(newUser);
    }

    public String getAllPatient() {
        String all = "";
        for (int i = 0; i < PCVSUsers.size(); i++) { // looping
            all += i+1  + ". " + PCVSUsers.get(i) + "\n";
        }
        return all;
    }







}


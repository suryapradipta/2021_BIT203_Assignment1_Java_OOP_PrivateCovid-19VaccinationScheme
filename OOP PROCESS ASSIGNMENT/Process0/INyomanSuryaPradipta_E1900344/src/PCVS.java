import java.lang.constant.Constable;

public class PCVS {
    private final int SIZE = 50;	// default size
    private final User[] user; // an array to hold User objects
    private int numOfUsers;


    private final HealthcareCentre[] healthcareCentres;
    private int numOfCentre;



    // no-args constructor
    public PCVS() {
        user = new User[SIZE];
        numOfUsers = 0;
        healthcareCentres = new HealthcareCentre[SIZE];
        numOfCentre = 0;

    }

    // Constructor with arguments
    public PCVS(int size)
    {
        if (size <= 0) {
            // invalid size
            user = new User[SIZE];
            healthcareCentres = new HealthcareCentre[SIZE];
        }

        else{
            healthcareCentres = new HealthcareCentre[size];
            user = new User[size];
        }

        numOfUsers = 0;
        numOfCentre = 0;
    }


    // method allows client to add object to the container
    public boolean signUpUser(User newUser)
    {
        if (numOfUsers == user.length)	// array full!
            return false;
        user[numOfUsers] = newUser;		// add to array
        numOfUsers++;	   // no. of objects increased by 1
        return true;
    }

    public boolean addAdmin(HealthcareCentre newAdmin)
    {
        if (numOfCentre == healthcareCentres.length)	// array full!
            return false;
        healthcareCentres[numOfCentre] = newAdmin;		// add to array
        numOfCentre++;	   // no. of objects increased by 1
        return true;
    }

    public Constable findAccount(String username, String password) {
        for (int i = 0; i < numOfCentre; i++)
            if (healthcareCentres[i].getAdmin().getUsername().equalsIgnoreCase(username) &&
            healthcareCentres[i].getAdmin().getPassword().equalsIgnoreCase(password))
                return healthcareCentres[i].getCentreName();
        return "Not found!";
        //return null;
    }


    public boolean findAccount(String username) {
        for (int i = 0; i < numOfCentre; i++)
            if (healthcareCentres[i].getAdmin().getUsername().equalsIgnoreCase(username))
                return true;
        return false;
    }





    public String getAll() {
        String all = "";
        for (int i = 0; i < numOfUsers; i++) { // looping
            all += user[i].toString() + "\n"; // digabung dengan satu baris baru // array list pakai get[i]
        }
        return all;
    }
    public String getCentre() {
        String all = "";
        for (int i = 0; i < numOfCentre; i++) { // looping
            all += healthcareCentres[i].toString() + "\n"; // digabung dengan satu baris baru
        }
        return all;
    }







}

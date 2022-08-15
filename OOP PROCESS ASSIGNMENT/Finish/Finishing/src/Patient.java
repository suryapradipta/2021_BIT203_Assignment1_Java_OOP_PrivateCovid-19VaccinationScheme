import java.util.ArrayList;

public class Patient extends User {
    private String ICPassport;

    private ArrayList<Vaccination> vaccinations;

    public Patient() {
        this("unknown", "unknown", "unknown", "unknown", "unknown");
    }

    public Patient(String username, String password, String email, String fullName, String ICPassport) {
        super(username, password, email, fullName);
        this.ICPassport = ICPassport;
        this.vaccinations = new ArrayList<>();
    }

    public ArrayList<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Vaccination newVaccinations) {
        this.vaccinations.add(newVaccinations);
    }

    public String getICPassport() {
        return ICPassport;
    }

    public void setICPassport(String ICPassport) {
        this.ICPassport = ICPassport;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nIC Passport: " + ICPassport + "\n";
    }
}

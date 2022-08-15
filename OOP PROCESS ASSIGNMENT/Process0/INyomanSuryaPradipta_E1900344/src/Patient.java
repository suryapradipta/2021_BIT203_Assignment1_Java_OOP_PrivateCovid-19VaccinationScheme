
public class Patient extends User {
    private String ICPassport;

    public Patient() {
        this("unknown", "unknown", "unknown", "unknown", "unknown");
    }

    // concrete class
    /*
     * kelas konkret yang merupakan kebalikan dari kelas abstrak.
     * Kelas concrete adalah kelas yang tidak dideklarasikan dengan kata kunci abstrak
     * dan tidak memiliki metode abstrak, yaitu semua metode memiliki implementasi.*/
    public Patient(String username, String password, String email, String fullName, String ICPassport) {
        super(username, password, email, fullName);
        this.ICPassport = ICPassport;
    }

    public String getICPassport() {
        return ICPassport;
    }



    @Override
    public String toString() {
        return super.toString() +
            "\nIC Passport: " + ICPassport;
    }
}

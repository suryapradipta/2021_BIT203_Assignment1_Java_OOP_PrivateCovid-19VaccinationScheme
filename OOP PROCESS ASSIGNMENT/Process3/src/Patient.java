public class Patient extends User{
    private String ICPassport;

    public Patient() {
        this("unknown", "unknown", "unknown", "unknown", "unknown");
    }

    public Patient(String username, String password, String email, String fullName, String ICPassport) {
        super(username, password, email, fullName);
        this.ICPassport = ICPassport;
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
            "\nIC Passport: " + ICPassport;
    }
}

public class Administrator extends User {
    private String staffID;

    public Administrator() {
        this("unknown", "unknown", "unknown", "unknown", "unknown");
    }

    public Administrator(String username, String password, String email, String fullName, String staffID) {
        super(username, password, email, fullName);
        this.staffID = staffID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nStaff ID: " + staffID;
    }


}
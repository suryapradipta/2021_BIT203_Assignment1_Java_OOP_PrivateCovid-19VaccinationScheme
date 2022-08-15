
public class Administrator extends User {
    private String staffID;

    // concrete class
    /*
    * kelas konkret yang merupakan kebalikan dari kelas abstrak.
    * Kelas concrete adalah kelas yang tidak dideklarasikan dengan kata kunci abstrak
    * dan tidak memiliki metode abstrak, yaitu semua metode memiliki implementasi.*/
    public Administrator(String username, String password, String email, String fullName, String staffID) {
        super(username, password, email, fullName);
        this.staffID = staffID;
    }


    public boolean equals(Object obj) {
        if (this == obj) // same object
            return true;
        if (!(obj instanceof Administrator)) // not correct class!
            return false;
        Administrator rhs = (Administrator) obj; // downcast
        if (this.getUsername() == rhs.getUsername())
            return true;		// employee number is unique
        else			// so it is same employee
            return false;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nStaff ID: " + staffID;
    }
}

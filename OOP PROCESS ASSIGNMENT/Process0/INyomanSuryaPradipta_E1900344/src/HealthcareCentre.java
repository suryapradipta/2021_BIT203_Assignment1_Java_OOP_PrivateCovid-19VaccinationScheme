public class HealthcareCentre {
    private String centreName;
    private String address;

    //aggregation
    private Administrator admin;


    public HealthcareCentre() {
        centreName = "unknown";
        address = "unknown";
    }

    public HealthcareCentre(String centreName, String address, Administrator admin) {
        this.centreName = centreName;
        this.address = address;
        this.admin = admin;
    }

    public HealthcareCentre(String centreName, String address) {
        this.centreName = centreName;
        this.address = address;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public String getCentreName() {
        return centreName;
    }

    public String getAddress() {
        return address;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // method which finds one of the objects given some search value



    public boolean equals(Object obj) {
        if(this == obj) // same object
            return true;
        if(!(obj instanceof HealthcareCentre)) // not correct class!
            return false;
        HealthcareCentre rhs = (HealthcareCentre) obj; // downcast
        if ((this.admin.getUsername() == rhs.admin.getUsername()))
            return true;		// all attributes equal
        else
            return false;

    }

    public String toString() {
        if(admin == null) {
            return centreName + " is located at " +
                address;
        }
        else
            return centreName + " is located at " +
                address + "\n" + admin;

    }
}


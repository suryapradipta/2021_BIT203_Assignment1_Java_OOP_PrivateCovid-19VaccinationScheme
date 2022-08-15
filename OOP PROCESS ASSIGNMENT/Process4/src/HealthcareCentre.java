import java.util.ArrayList;

public class HealthcareCentre {
    private String centreName;
    private String address;

    private ArrayList<Administrator> administrators;
    private ArrayList<Batch> batces;

    public HealthcareCentre(String centreName, String address) {
        this.centreName = centreName;
        this.address = address;
        this.administrators = new ArrayList<>();
        this.batces = new ArrayList<>();
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }
    public void setAdministrator(Administrator inAdmin) {
        this.administrators.add(inAdmin);
    }

    public ArrayList<Batch> getBatces() {
        return batces;
    }

    public void setBatces(Batch inBatch) {
        this.batces.add(inBatch);
    }


    /*public void setAdministrators(ArrayList<Administrator> administrators) {
        this.administrators = administrators;
    }*/

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

    @Override
    public String toString() {
        return centreName + " is located at " + address;
    }


}

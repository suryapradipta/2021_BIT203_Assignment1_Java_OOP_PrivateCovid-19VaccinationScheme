import java.util.ArrayList;

public class HealthcareCentre {
    private String centreName;
    private String address;
    private ArrayList<Administrator> administrators;
    private ArrayList<Batch> batches;

    public HealthcareCentre(String centreName, String address) {
        this.centreName = centreName;
        this.address = address;
        this.administrators = new ArrayList<>();
        this.batches = new ArrayList<>();
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }
    public void setAdministrator(Administrator inAdmin) {
        this.administrators.add(inAdmin);
    }

    public ArrayList<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Batch inBatch) {
        this.batches.add(inBatch);
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

    @Override
    public String toString() {
        return centreName + " is located at " + address;
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HealthcareCentre {
    private String centreName;
    private String address;

    private ArrayList<Administrator> administrators;

    public HealthcareCentre(String centreName, String address) {
        this.centreName = centreName;
        this.address = address;
        this.administrators = new ArrayList<>();
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }
    public void setAdministrator(Administrator inAdminObj) {
        this.administrators.add(inAdminObj);
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
    /*public String toString() {
        return centreName + " is located at " + address + "\n";
    }*/

    @Override
    public String toString() {
        if(administrators.isEmpty())
            return centreName + " is located at " + address + "\n";
        else
            return centreName + " is located at " + address + administrators;

    }


}

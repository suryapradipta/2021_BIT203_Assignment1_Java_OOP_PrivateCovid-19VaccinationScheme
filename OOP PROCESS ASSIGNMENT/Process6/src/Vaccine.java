import java.util.ArrayList;

public class Vaccine {
    private String vaccineID;
    private String manufacturer;
    private String vaccineName;

    private ArrayList<Batch> batches;

    public Vaccine() {
        this(" ", " ", " ");
    }

    public Vaccine(String vaccineID, String manufacturer, String vaccineName) {
        this.vaccineID = vaccineID;
        this.manufacturer = manufacturer;
        this.vaccineName = vaccineName;
        this.batches = new ArrayList<>();
    }

    public ArrayList<Batch> getBatches() {
        return batches;
    }

    public void setBatch(Batch inBatch) {
        this.batches.add(inBatch);
    }

    public String getVaccineID() {
        return vaccineID;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    @Override
    public String toString() {
        return vaccineName + " vaccine, developed by " + manufacturer;

    }
}



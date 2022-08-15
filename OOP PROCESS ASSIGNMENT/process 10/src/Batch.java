import java.util.ArrayList;

public class Batch {
    private int batchNo;
    private String expiryDate;
    private int quantityAvailable; // jumlah dosis
    private int quantityAdministered;

    private ArrayList<Vaccination> vaccinations;


    public Batch() {
        this(0,"",0,0);
    }

    public Batch(int batchNo, String expiryDate, int quantityAvailable, int quantityAdministered) {
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.quantityAvailable = quantityAvailable;
        this.quantityAdministered = quantityAdministered;
        this.vaccinations = new ArrayList<>();
    }

    public ArrayList<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Vaccination newVaccinations) {
        this.vaccinations.add(newVaccinations);
    }

    public int getBatchNo() {
        return batchNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public int getQuantityAdministered() {
        return quantityAdministered;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setQuantityAdministered(int quantityAdministered) {
        this.quantityAdministered = quantityAdministered;
    }

    @Override
    public String toString() {
        return "Batch information:" +
            "\nBatch number: " + batchNo +
            "\nExpiry date: " + expiryDate +
            "\nQuantity available: " + quantityAvailable;
    }
}

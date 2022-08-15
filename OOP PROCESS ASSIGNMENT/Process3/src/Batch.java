public class Batch {
    private int batchNo;
    private int expiryDate;
    private int quantityAvailable; // jumlah dosis
    private int quantityAdministered;

    public Batch() {
        this(0,0,0,0);
    }

    public Batch(int batchNo, int expiryDate, int quantityAvailable, int quantityAdministered) {
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.quantityAvailable = quantityAvailable;
        this.quantityAdministered = quantityAdministered;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public int getExpiryDate() {
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

    public void setExpiryDate(int expiryDate) {
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
        return "\nDetail information:" +
            "\nBatch number: " + batchNo +
            "\nExpiry date: " + expiryDate +
            "\nQuantity available: " + quantityAvailable;
    }
}

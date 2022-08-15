public class Batch {
    private int batchNo;
    private int expiryDate;
    private int quantityAvailable;
    private int quantityAdministered;

    public Batch(int batchNo, int expiryDate, int quantityAvailable, int quantityAdministered) {
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.quantityAvailable = quantityAvailable;
        this.quantityAdministered = quantityAdministered;
    }

}

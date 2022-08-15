public class Vaccination {
    private String vaccinationID;
    private String appointmentDate;
    private String status;
    private String remarks; // num of pending

    public Vaccination() {
        this("","","","");
    }


    public Vaccination(String vaccinationID, String appointmentDate, String status, String remarks) {
        this.vaccinationID = vaccinationID;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.remarks = remarks;
    }

    public String getVaccinationID() {
        return vaccinationID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setVaccinationID(String vaccinationID) {
        this.vaccinationID = vaccinationID;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Vaccination ID: " + vaccinationID +
            "\nAppointment date: " + appointmentDate +
            "\nStatus: " + status+ "\n";
    }
}

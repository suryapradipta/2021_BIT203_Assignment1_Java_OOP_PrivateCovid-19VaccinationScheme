/**
 * Vaccination class defines a simple object type that represents a Vaccination.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 25 November 2021
 * Java version: java 17 2021-09-14 LTS
 * IDE : IntelliJ IDEA
 */

public class Vaccination {
    private String vaccinationID;
    private String appointmentDate;
    private String status;
    private String remarks;

    /**
     * The default constructor used to initialise the default value.
     */
    public Vaccination() {
        this("unknown","unknown","unknown","unknown");
    }

    /**
     * A constructor with three argument,
     * which is used to initialise attribute of Vaccination object.
     * @param vaccinationID accept and initialize new value to vaccinationID.
     * @param appointmentDate accept and initialize new value to appointmentDate.
     * @param status accept and initialize new value to status.
     * @param remarks accept and initialize new value to remarks.
     */
    public Vaccination(String vaccinationID, String appointmentDate, String status, String remarks) {
        this.vaccinationID = vaccinationID;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.remarks = remarks;
    }

    /**
     * The getVaccinationID getter method, which is used to get
     * the vaccinationID of Vaccination object
     * @return a String value of vaccinationID.
     */
    public String getVaccinationID() {
        return vaccinationID;
    }

    /**
     * The getAppointmentDate getter method, which is used to get
     * the appointmentDate of Vaccination object
     * @return a String value of appointmentDate.
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * The getRemarks getter method, which is used to get
     * the remarks of Vaccination object
     * @return a String value of remarks.
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * The getStatus getter method, which is used to get
     * the status of Vaccination object
     * @return a String value of status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * The setVaccinationID setter method, which is used to
     * assign new value to vaccinationID attribute.
     * @param vaccinationID to assign a parameter value to the vaccinationID attribute.
     */
    public void setVaccinationID(String vaccinationID) {
        this.vaccinationID = vaccinationID;
    }

    /**
     * The setAppointmentDate setter method, which is used to
     * assign new value to appointmentDate attribute.
     * @param appointmentDate to assign a parameter value to the appointmentDate attribute.
     */
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * The setStatus setter method, which is used to
     * assign new value to status attribute.
     * @param status to assign a parameter value to the status attribute.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * The setRemarks setter method, which is used to
     * assign new value to remarks attribute.
     * @param remarks to assign a parameter value to the remarks attribute.
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * The toString query method, which is used to return
     * the detail information of the Vaccination object.
     * @return String detail information of the Vaccination object.
     */
    @Override
    public String toString() {
        return "Vaccination ID: " + vaccinationID +
            "\nAppointment date: " + appointmentDate +
            "\nStatus: " + status+ "\n";
    }
}

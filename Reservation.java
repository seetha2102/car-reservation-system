package oop_assignment;
// Class representing a Reservation object
public class Reservation { // Fields to store reservation details
    
    private String resID;
    private String startDate;
    private double startTime;
    private String endDate;
    private double endTime;

    public Reservation(String resID,String startDate, double startTime, String endDate, double endTime) { // Constructor to initialize a Reservation object with provided details
        this.resID = resID;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }
// Getter and setter methods for the fields
    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

   
}


package oop_assignment;

// Class representing a Customer object
public class Customer { // Fields to store customer information
    private String cusName;
    private int cusAge;
    private String cusContactNum;
    private String cusID;
    private String password;
    
    public Customer (String cusName, int cusAge,String cusContactNum, String cusID, String password){  // Constructor to initialize a Customer object with provided details     
        this.cusName  =cusName;
        this.cusAge = cusAge;
        this.cusContactNum  = cusContactNum;
        this.cusID = cusID;
        this.password = password;
    }
// Getter and setter methods for the fields
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getCusAge() {
        return cusAge;
    }

    public void setCusAge(int cusAge) {
        this.cusAge = cusAge;
    }

    public String getCusContactNum() {
        return cusContactNum;
    }

    public void setCusContactNum(String cusContactNum) {
        this.cusContactNum = cusContactNum;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    
}

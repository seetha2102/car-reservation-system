
package oop_assignment;

// Class representing a Car object
public class Car { // Fields to store car information
    private String carType;
    private String carBrand;
    private String carModel;
    private String carCat;
    private int carSeat;
    
    
    public Car (String carType,String carBrand, String carModel, String carCat, int carSeat){ // Constructor to initialize a Car object with provided details
        this.carType = carType;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carCat = carCat;
        this.carSeat = carSeat;
        
    }
// Getter and setter methods for the fields
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarCat() {
        return carCat;
    }

    public void setCarCat(String carCat) {
        this.carCat = carCat;
    }

    public int getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(int carSeat) {
        this.carSeat = carSeat;
    }
    
}

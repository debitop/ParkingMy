package model;

// TODO: 30.09.2018  message
public class Car {
    private int carId;
    private String carname;
    private int ownerId; //int id владельца

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public int getOwnerId() {        return ownerId;    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}


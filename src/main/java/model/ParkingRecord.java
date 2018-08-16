package model;

import java.util.Date;

public class ParkingRecord {
    private int parkId;
    private int carModelId;//id
    //private int ownerId;//id
    private Date dateIn;
    private Date dateOut;
    private int price;

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

//    public int getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(int ownerId) {
//        this.ownerId = ownerId;
//    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

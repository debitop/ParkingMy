package model;

import java.util.Date;
import java.util.List;

public class Driver {
    private int ownerId;
    private String username;
 //   private List<Car> listCar; //список id машин - не надо

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

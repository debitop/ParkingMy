package dao;

import model.Car;
import model.Driver;

import java.util.List;

public interface DriverDao {
    void addDriver (Driver driver);
    void delDriver(int driverId);
    void editDriver(Driver driver);
    List listDriver();
    Driver getDriverById(int driverId);

}

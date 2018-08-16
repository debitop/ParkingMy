package dao;

import model.Car;

import java.util.List;

public interface CarDao {
    void addCar (Car car);
    void delCar(int carId);
    void editCar(Car car);
    List listCarById(int ownerId);
    Car getCarById(int carId);

}

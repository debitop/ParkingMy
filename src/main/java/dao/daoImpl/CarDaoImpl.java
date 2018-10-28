package dao.daoImpl;

import dao.CarDao;
import model.Car;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private Connection connection;

    public CarDaoImpl() {
        connection = DbUtil.getConnection();
    }

    @Override
    public void addCar(Car car) {
        try {
            PreparedStatement ps =
                    connection.prepareStatement("INSERT INTO cars(carname, ownerid) VALUES (?,?)");
            ps.setString(1, car.getCarname());
            ps.setInt(2, car.getOwnerId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delCar(int carId) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM cars WHERE carId=?");
            ps.setInt(1, carId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCar(Car car) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars SET carname=?, ownerid=? WHERE carid=?");
            ps.setString(1, car.getCarname());
            ps.setInt(2, car.getOwnerId());
            ps.setInt(3, car.getCarId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List listCarById(int ownerId) {
        List<Car> list = new ArrayList<Car>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars WHERE ownerId=?");
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getInt("carId"));
                car.setOwnerId(ownerId);
                car.setCarname(rs.getString("carname"));
                list.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Car getCarById(int carId) {
        Car car = new Car();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars WHERE carid=?");
            ps.setInt(1, carId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setCarId(carId);
                car.setCarname(rs.getString("carname"));
                car.setOwnerId(rs.getInt("ownerid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
}

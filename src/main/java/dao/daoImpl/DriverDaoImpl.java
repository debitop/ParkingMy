package dao.daoImpl;

import dao.DriverDao;
import model.Driver;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoImpl implements DriverDao {
    private Connection connection;

    public DriverDaoImpl() {
        connection = DbUtil.getConnection();
    }

    @Override
    public void addDriver(Driver driver) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO drivers(username) VALUES (?)");
            ps.setString(1, driver.getUsername());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delDriver(int driverId) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM drivers WHERE ownerId=?");
            ps.setInt(1, driverId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editDriver(Driver driver) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE drivers SET username=? WHERE ownerid=?");
            ps.setString(1, driver.getUsername());
            ps.setInt(2, driver.getOwnerId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Driver> listDriver() {
        List<Driver> list = new ArrayList<Driver>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM drivers");
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setOwnerId(rs.getInt("ownerId"));
                driver.setUsername(rs.getString("username"));
                list.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Driver getDriverById(int driverId) {
        Driver driver = new Driver();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM drivers WHERE ownerid=?");
            ps.setInt(1, driverId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                driver.setOwnerId(driverId);
                driver.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

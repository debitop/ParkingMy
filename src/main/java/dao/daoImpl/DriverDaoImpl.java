package dao.daoImpl;

import dao.DriverDao;
import model.Driver;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoImpl implements DriverDao {
    private Connection connection;

    public DriverDaoImpl(){connection = DbUtil.getConnection();    }

    @Override
    public void addDriver(Driver driver) {

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

    }

    @Override
    public List<Driver> listDriver() {
        List<Driver>list =new ArrayList<Driver>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM drivers");
            while (rs.next()){
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
        return null;
    }
}

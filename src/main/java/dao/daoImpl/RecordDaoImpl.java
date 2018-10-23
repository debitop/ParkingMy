package dao.daoImpl;

import dao.RecordDao;
import model.ParkingRecord;
import service.RecordService;
import service.RecordServiceImpl.RecordServiceImpl;
import util.DbUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
    private Connection connection;
    RecordService serv;

    public RecordDaoImpl() {
        connection = DbUtil.getConnection();
        serv = new RecordServiceImpl();
    }

    @Override
    public void addRecord(ParkingRecord record) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO parkingrecords(carmodelid, datein, dateout, price) VALUES (?,?,?,?)");
            ps.setInt(1, record.getCarModelId());
            ps.setDate(2, new Date(record.getDateIn().getTime()));
            ps.setDate(3, new Date(record.getDateOut().getTime()));
            int x = (int) ((record.getDateOut().getTime()-record.getDateIn().getTime())/3600000);
// TODO: 07.10.2018  
            ps.setInt(4,11 );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delRecord(int recordId) {

    }

    @Override
    public void editRecord(ParkingRecord record) {

    }

    @Override
    public List listRecordById(int carId) {
        return null;
    }

    @Override
    public ParkingRecord getRecordById(int recordId) {
        return null;
    }
}

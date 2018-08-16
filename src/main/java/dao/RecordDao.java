package dao;

import model.Driver;
import model.ParkingRecord;

import java.util.List;

public interface RecordDao {
    void addRecord (ParkingRecord record);
    void delRecord(int recordId);
    void editRecord(ParkingRecord record);
    List listRecordById(int carId);
    ParkingRecord getRecordById(int recordId);

}

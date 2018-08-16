DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS drivers;
DROP TABLE IF EXISTS parkingrecords;

DROP SEQUENCE IF EXISTS global_seq_car;
DROP SEQUENCE IF EXISTS global_seq_drive;
DROP SEQUENCE IF EXISTS global_seq_rec;

CREATE SEQUENCE global_seq_car START 100;
CREATE SEQUENCE global_seq_drive START 100;
CREATE SEQUENCE global_seq_rec START 100;


CREATE TABLE drivers(
  ownerId INTEGER PRIMARY KEY DEFAULT nextval('global_seq_drive'),
  userName VARCHAR NOT NULL
);

CREATE TABLE cars(
carId INTEGER PRIMARY KEY DEFAULT nextval('global_seq_car'),
carname  VARCHAR NOT NULL,
ownerId INTEGER NOT NULL,
FOREIGN KEY (ownerId) REFERENCES drivers(ownerId) ON DELETE CASCADE
);



CREATE TABLE parkingrecords(
recordId INTEGER PRIMARY KEY DEFAULT nextval('global_seq_rec'),
carModelId INTEGER NOT NULL ,
dateIn TIMESTAMP  ,
dateOut TIMESTAMP,
price INTEGER,
FOREIGN KEY (carModelId) REFERENCES cars(carId) ON DELETE CASCADE
)

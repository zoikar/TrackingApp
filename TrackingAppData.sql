-- Database: BankingApplication
DROP DATABASE IF EXISTS TrackingAppData;
DROP TABLE IF EXISTS PackageInfo CASCADE;
DROP TABLE IF EXISTS TrackInfo CASCADE;
DROP TABLE IF EXISTS EmployeeInfo CASCADE;

CREATE DATABASE TrackingAppData
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1253'
    LC_CTYPE = 'English_United States.1253'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
CREATE TABLE EmployeeInfo(
	employeeuser varchar(100),
	employeepass varchar(100),
	employeename varchar(100),
	mobile varchar(10),
	primary key(employeeuser)
);	
SELECT * FROM EmployeeInfo;
INSERT INTO EmployeeInfo VALUES ('z.chris', 'zoekar25!', 'Zoi Chris', '1234557890');
INSERT INTO EmployeeInfo VALUES ('z.kar', 'zoekar25!', 'Zoi Kar', '1234567890');


CREATE TABLE PackageInfo(
	tracknum int,
	name varchar(100),
	afrom varchar(100),
	ato varchar(100),
	primary key(tracknum)
);

CREATE TABLE TrackInfo(
	tracknum int, 
	location varchar(100),
	date varchar(100),
	status varchar(100),
	details varchar(1000),
	foreign key (tracknum) references PackageInfo(tracknum)
);


SELECT * FROM PackageInfo;
SELECT * FROM TrackInfo;
INSERT INTO TrackInfo VALUES (123, 'HER', '12/4/2022', 'In transit', 'Still in transit');
INSERT INTO TrackInfo VALUES (123, 'ATH', '12/4/2021', 'delivered', 'Hoorayy');
INSERT INTO PackageInfo VALUES(123, 'ZOI', 'HER', 'ATH');
INSERT INTO PackageInfo VALUES(124, 'ZOI', 'HER', 'ATH');
INSERT INTO PackageInfo VALUES(125, 'ZOI', 'HER', 'ATH');
INSERT INTO PackageInfo VALUES(126, 'ZOI', 'HER', 'ATH');

INSERT INTO PackageInfo VALUES(123, 'ZOI', 'HER', 'ATH', 'IN TRANSIT', '12/4/2023', 'THESS', 'OKAY');
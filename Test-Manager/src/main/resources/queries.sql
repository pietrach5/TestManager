CREATE DATABASE test_manager_db;
USE test_manager_db;
CREATE TABLE 'tests' (
  'id' bigint NOT NULL AUTO_INCREMENT,
  'testName' varchar(255) DEFAULT NULL,
  'testStatus' varchar(255) DEFAULT NULL,
  PRIMARY KEY ('id');
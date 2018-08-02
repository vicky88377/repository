DROP TABLE employee if EXISTS;
CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  fullname VARCHAR(45) NULL,
  emailid VARCHAR(100) NULL,
  date_of_birth DATE NULL,
  gender VARCHAR(45) NULL,
  security_question VARCHAR(100) NULL,
  answer VARCHAR(100) NULL,
  PRIMARY KEY (emp_id));
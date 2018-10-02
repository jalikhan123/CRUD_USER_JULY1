--Create user_enrollment schema
CREATE SCHEMA `user_enrollment` ;

--Create User table into user_enrollment schema
CREATE TABLE `user_enrollment`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) NOT NULL,
  `userAddress1` VARCHAR(150) NULL,
  `userAddress2` VARCHAR(150) NULL,
  `phoneNumber` VARCHAR(15) NOT NULL,
  `emailAddress` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`userId`));
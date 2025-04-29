-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: banksystem
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `signup3`
--

DROP TABLE IF EXISTS `signup3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup3` (
  `Form_no` varchar(50) DEFAULT NULL,
  `Account_Type` varchar(80) DEFAULT NULL,
  `Card_Number` varchar(80) DEFAULT NULL,
  `PiN` varchar(80) DEFAULT NULL,
  `Facilities` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup3`
--

LOCK TABLES `signup3` WRITE;
/*!40000 ALTER TABLE `signup3` DISABLE KEYS */;
INSERT INTO `signup3` VALUES ('6736','Saving Account','1409-9630-3608-8265','396','ATM Card  Internet Banking  Mobile Banking  Email Alerts  Cheque Book  E-Statement  '),('8382','Current Account','1409-9629-5749-6802','1234','ATM Card  Internet Banking  Mobile Banking  Email Alerts  Cheque Book  E-Statement  '),('2796','Current Account','1409-9629-5521-4998','1239','ATM Card  Internet Banking  Mobile Banking  Email Alerts  Cheque Book  E-Statement  '),('2436','Current Account','1409-9629-3848-7358','1956','ATM Card  Internet Banking  Mobile Banking  Email Alerts  Cheque Book  E-Statement  '),('5761','Recurring Deposit Account','1409-9630-0258-3709','1829','ATM Card  Internet Banking  Mobile Banking  Email Alerts  Cheque Book  E-Statement  '),('2659','Current Account','1409-9629-8447-0560','9299','ATM Card  Mobile Banking  Cheque Book  '),('3082','Current Account','1409-9629-3745-6710','1934','ATM Card  Internet Banking  Email Alerts  Cheque Book  ');
/*!40000 ALTER TABLE `signup3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-29 23:14:10

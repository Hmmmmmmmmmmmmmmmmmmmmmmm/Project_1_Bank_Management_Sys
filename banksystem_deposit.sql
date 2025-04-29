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
-- Table structure for table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deposit` (
  `Pin` varchar(20) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `amount` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit`
--

LOCK TABLES `deposit` WRITE;
/*!40000 ALTER TABLE `deposit` DISABLE KEYS */;
INSERT INTO `deposit` VALUES ('6736','Sun Mar 02 02:09:15 IST 2025','Deposit','5500'),('6736','Sun Mar 02 02:09:25 IST 2025','Withdrawal','100'),('8382','Sun Mar 02 02:14:55 IST 2025','Deposit','950000'),('8382','Sun Mar 02 02:15:06 IST 2025','Withdrawal','20000'),('1234','Sun Mar 02 02:17:57 IST 2025','Deposit','12000'),('1234','Sun Mar 02 02:18:02 IST 2025','Withdrawal','2000'),('2796','Sun Mar 02 02:47:47 IST 2025','Deposit','99000'),('1239','Sun Mar 02 02:49:10 IST 2025','Deposit','99000'),('1239','Sun Mar 02 02:50:02 IST 2025','withdrawal','5000'),('1239','Sun Mar 02 02:50:11 IST 2025','withdrawal','5000'),('1239','Sun Mar 02 02:51:38 IST 2025','Withdrawal','200'),('1239','Sun Mar 02 02:51:45 IST 2025','withdrawal','5000'),('1239','Sun Mar 02 05:07:31 IST 2025','Deposit','90000000'),('1239','Sun Mar 02 05:07:41 IST 2025','Withdrawal','2000'),('1239','Sun Mar 02 05:07:51 IST 2025','withdrawal','5000'),('1239','Sun Mar 02 05:08:09 IST 2025','withdrawal','5000'),('2436','Sun Mar 02 05:09:20 IST 2025','Deposit','99999999'),('5761','Sun Mar 02 16:13:20 IST 2025','Deposit','10500'),('5761','Sun Mar 02 16:13:28 IST 2025','Withdrawal','100'),('5761','Sun Mar 02 16:13:32 IST 2025','Deposit','100'),('5761','Sun Mar 02 16:13:35 IST 2025','withdrawal','5000'),('7203','Sun Mar 02 17:27:00 IST 2025','Deposit','50000'),('7203','Sun Mar 02 17:27:06 IST 2025','Withdrawal','120'),('1234','Mon Mar 03 05:19:25 IST 2025','Deposit','1000'),('1234','Mon Mar 03 05:19:32 IST 2025','Withdrawal','200'),('1234','Mon Mar 03 05:23:08 IST 2025','withdrawal','1000'),('1234','Mon Mar 03 05:23:14 IST 2025','Deposit','1000'),('1234','Mon Mar 03 05:23:18 IST 2025','Deposit','1000'),('1234','Mon Mar 03 05:23:44 IST 2025','Withdrawal','50'),('1234','Mon Mar 03 05:23:49 IST 2025','Withdrawal','500'),('1234','Mon Mar 03 05:23:56 IST 2025','Deposit','90000'),('1234','Mon Mar 03 05:24:01 IST 2025','Withdrawal','20000'),('null','Sun Mar 09 00:03:24 IST 2025','Deposit','90000   '),('null','Sun Mar 09 00:03:30 IST 2025','Deposit','1000   '),('null','Sun Mar 09 00:05:49 IST 2025','Deposit','90000   '),('null','Sun Mar 09 00:05:55 IST 2025','Withdrawal','5000');
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */;
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

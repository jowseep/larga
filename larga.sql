-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `travel_id` int NOT NULL,
  `seat_no` varchar(50) NOT NULL,
  `travel_date` varchar(100) NOT NULL,
  `payment` enum('GCash','PayMaya','Cash','Card') DEFAULT NULL,
  `booking_date` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `status` enum('active','inactive') NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`),
  KEY `bus_id_idx` (`user_id`),
  KEY `user_id_idx` (`seat_no`),
  KEY `seat_id_idx` (`travel_date`),
  KEY `travel_id_idx` (`travel_id`),
  CONSTRAINT `tid` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`),
  CONSTRAINT `uid` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (5,NULL,'Joseph','Callao',8003,'4B, ','Sat Jul 23 00:00:00 PST 2022',NULL,'2022-07-20','j@gmail.com','active'),(6,12,NULL,NULL,8005,'3B, ','Sat Jul 23 00:00:00 PST 2022',NULL,'2022-07-20',NULL,'inactive'),(7,12,NULL,NULL,8003,'3B, ','Sat Jul 30 00:00:00 PST 2022',NULL,'2022-07-20',NULL,'inactive'),(8,NULL,'null','null',8001,'4B, ','Sat Jul 23 00:00:00 PST 2022',NULL,'2022-07-20','null','active'),(9,NULL,'Dennis','Cabag',8003,'3C, ','Thu Aug 04 00:00:00 PST 2022',NULL,'2022-07-20','denniscabag@gmail.com','active'),(10,NULL,'Larysa','Serilla',8005,'2C, ','Thu Aug 18 00:00:00 PST 2022',NULL,'2022-07-20','larysaserilla@gmail.com','active'),(11,NULL,'Air','Pods',8003,'3C, ','Thu Aug 18 00:00:00 PST 2022',NULL,'2022-07-20','airpods@gmail.com','active'),(12,12,NULL,NULL,8003,'3B, ','Sat Jul 30 00:00:00 PST 2022',NULL,'2022-07-21',NULL,'active'),(13,12,NULL,NULL,8001,'4A, ','Thu Aug 18 00:00:00 PST 2022',NULL,'2022-07-24',NULL,'active'),(14,12,NULL,NULL,8003,'2B, ','Sat Aug 06 00:00:00 PST 2022',NULL,'2022-07-24',NULL,'active'),(15,12,NULL,NULL,8003,'4E, ','Sat Jul 23 00:00:00 PST 2022',NULL,'2022-07-25',NULL,'active'),(16,12,NULL,NULL,8003,'3C, ','Sat Aug 06 00:00:00 PST 2022',NULL,'2022-07-25',NULL,'active'),(17,12,NULL,NULL,8007,'3B, ','Fri Aug 26 00:00:00 PST 2022',NULL,'2022-07-25',NULL,'active'),(18,NULL,'Joseph','Callao',8001,'4B, ','yyyy-MM-dd',NULL,'2022-07-25','askjosephcallao@gmail.com','active');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `departure` varchar(50) NOT NULL,
  `arrival` varchar(50) NOT NULL,
  `bus_ company` varchar(100) NOT NULL,
  `bus_unit` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `time` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `destination_id_idx` (`departure`,`arrival`),
  KEY `departure_id` (`arrival`)
) ENGINE=InnoDB AUTO_INCREMENT=8008 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (8000,'Digos City','Davao City','Mindanao Star','Yutong',120,'07:00am-09:00am'),(8001,'Digos City','Davao City','Metro Davao Shuttle','Yutong',100,'08:00am-10:00am'),(8002,'Davao City','Digos City','Mindanao Star','Yutong',120,'10:30am-12:30pm'),(8003,'Davao City','Digos City','Metro Davao Shuttle','Yutong',100,'11:30am-01:30pm'),(8004,'Tagum City','Davao City','Bachelor Express','Yutong',140,'07:00am-09:00am'),(8005,'Tagum City','Davao City','Metro Davao Shuttle','Yutong',120,'08:00am-10:00am'),(8006,'Davao City','Tagum City','Bachelor Express','Yutong',140,'10:30am-12:30pm'),(8007,'Davao City','Tagum City','Metro Davao Shuttle','Yutong',120,'11:30am-01:30pm');
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` enum('admin','regular','bus operator') NOT NULL DEFAULT 'regular',
  `username` varchar(45) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'Joseph','Callao','jowseep@gmail.com','admin','joseph','joseph03'),(2,'Kim','Osico','kim@gmail.com','regular','kim','kim31'),(3,'Irish','Bernales','irishclarence@gmail.com','regular','ishi','ishimarielou'),(10,'Taylor','Swift','taylor@tswift.com','regular','tswift','face5b507d92efb51795f474cc6d0eb7b39263977b0b130e3385960a2fd5b9d6'),(12,'Jazzle','Fe','jazzlefe@gmail.com','regular','jazzlefe','e1387da16b09d22eb2207415cecf74a8ee0bf101875858607a243d59d7c08bbc'),(13,'asd','sdf','user123@gmail.com','regular','user','e606e38b0d8c19b24cf0ee3808183162ea7cd63ff7912dbb22b5e803286b4446'),(14,'ming','ming','ming@yahoo.com','admin','mingming','bfdbce13daa7c3842498d81e294846f828d5a74eedcee175db8a4433e5eb10b5');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-27 18:39:18

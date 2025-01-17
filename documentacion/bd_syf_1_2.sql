CREATE DATABASE  IF NOT EXISTS `bd_syf_1_2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_syf_1_2`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_syf_1_2
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `consumidor`
--

DROP TABLE IF EXISTS `consumidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumidor` (
  `idconsumidor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  PRIMARY KEY (`idconsumidor`),
  UNIQUE KEY `telefono` (`telefono`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumidor`
--

LOCK TABLES `consumidor` WRITE;
/*!40000 ALTER TABLE `consumidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `idcontrato` int NOT NULL AUTO_INCREMENT,
  `fecha_comienzo` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `vigencia` enum('Activo','Inactivo') NOT NULL,
  `id_empleado` int NOT NULL,
  `id_departamento` int NOT NULL,
  PRIMARY KEY (`idcontrato`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`idempleado`),
  CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`iddepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `iddepartamento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `horas_semanales` tinyint NOT NULL,
  PRIMARY KEY (`iddepartamento`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_suministro`
--

DROP TABLE IF EXISTS `detalle_suministro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_suministro` (
  `iddetalle_suministro` int NOT NULL AUTO_INCREMENT,
  `tipo_producto` varchar(100) NOT NULL,
  `cantidad` int unsigned NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `total_coste` decimal(10,2) GENERATED ALWAYS AS ((`cantidad` * `precio`)) STORED,
  `stock` int unsigned NOT NULL,
  `id_proveedor` int NOT NULL,
  PRIMARY KEY (`iddetalle_suministro`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `detalle_suministro_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_suministro`
--

LOCK TABLES `detalle_suministro` WRITE;
/*!40000 ALTER TABLE `detalle_suministro` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_suministro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idempleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dni` char(8) NOT NULL,
  `sexo` enum('Masculino','Femenino') NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`idempleado`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `correo` (`correo`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Juan','Perez','12345678','Masculino','juan.perez@gmail.com','987654321','Av. Empleado 1','1985-01-15'),(2,'Maria','Lopez','23456789','Femenino','maria.lopez@gmail.com','912345678','Calle Empleado 2','1990-06-20'),(3,'Carlos','Diaz','34567890','Masculino','carlos.diaz@gmail.com','934567890','Av. Empleado 3','1988-04-10'),(4,'Luisa','Garcia','45678901','Femenino','luisa.garcia@gmail.com','998765432','Calle Firme 4','1992-03-25'),(5,'Pedro','Martinez','56789012','Masculino','pedro.martinez@gmail.com','987234567','Av. Solida 5','1987-11-15'),(6,'Ana','Gonzalez','67890123','Femenino','ana.gonzalez@gmail.com','912876543','Calle Limpia 6','1995-07-18'),(7,'Miguel','Hernandez','78901234','Masculino','miguel.hernandez@gmail.com','956234789','Av. Maquinaria 7','1990-02-10'),(8,'Claudia','Torres','89012345','Femenino','claudia.torres@gmail.com','912987654','Calle Proactiva 8','1989-12-05'),(9,'Rafael','Ramirez','90123456','Masculino','rafael.ramirez@gmail.com','934123987','Av. Sostenible 9','1986-06-30'),(10,'Sofia','Cruz','11234567','Femenino','sofia.cruz@gmail.com','923456789','Calle Productiva 10','1993-05-12'),(11,'Luis','Vargas','12234567','Masculino','luis.vargas@gmail.com','910987654','Av. Innovadora 11','1984-08-09'),(12,'Carla','Rios','13234567','Femenino','carla.rios@gmail.com','924567890','Calle Creativa 12','1996-10-11'),(13,'Fernando','Soto','14234567','Masculino','fernando.soto@gmail.com','911876543','Av. Industrial 13','1985-04-23'),(14,'Paola','Reyes','15234567','Femenino','paola.reyes@gmail.com','930987654','Calle Organizada 14','1994-01-14'),(15,'Jorge','Castro','16234567','Masculino','jorge.castro@gmail.com','921234567','Av. Eficiente 15','1983-07-27'),(16,'Gabriela','Ortiz','17234567','Femenino','gabriela.ortiz@gmail.com','927654321','Calle Dinámica 16','1991-09-18'),(17,'Diego','Flores','18234567','Masculino','diego.flores@gmail.com','915678234','Av. Moderna 17','1989-02-25'),(18,'Laura','Medina','19234567','Femenino','laura.medina@gmail.com','923567890','Calle Estratégica 18','1992-11-30'),(19,'Oscar','Morales','20234567','Masculino','oscar.morales@gmail.com','919876543','Av. Competitiva 19','1987-03-08'),(20,'Valeria','Paredes','21234567','Femenino','valeria.paredes@gmail.com','918765432','Calle Equilibrada 20','1995-12-20');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `idhorario` int NOT NULL AUTO_INCREMENT,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `dia` enum('Lunes','Martes','Miércoles','Jueves','Viernes','Sábado','Domingo') NOT NULL,
  `id_contrato` int NOT NULL,
  PRIMARY KEY (`idhorario`),
  KEY `id_contrato` (`id_contrato`),
  CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`id_contrato`) REFERENCES `contrato` (`idcontrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produccion`
--

DROP TABLE IF EXISTS `produccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produccion` (
  `idproduccion` int NOT NULL AUTO_INCREMENT,
  `fecha_produccion` date NOT NULL,
  `cantidad` int unsigned NOT NULL,
  `id_empleado` int NOT NULL,
  `id_producto` int NOT NULL,
  `id_detalle_suministro` int NOT NULL,
  PRIMARY KEY (`idproduccion`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_producto` (`id_producto`),
  KEY `id_detalle_suministro` (`id_detalle_suministro`),
  CONSTRAINT `produccion_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`idempleado`),
  CONSTRAINT `produccion_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`idproducto`),
  CONSTRAINT `produccion_ibfk_3` FOREIGN KEY (`id_detalle_suministro`) REFERENCES `detalle_suministro` (`iddetalle_suministro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produccion`
--

LOCK TABLES `produccion` WRITE;
/*!40000 ALTER TABLE `produccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `produccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `capacidad_ml` int unsigned NOT NULL,
  `color` varchar(45) NOT NULL,
  `material` varchar(45) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,500,'transparente','plastico'),(2,500,'blanco','plastico');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idproveedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  PRIMARY KEY (`idproveedor`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `correo` (`correo`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idventas` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cantidad` int unsigned NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `total_coste` decimal(10,2) GENERATED ALWAYS AS ((`cantidad` * `precio`)) STORED,
  `id_producto` int NOT NULL,
  `id_consumidor` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`idventas`),
  KEY `id_producto` (`id_producto`),
  KEY `id_consumidor` (`id_consumidor`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`idproducto`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_consumidor`) REFERENCES `consumidor` (`idconsumidor`),
  CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`idempleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17  4:47:15

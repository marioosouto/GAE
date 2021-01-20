-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: gestao_autoescolas
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `idaluno` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  PRIMARY KEY (`idaluno`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Mario Souto','12549174623','Rua Delta. 75','CATEGORIA A','MASCULINO','',''),(5,'Mario Augusto','11301447633','Rua delta','CATEGORIA A','MASCULINO','Umuarama','75'),(7,'Mario 2','38971173041','2','CATEGORIA B','FEMININO','2','2   '),(8,'Mario 4','94356865081','1','CATEGORIA B','FEMININO','1','1   ');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alunos_turma`
--

DROP TABLE IF EXISTS `alunos_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alunos_turma` (
  `idalunos_turma` int NOT NULL AUTO_INCREMENT,
  `id_turma` int DEFAULT NULL,
  `id_aluno` int DEFAULT NULL,
  `sala` int DEFAULT NULL,
  PRIMARY KEY (`idalunos_turma`),
  KEY `idaluno_idx` (`id_aluno`),
  KEY `idsalaafk_idx` (`sala`),
  CONSTRAINT `idaluno` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`idaluno`),
  CONSTRAINT `idsalaafk` FOREIGN KEY (`sala`) REFERENCES `sala` (`idsala`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos_turma`
--

LOCK TABLES `alunos_turma` WRITE;
/*!40000 ALTER TABLE `alunos_turma` DISABLE KEYS */;
INSERT INTO `alunos_turma` VALUES (19,9,1,NULL);
/*!40000 ALTER TABLE `alunos_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `idaula` int NOT NULL AUTO_INCREMENT,
  `veiculo` int DEFAULT NULL,
  PRIMARY KEY (`idaula`),
  KEY `veiculoafk_idx` (`veiculo`),
  CONSTRAINT `veiculoafk` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idveiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutor`
--

DROP TABLE IF EXISTS `instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrutor` (
  `idinstrutor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  PRIMARY KEY (`idinstrutor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutor`
--

LOCK TABLES `instrutor` WRITE;
/*!40000 ALTER TABLE `instrutor` DISABLE KEYS */;
INSERT INTO `instrutor` VALUES (1,'Instrutor A','12549174623','Rua Delta','Umuarama','75','MASCULINO'),(2,'editar','40304508063','editar','editar','23','FEMININO');
/*!40000 ALTER TABLE `instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `idsala` int NOT NULL AUTO_INCREMENT,
  `materia` varchar(45) NOT NULL,
  `capacidade` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idsala`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (2,'Primeiros Socorros',45,'Sala 01'),(3,'Mecânica',30,'Sala 02');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `idturma` int NOT NULL AUTO_INCREMENT,
  `aluno` int DEFAULT NULL,
  `nome_turma` varchar(45) NOT NULL,
  `idinstrutorturma` int DEFAULT NULL,
  `iddisciplina` int DEFAULT NULL,
  PRIMARY KEY (`idturma`),
  KEY `alunoafk_idx` (`aluno`),
  KEY `instrutorafk_idx` (`idinstrutorturma`),
  KEY `iddisciplinaafk_idx` (`iddisciplina`),
  CONSTRAINT `alunoafk` FOREIGN KEY (`aluno`) REFERENCES `aluno` (`idaluno`),
  CONSTRAINT `iddisciplinaafk` FOREIGN KEY (`iddisciplina`) REFERENCES `sala` (`idsala`),
  CONSTRAINT `instrutorafk` FOREIGN KEY (`idinstrutorturma`) REFERENCES `instrutor` (`idinstrutor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (9,NULL,'turma 00',1,2);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'mario','mario','59195C6C541C8307F1DA2D1E768D6F2280C984DF217AD5F4C64C3542B04111A4'),(8,'Mario Souto','mario','083A7826F268A1791FAB027C8736CFA990E16AB905DA597F688111772C967CB6');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `idveiculo` int NOT NULL AUTO_INCREMENT,
  `placa` varchar(45) NOT NULL,
  `chasse` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  PRIMARY KEY (`idveiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,'HNL1700','99DJASID9','WM GOL 1.0'),(4,'OAL2213','O2EJI223K9','CHEVROLET ONIX 1.0');
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestao_autoescolas'
--

--
-- Dumping routines for database 'gestao_autoescolas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 19:59:48

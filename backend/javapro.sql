/*!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.4.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: javapro
-- ------------------------------------------------------
-- Server version	11.4.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(64) NOT NULL,
  `question_id` int(11) NOT NULL,
  `correct` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES
(3,'Kurczak',1,0),
(4,'Wieprzowina',1,1),
(5,'Wołowina',1,0),
(6,'Baranina',1,0),
(7,'Dodaje smaku',2,0),
(8,'Utrwala kolor',2,0),
(9,'Zagęszcza i żeluje galaretkę',2,1),
(10,'Zwiększa kaloryczność',2,0),
(11,'Marchewka i groszek',3,1),
(12,'Pomidor i ogórek',3,0),
(13,'Kapusta i burak',3,0),
(14,'Cebula i papryka',3,0),
(15,'10-15 minut',4,0),
(16,'30-45 minut',4,0),
(17,'1-2 godziny',4,1),
(18,'3-4 godziny',4,0),
(19,'Sól, pieprz, liść laurowy',5,1),
(20,'Sól, curry, bazylia',5,0),
(21,'Cukier, cynamon, imbir',5,0),
(22,'Papryka, oregano, tymianek',5,0),
(23,'5-10°C',6,1),
(24,'15-20°C',6,0),
(25,'25-30°C',6,0),
(26,'35-40°C',6,0),
(27,'1 dzień',7,0),
(28,'2-3 dni',7,0),
(29,'4-5 dni',7,1),
(30,'6-7 dni',7,0),
(31,'Owocową',8,0),
(32,'Warzywną',8,0),
(33,'Mięsną',8,1),
(34,'Słodką',8,0),
(35,'Jest smaczniejsza na zimno',9,1),
(36,'Jest łatwiejsza do krojenia',9,0),
(37,'Ma lepszą teksturę',9,0),
(38,'Wszystkie powyższe',9,1),
(39,'Cukier',10,0),
(40,'Sok z cytryny',10,1),
(41,'Sól',10,0),
(42,'Pieprz',10,0),
(43,'Open Graphics Library',11,1),
(44,'Open Game Library',11,0),
(45,'Open General Library',11,0),
(46,'Open Geometric Library',11,0),
(47,'OpenGL 1.0',12,0),
(48,'OpenGL 2.0',12,1),
(49,'OpenGL 3.0',12,0),
(50,'OpenGL 4.0',12,0),
(51,'Virtual Buffer Object',13,0),
(52,'Visual Buffer Object',13,0),
(53,'Vertex Buffer Object',13,1),
(54,'Volume Buffer Object',13,0),
(55,'Vertex Shader, Fragment Shader, Geometry Shader',14,1),
(56,'Pixel Shader, Sound Shader, Texture Shader',14,0),
(57,'Geometry Shader, Pixel Shader, Texture Shader',14,0),
(58,'Fragment Shader, Sound Shader, Geometry Shader',14,0),
(59,'glCreateShader, glCompileShader, glAttachShader, glLinkProgram',15,1),
(60,'glShaderCompile, glShaderLink, glCreateProgram',15,0),
(61,'glShaderCreate, glShaderAttach, glProgramLink',15,0),
(62,'glShaderInit, glShaderConnect, glProgramCreate',15,0),
(63,'Włącza test głębokości',16,1),
(64,'Włącza test tekstur',16,0),
(65,'Wyłącza test głębokości',16,0),
(66,'Wyłącza test tekstur',16,0),
(67,'Depth Buffer',17,0),
(68,'Color Buffer',17,1),
(69,'Stencil Buffer',17,0),
(70,'Frame Buffer',17,0),
(71,'glBegin, glEnd',18,0),
(72,'glDrawArrays, glDrawElements',18,1),
(73,'glStart, glStop',18,0),
(74,'glRenderBegin, glRenderEnd',18,0),
(75,'Generuje nowe bufor tekstur',19,0),
(76,'Generuje nowe identyfikatory buforów',19,1),
(77,'Generuje nowe shadery',19,0),
(78,'Generuje nowe programy',19,0),
(79,'GL_TRIANGLES, GL_QUADS, GL_POLYGON',20,1),
(80,'GL_LINES, GL_POINTS, GL_SQUARES',20,0),
(81,'GL_RECTANGLES, GL_POLYGONS, GL_CIRCLES',20,0),
(82,'GL_POINTS, GL_TRIANGLES, GL_CIRCLES',20,0);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(128) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES
(1,'Co jest głównym składnikiem galaretki garmażeryjnej wieprzowej?',1),
(2,'Jaką rolę pełni żelatyna w galaretce garmażeryjnej wieprzowej?',1),
(3,'Jakie warzywa są najczęściej dodawane do galaretki garmażeryjnej wieprzowej?',1),
(4,'Jak długo należy gotować wieprzowinę na galaretkę, aby była odpowiednio miękka?',1),
(5,'Jakie przyprawy są zazwyczaj używane do przyprawienia galaretki garmażeryjnej wieprzowej?',1),
(6,'Jaką temperaturę powinna mieć galaretka garmażeryjna wieprzowa, aby była odpowiednio stężała?',1),
(7,'Jak długo galaretka garmażeryjna wieprzowa może być przechowywana w lodówce?',1),
(8,'Jakiego typu galaretkę można uzyskać z mięsa wieprzowego?',1),
(9,'Dlaczego galaretka garmażeryjna wieprzowa jest często podawana na zimno?',1),
(10,'Co można dodać do galaretki garmażeryjnej wieprzowej, aby nadać jej kwaskowaty smak?',1),
(11,'Co oznacza skrót OpenGL?',2),
(12,'Która wersja OpenGL wprowadziła Shader Language (GLSL)?',2),
(13,'Co to jest VBO w kontekście OpenGL?',2),
(14,'Jakie typy shaderów są dostępne w OpenGL?',2),
(15,'Jakie funkcje są używane do tworzenia i łączenia shaderów w OpenGL?',2),
(16,'Co robi funkcja glEnable(GL_DEPTH_TEST) w OpenGL?',2),
(17,'Który bufor przechowuje informacje o kolorach pikseli na ekranie w OpenGL?',2),
(18,'Jakie funkcje są używane do rysowania prymitywów w OpenGL?',2),
(19,'Co robi funkcja glGenBuffers w OpenGL?',2),
(20,'Jakie są podstawowe typy prymitywów w OpenGL?',2);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizzes`
--

DROP TABLE IF EXISTS `quizzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quizzes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizzes`
--

LOCK TABLES `quizzes` WRITE;
/*!40000 ALTER TABLE `quizzes` DISABLE KEYS */;
INSERT INTO `quizzes` VALUES
(1,'Test wiedzy o galaretce garmażeryjnej wieprzowej'),
(2,'Quiz na temat OpenGL');
/*!40000 ALTER TABLE `quizzes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password_md5` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2024-07-01  0:18:33

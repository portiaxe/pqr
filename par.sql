-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.26-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for pqr
CREATE DATABASE IF NOT EXISTS `pqr` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pqr`;

-- Dumping structure for table pqr.departments
CREATE TABLE IF NOT EXISTS `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.departments: ~0 rows (approximately)
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` (`id`, `dept_name`, `created`, `updated`, `deleted`) VALUES
	(1, 'DexNet', '2017-09-11 15:06:30', NULL, NULL);
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;

-- Dumping structure for table pqr.department_projects
CREATE TABLE IF NOT EXISTS `department_projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_id` int(11) NOT NULL,
  `proj_id` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dep_id` (`dep_id`),
  KEY `proj_id` (`proj_id`),
  CONSTRAINT `department_projects_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `department_projects_ibfk_2` FOREIGN KEY (`proj_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.department_projects: ~0 rows (approximately)
/*!40000 ALTER TABLE `department_projects` DISABLE KEYS */;
INSERT INTO `department_projects` (`id`, `dep_id`, `proj_id`, `created`, `updated`, `deleted`) VALUES
	(1, 1, 1, '2017-09-11 15:26:36', NULL, NULL);
/*!40000 ALTER TABLE `department_projects` ENABLE KEYS */;

-- Dumping structure for table pqr.dept_proj_members
CREATE TABLE IF NOT EXISTS `dept_proj_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_proj_id` int(11) NOT NULL,
  `pos_id` int(11) NOT NULL,
  `mem_id` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_proj_id` (`dept_proj_id`),
  KEY `pos_id` (`pos_id`),
  KEY `mem_id` (`mem_id`),
  CONSTRAINT `dept_proj_members_ibfk_1` FOREIGN KEY (`dept_proj_id`) REFERENCES `department_projects` (`id`),
  CONSTRAINT `dept_proj_members_ibfk_2` FOREIGN KEY (`pos_id`) REFERENCES `positions` (`id`),
  CONSTRAINT `dept_proj_members_ibfk_3` FOREIGN KEY (`mem_id`) REFERENCES `members` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.dept_proj_members: ~0 rows (approximately)
/*!40000 ALTER TABLE `dept_proj_members` DISABLE KEYS */;
INSERT INTO `dept_proj_members` (`id`, `dept_proj_id`, `pos_id`, `mem_id`, `created`, `updated`, `deleted`) VALUES
	(1, 1, 1, 1, '2017-09-11 18:55:54', NULL, NULL);
/*!40000 ALTER TABLE `dept_proj_members` ENABLE KEYS */;

-- Dumping structure for table pqr.members
CREATE TABLE IF NOT EXISTS `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `start_date` datetime NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.members: ~1 rows (approximately)
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` (`id`, `name`, `start_date`, `created`, `updated`, `deleted`) VALUES
	(1, 'Jerico Grijaldo', '2017-09-11 15:09:40', '2017-09-11 15:09:40', NULL, NULL);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;

-- Dumping structure for table pqr.positions
CREATE TABLE IF NOT EXISTS `positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pos_name` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.positions: ~0 rows (approximately)
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` (`id`, `pos_name`, `created`, `updated`, `deleted`) VALUES
	(1, 'QA', '2017-09-11 14:20:53', NULL, NULL);
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;

-- Dumping structure for table pqr.productivity
CREATE TABLE IF NOT EXISTS `productivity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exp_type` enum('Beginner','Moderate','Expererience') NOT NULL DEFAULT 'Beginner',
  `prod_val` tinyint(4) NOT NULL DEFAULT '1',
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.productivity: ~0 rows (approximately)
/*!40000 ALTER TABLE `productivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `productivity` ENABLE KEYS */;

-- Dumping structure for table pqr.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proj_name` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.projects: ~4 rows (approximately)
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` (`id`, `proj_name`, `created`, `updated`, `deleted`) VALUES
	(1, 'Lamar-Allison', '2017-09-11 14:14:17', NULL, NULL),
	(2, 'SEM+Proactive Optimization', '2017-09-12 21:47:24', NULL, NULL),
	(3, 'ACQ Rejects', '2017-09-12 21:51:27', NULL, NULL),
	(4, 'SEM Premium', '2017-09-12 21:54:09', '2017-09-12 21:55:40', '2017-09-12 21:55:48');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;

-- Dumping structure for table pqr.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `fname`, `lname`, `password`, `created`, `updated`, `deleted`) VALUES
	(1, 'jerico.grijaldo@personiv.com', 'Jerico', 'Grijaldo', 'asfsadf', '2017-09-11 17:28:57', NULL, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table pqr.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` enum('Admin','Manager','Team Leader') NOT NULL DEFAULT 'Manager',
  `user_id` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table pqr.user_roles: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`id`, `role`, `user_id`, `created`, `updated`, `deleted`) VALUES
	(1, 'Admin', 1, '2017-09-11 17:31:55', NULL, NULL);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

-- Dumping structure for procedure pqr._proc_addProject
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_addProject`(
	IN `project` VARCHAR(255)


)
BEGIN
	INSERT INTO projects(proj_name,created) VALUES(project,now());
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getDepartments
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getDepartments`()
BEGIN
	SELECT d.id,d.dept_name as'name',d.created,d.updated,d.deleted
	  FROM departments d;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getDeptById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getDeptById`(
	IN `dept_id` INT
)
BEGIN
	SELECT d.id,d.dept_name as'name',d.created,d.updated,d.deleted
	  FROM departments d
	 WHERE d.id = dept_id;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getDeptProjectById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getDeptProjectById`(
	IN `dep_proj_id` INT

)
BEGIN
		SELECT dp.id,dp.created,dp.updated,dp.deleted,
			 d.id as 'departmentId',
			 p.id as 'projectId'
	  FROM department_projects dp
	  JOIN departments d ON dp.dep_id = d.id
	  JOIN projects p ON dp.proj_id = p.id
	 WHERE dp.id = dep_proj_id;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getDeptProjects
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getDeptProjects`()
BEGIN
	SELECT dp.id,dp.created,dp.updated,dp.deleted,
			 d.id as 'departmentId',
			 p.id as 'projectId'
	  FROM department_projects dp
	  JOIN departments d ON dp.dep_id = d.id
	  JOIN projects p ON dp.proj_id = p.id;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getMembers
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getMembers`()
BEGIN
	SELECT * 
	  FROM members m;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getPositions
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getPositions`()
BEGIN
	SELECT p.id,p.pos_name as 'name',p.created,p.updated,p.deleted
	FROM positions p;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getProjectById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getProjectById`(
	IN `proj_id` INT
)
BEGIN
	SELECT p.id,p.proj_name as 'name',p.created,p.updated,p.deleted
	  FROM projects p
	 WHERE p.id = proj_id;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getProjects
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getProjects`()
BEGIN
	SELECT p.id,p.proj_name as 'name',p.created,p.updated,p.deleted
	  FROM projects p
	 WHERE p.deleted is null; 
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getUserRoles
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getUserRoles`(
	IN `id` INT
)
BEGIN
	SELECT ur.id,ur.role
	  FROM user_roles ur
	  WHERE ur.user_id = id;
END//
DELIMITER ;

-- Dumping structure for procedure pqr._proc_getUsers
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `_proc_getUsers`()
BEGIN
	SELECT u.id,u.email,u.fname,u.lname,u.created,u.updated,u.deleted
	  FROM users u;
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

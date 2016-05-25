-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2016 at 12:49 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` int(11) DEFAULT NULL,
  `account_pin` int(11) DEFAULT NULL,
  `opening_balance` int(11) NOT NULL DEFAULT '0',
  `current_balance` float NOT NULL DEFAULT '0',
  `login_ip` int(11) DEFAULT NULL,
  `create_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `account_number`, `account_pin`, `opening_balance`, `current_balance`, `login_ip`, `create_date_time`, `status`) VALUES
(1, 55652, 0, 0, 0, NULL, '2016-05-18 20:03:16', 1),
(2, 64700, 14, 0, 0, NULL, '2016-05-18 20:04:21', 1),
(3, 65652, 1019, 0, 0, NULL, '2016-05-18 20:04:45', 1),
(4, 5556565, 3064, 0, 0, NULL, '2016-05-19 08:16:08', 1),
(5, 565565, 2258, 0, 0, NULL, '2016-05-19 08:31:37', 1),
(6, 65655, 1428, 0, 0, NULL, '2016-05-19 08:32:51', 1),
(7, 556566, 2697, 0, 0, NULL, '2016-05-19 08:33:32', 1),
(8, 6470, 4530, 0, 3482, NULL, '2016-05-19 08:38:32', 1),
(9, 65652, 3215, 0, 0, NULL, '2016-05-19 08:48:09', 1),
(10, 990101, 4958, 0, 800, NULL, '2016-05-22 09:26:57', 1),
(11, 565058206, 108, 0, 0, NULL, '2016-05-24 09:24:14', 1),
(12, 8930365, 4506, 0, 0, NULL, '2016-05-24 09:25:56', 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_action_idFk` int(11) NOT NULL,
  `account_target_idFk` int(11) NOT NULL,
  `transaction_type_idFk` int(11) NOT NULL,
  `amount` float NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `account_action_idFk`, `account_target_idFk`, `transaction_type_idFk`, `amount`, `status`) VALUES
(1, 0, 6470, 1, 20, 1),
(2, 0, 6470, 1, 20, 1),
(3, 0, 6470, 1, 30, 1),
(4, 440101, 6470, 1, 230, 1),
(5, 440101, 6470, 1, 3220, 1),
(6, 440101, 6470, 1, 23, 1),
(7, 990101, 0, 1, 6470, 1),
(8, 6470, 6470, 1, 20, 1),
(9, 6470, 6470, 1, 30, 1),
(10, 6470, 6470, 2, 3232, 1),
(11, 6470, 6470, 1, 1200.3, 1),
(12, 6470, 6470, 1, 12000.3, 1),
(13, 6470, 6470, 2, 12000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_type`
--

CREATE TABLE IF NOT EXISTS `transaction_type` (
  `transaction_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_type` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`transaction_type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `transaction_type`
--

INSERT INTO `transaction_type` (`transaction_type_id`, `transaction_type`, `status`) VALUES
(1, 'debit', 1),
(2, 'credit', 1),
(3, 'transfer', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_idFk` int(11) NOT NULL,
  `create_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login` int(11) NOT NULL,
  `account_type` int(11) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

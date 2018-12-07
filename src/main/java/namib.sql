-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 06 déc. 2018 à 23:57
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `namib`
--

-- --------------------------------------------------------

--
-- Structure de la table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL,
  `available` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `food_type`
--

DROP TABLE IF EXISTS `food_type`;
CREATE TABLE IF NOT EXISTS `food_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL,
  `calorie` int(11) NOT NULL,
  `quantity` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_carte`
--

DROP TABLE IF EXISTS `history_carte`;
CREATE TABLE IF NOT EXISTS `history_carte` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `updated_at` (`updated_at`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_energy`
--

DROP TABLE IF EXISTS `history_energy`;
CREATE TABLE IF NOT EXISTS `history_energy` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_equipment` int(11) NOT NULL,
  `value` float NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `equipment_name` (`id_equipment`),
  KEY `updated_at` (`updated_at`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_food`
--

DROP TABLE IF EXISTS `history_food`;
CREATE TABLE IF NOT EXISTS `history_food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `quantity_used` float NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `updated_at` (`updated_at`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_health`
--

DROP TABLE IF EXISTS `history_health`;
CREATE TABLE IF NOT EXISTS `history_health` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weight` float NOT NULL,
  `reactivity_time` float NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `updated_at` (`updated_at`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_maintenance`
--

DROP TABLE IF EXISTS `history_maintenance`;
CREATE TABLE IF NOT EXISTS `history_maintenance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_equipment` int(11) NOT NULL,
  `description` text NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_security`
--

DROP TABLE IF EXISTS `history_security`;
CREATE TABLE IF NOT EXISTS `history_security` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `description` text NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `updated_at` (`updated_at`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `history_water`
--

DROP TABLE IF EXISTS `history_water`;
CREATE TABLE IF NOT EXISTS `history_water` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity_used` float NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `updated_at` (`updated_at`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `security_type`
--

DROP TABLE IF EXISTS `security_type`;
CREATE TABLE IF NOT EXISTS `security_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

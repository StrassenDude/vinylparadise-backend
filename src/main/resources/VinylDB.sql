-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Erstellungszeit: 22. Mrz 2022 um 02:08
-- Server-Version: 10.4.20-MariaDB
-- PHP-Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `VinylDB`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cart`
--

CREATE TABLE `cart` (
  `cart_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `cart`
--

INSERT INTO `cart` (`cart_id`) VALUES
(34),
(36),
(68),
(70),
(72),
(74),
(76),
(78),
(80),
(82),
(84),
(86),
(88),
(90),
(92),
(94),
(96),
(98),
(100),
(102),
(104),
(106),
(108),
(110),
(112),
(114),
(116),
(124),
(128),
(134),
(137),
(140);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cart_item`
--

CREATE TABLE `cart_item` (
  `cart_item_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `cart_item`
--

INSERT INTO `cart_item` (`cart_item_id`, `quantity`, `cart_id`, `user_id`, `id`) VALUES
(27, 1, 26, 25, 6),
(28, 1, 26, 25, 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `category`
--

CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(3, 'HipHop'),
(5, 'Jazz'),
(148, 'Rock&Roll'),
(151, 'Reggae'),
(154, 'Retro');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(157);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `cart_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `password`, `role`, `user_name`, `email`, `cart_id`) VALUES
(35, 'q', 'q', '$2a$10$K3tM3/POxWKLc5REA7MqI.XDuqzQSUsOStGAR0Lh5cqr9VDHjPTUC', 'ROLE_ADMIN', 'q', 'q@q.q', 36),
(127, 'Stefan', 'Mensch', '$2a$10$BBlpv2Mw9P8mP3vU255CHuaEna7C4HXlixyGllnEkDCxWoMy4aOQ2', 'ROLE_USER', 'CoolUser1', 'third.last@email.com', 128),
(136, 'Laura', 'Esho', '$2a$10$AsJvWUO.3TdzbxCDUkA0delG8eEGefLOSUytrnQByxUMlmLqYeGTu', 'ROLE_USER', 'Slayer420', 'first.last@email.com', 137);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user_order`
--

CREATE TABLE `user_order` (
  `id` bigint(20) NOT NULL,
  `number_of_items_ordered` int(11) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `price_total` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `vinyl`
--

CREATE TABLE `vinyl` (
  `id` bigint(20) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `tracks` int(11) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `img_ref` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `vinyl`
--

INSERT INTO `vinyl` (`id`, `artist`, `name`, `price`, `tracks`, `category_id`, `img_ref`) VALUES
(6, '21 Savage', 'Issa Album', 21, 14, 3, 'http://localhost:8080/api/downloadFile/IssaAlbum21.jpg'),
(147, 'Flatbush Zombies', '3001: A laced odyssey', 3001, 3001, 3, 'http://localhost:8080/api/downloadFile/3001LacedOdysseyFBZ.jpg'),
(149, 'Green Day', 'American Idiot', 25.99, 9, 148, 'http://localhost:8080/api/downloadFile/AmericanIdiotGD.jpg'),
(150, 'Louis Armstrong', 'Best of Armstrong', 39.99, 32, 5, 'http://localhost:8080/api/downloadFile/BestOfLouisLA.jpg'),
(152, 'Manu Chao', 'Clandestino', 20.99, 16, 151, 'http://localhost:8080/api/downloadFile/ClandestinoMC.jpg'),
(153, 'Samurai Champloo', 'Departure', 25.99, 23, 3, 'http://localhost:8080/api/downloadFile/SamuraiChamplooNB.jpg'),
(155, 'Mugman', 'Cuphead', 22.9, 15, 154, 'http://localhost:8080/api/downloadFile/Cuphead.jpg'),
(156, 'Billy Talent', 'Crisis of Faith', 18.99, 17, 148, 'http://localhost:8080/api/downloadFile/CrisisOfFaith.jpg');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indizes für die Tabelle `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`cart_item_id`),
  ADD KEY `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id`),
  ADD KEY `FKjnaj4sjyqjkr4ivemf9gb25w` (`user_id`),
  ADD KEY `FK9drpm9bbheycrguj2k59bw9ac` (`id`);

--
-- Indizes für die Tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`) USING HASH,
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`) USING HASH,
  ADD KEY `FKtqa69bib34k2c0jhe7afqsao6` (`cart_id`);

--
-- Indizes für die Tabelle `user_order`
--
ALTER TABLE `user_order`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `vinyl`
--
ALTER TABLE `vinyl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf2q4j8esjc5o05t8h8edtedxd` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2021 a las 17:14:24
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `challenge_blog`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`ID`, `NAME`) VALUES
(1, 'Biografia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post`
--

CREATE TABLE `post` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `CONTENT` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `IMAGE` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `ID_CATEGORY` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `post`
--

INSERT INTO `post` (`ID`, `TITLE`, `CONTENT`, `IMAGE`, `CREATION_DATE`, `ID_USER`, `ID_CATEGORY`) VALUES
(2, 'Como logre ser programador', 'blabla  bla...', 'https://i.postimg.cc/pddN5Nqn/programar.jpg', '2010-10-20', 1, 1),
(3, 'Dar Paz', 'Bla bla paz', 'https://i.postimg.cc/bJQRzrk0/Paz.jpg', '2015-11-04', 1, 1),
(4, 'Etapas', 'Etapass bla bla bla....', 'https://i.postimg.cc/h45qnm59/etapas.jpg', '2017-04-23', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `EMAIL` varchar(70) COLLATE utf8mb4_spanish_ci NOT NULL,
  `PASSWORD` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`ID`, `EMAIL`, `PASSWORD`) VALUES
(1, 'roquealbertoespinoza@gmail.com', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_USER` (`ID_USER`),
  ADD KEY `FK_CATEGORIA` (`ID_CATEGORY`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `post`
--
ALTER TABLE `post`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_CATEGORIA` FOREIGN KEY (`ID_CATEGORY`) REFERENCES `category` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USER` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

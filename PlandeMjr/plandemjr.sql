-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-01-2017 a las 13:52:56
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `plandemjr`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `correo`, `telefono`, `direccion`) VALUES
(1, 'Fernanda Ramirez', 'feram@gmail.com', 563543, 'cra 33 #12-34'),
(2, 'Pedro Andrade ', 'pedan@email.com', 543553, 'tr 43 #32-43'),
(3, 'Ana Vergara ', 'anva@email.com', 545433, 'cra 26#54-21'),
(4, 'Carlos Sanchez ', 'carsa@email.com', 6453432, 'cra 77#23-12'),
(5, 'Patricia Cueca', 'pacu@email.com', 5634323, 'cr 27#65-12'),
(6, 'Fernando Gil', 'fergil@email.com', 3423423, 'cra te pizco el hollo'),
(8, 'Marisol Galindo', 'marig@email.com', 3423423, 'cra te pizco el hollo2'),
(9, 'Arturo Street', 'arts@email.com', 4354, 'cra te pizco el hollo3'),
(10, 'Isabella Hernandez', 'isah@email.com', 54789, 'akjshk'),
(12, 'Bruno Diaz', 'batsi@email.com', 5443786, 'assdas'),
(13, 'Steven Herrera', 'stehe@email.com', 43458376, 'cra 82b #42c 39'),
(14, 'Camila Alvarez', 'calz@email.com', 46354, 'cra 43#42c 39'),
(15, 'Rafael Nuñez', 'rafanu@email.com', 4345354, 'cra 4 #  54 -64'),
(16, 'Fernanda Garzon', 'ferga@email.com', 765436765, 'cra 45# 56-32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concesionario`
--

CREATE TABLE `concesionario` (
  `nit` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `direccion` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concesionario`
--

INSERT INTO `concesionario` (`nit`, `nombre`, `password`, `telefono`, `direccion`) VALUES
(1, 'Auto Blitz', '1234', '43436', 'cra 70#95-15'),
(2, 'Jorge Cortes y Cia', '5678', '984734', '89, Autonorte #118'),
(3, 'Los Coches Volvo en Morato', '2345', '439787', 'Cl 42#54-32'),
(4, 'Casa Toro Usados', '3456', '3498573', 'cl 68#66-30'),
(5, 'Los Coches Ford', '4567', '6786737', 'cl 127#7133');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `idVehiculo` int(11) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `idConcecionario` int(11) NOT NULL,
  `lanzamiento` int(11) NOT NULL,
  `imagen` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`idVehiculo`, `marca`, `modelo`, `precio`, `idConcecionario`, `lanzamiento`, `imagen`) VALUES
(1, 'Volkswagen', 'Nuevo Jetta GLI', 61.49, 1, 2013, 'jettagli'),
(2, 'Mazda', 'Mazda 2 Touring', 48, 2, 2016, 'mazda2'),
(3, 'Volvo', 'V40', 82, 3, 2016, 'v40'),
(4, 'Renault', 'Symbol ll Luxe', 24.9, 4, 2012, 'symbol'),
(5, 'Ford ', 'Fiesta Sedan', 31.9, 5, 2015, 'fiestasedan'),
(6, 'Volkswagen comercial', 'Saveiro', 34.5, 1, 2015, 'saveiro'),
(7, 'Ford', 'Fusion Titanium', 80, 2, 2016, 'fusion'),
(8, 'Hyundai', 'Accent Sedan', 8.9, 3, 2015, 'accentsedan'),
(9, 'Nissan ', 'Tiida Emotion', 26.9, 4, 2013, 'tiidaemotion'),
(10, 'Ford', 'Focus Sedan', 55.9, 5, 2012, 'focusedan'),
(26, 'Volkswagen', 'Beetle', 9, 1, 2011, 'beetle'),
(27, 'Mazda', 'Mazda CX-5 Prime', 80.05, 2, 2016, 'mazdacx'),
(28, 'Audi', 'A1 Sportback', 73.9, 3, 2017, 'a1s'),
(29, 'Chevrolet ', 'Sonic LT Sedan', 35.9, 4, 2016, 'soniclt'),
(30, 'Ford', 'Explorer Limited', 153.99, 5, 2016, 'explorerl'),
(31, 'Audi', 'A4 Berlina', 103, 1, 2017, 'a4berlina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `idCliente`, `idVehiculo`, `fecha`) VALUES
(1, 1, 1, '2017-01-17'),
(2, 2, 30, '2016-12-18'),
(3, 3, 7, '2016-10-17'),
(4, 4, 26, '2017-01-10'),
(5, 5, 9, '2017-01-02'),
(6, 6, 1, '2017-01-11');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `concesionario`
--
ALTER TABLE `concesionario`
  ADD PRIMARY KEY (`nit`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`idVehiculo`),
  ADD KEY `idConcecionario` (`idConcecionario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idVehiculo` (`idVehiculo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `concesionario`
--
ALTER TABLE `concesionario`
  MODIFY `nit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `idVehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`idConcecionario`) REFERENCES `concesionario` (`nit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idVehiculo`) REFERENCES `vehiculo` (`idVehiculo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-06-2018 a las 04:09:01
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pmrti`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE `documento` (
  `id_documento` int(11) NOT NULL,
  `rut_solicitante` int(11) NOT NULL,
  `rut_receptor` varchar(20) NOT NULL,
  `rut_TI` int(11) NOT NULL,
  `fecha_solicitud` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `fecha_devolucion` date NOT NULL,
  `estado` int(11) NOT NULL,
  `tipo_documento` varchar(3) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `id_tipo_Equipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id_equipo` int(11) NOT NULL,
  `id_tipo_equipo` int(11) NOT NULL,
  `serie` varchar(60) NOT NULL,
  `cod_interno` varchar(60) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `modelo` varchar(60) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id_equipo`, `id_tipo_equipo`, `serie`, `cod_interno`, `marca`, `modelo`, `estado`) VALUES
(1, 1, 'PC-6070', 'PC-001', 'HP', 'HP-539', 1),
(2, 2, 'NT-251', 'NOTE-001', 'HP', 'HP-100', 2),
(3, 1, '101', 'cd-100', 'hp', 'hp-100', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_documento`
--

CREATE TABLE `estado_documento` (
  `id_estado` int(11) NOT NULL,
  `desc_estado` varchar(60) NOT NULL,
  `grupo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_documento`
--

INSERT INTO `estado_documento` (`id_estado`, `desc_estado`, `grupo`) VALUES
(1, 'solicitud', 1),
(2, 'espera', 1),
(3, 'pendiente', 2),
(4, 'detenido', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_equipo`
--

CREATE TABLE `estado_equipo` (
  `id_estado_equipo` int(11) NOT NULL,
  `desc_estado` varchar(60) NOT NULL,
  `grupo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_equipo`
--

INSERT INTO `estado_equipo` (`id_estado_equipo`, `desc_estado`, `grupo`) VALUES
(1, 'disponible', 1),
(2, 'En mantenimiento', 3),
(3, 'En prestamo', 3),
(4, 'Asignado', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_equipo`
--

CREATE TABLE `tipo_equipo` (
  `id_tipo_equipo` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_equipo`
--

INSERT INTO `tipo_equipo` (`id_tipo_equipo`, `nombre`) VALUES
(1, 'PC Desktop'),
(2, 'PC Notebook'),
(3, 'Proyector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmp_usuario`
--

CREATE TABLE `tmp_usuario` (
  `ID_RUT` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido_paterno` varchar(60) NOT NULL,
  `apellido_materno` varchar(60) NOT NULL,
  `departamento` varchar(60) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`id_documento`),
  ADD KEY `estado` (`estado`),
  ADD KEY `id_equipo` (`id_equipo`),
  ADD KEY `id_tipo_Equipo` (`id_tipo_Equipo`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id_equipo`),
  ADD KEY `id_tipo_equipo` (`id_tipo_equipo`),
  ADD KEY `estado` (`estado`);

--
-- Indices de la tabla `estado_documento`
--
ALTER TABLE `estado_documento`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `estado_equipo`
--
ALTER TABLE `estado_equipo`
  ADD PRIMARY KEY (`id_estado_equipo`);

--
-- Indices de la tabla `tipo_equipo`
--
ALTER TABLE `tipo_equipo`
  ADD PRIMARY KEY (`id_tipo_equipo`);

--
-- Indices de la tabla `tmp_usuario`
--
ALTER TABLE `tmp_usuario`
  ADD PRIMARY KEY (`ID_RUT`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `documento`
--
ALTER TABLE `documento`
  MODIFY `id_documento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estado_documento`
--
ALTER TABLE `estado_documento`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_equipo`
--
ALTER TABLE `tipo_equipo`
  MODIFY `id_tipo_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `documento`
--
ALTER TABLE `documento`
  ADD CONSTRAINT `documento_ibfk_1` FOREIGN KEY (`estado`) REFERENCES `estado_documento` (`id_estado`),
  ADD CONSTRAINT `documento_ibfk_2` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`),
  ADD CONSTRAINT `documento_ibfk_3` FOREIGN KEY (`id_tipo_Equipo`) REFERENCES `tipo_equipo` (`id_tipo_equipo`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`id_tipo_equipo`) REFERENCES `tipo_equipo` (`id_tipo_equipo`),
  ADD CONSTRAINT `equipo_ibfk_2` FOREIGN KEY (`estado`) REFERENCES `estado_equipo` (`id_estado_equipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

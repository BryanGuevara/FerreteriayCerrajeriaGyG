-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 31-08-2023 a las 23:40:04
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ferre`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Precio` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Drescripcion` longtext COLLATE utf8_unicode_ci NOT NULL,
  `Existencias` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Marca` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`ID`, `Nombre`, `Precio`, `Drescripcion`, `Existencias`, `Marca`) VALUES
(1, 'Martillo 16oz', '$3.00', 'Cabeza forjada en acero, cara totalmente pulida\n\nMango de fibra de vidrio con grip de doble \ninyección que reduce las vibraciones del golpe', 'Si Tenemos', 'Truper'),
(2, 'Lijas para agua #100', '$1.00', 'Se pueden utilizar con agua', 'Si Tenemos', 'Truper'),
(3, 'Taladro', '$60.00', 'Taladro Rotomartillo\r\nGarantia de 1 año\r\nResistente a Impactos', 'No Tenemos', 'Viduc'),
(4, 'Duplicado', '$--.--', 'Se duplican llaves\r\n\r---------------------------------------------------------------------\nChapa y Candado = $1.00\r\nCortina = $2.00\r\nCarro y Moto = $2.50\n---------------------------------------------------------------------', 'No Tenemos', 'Nulo'),
(5, 'Taladro', '$115.00', 'Taladro de 3/8 Inalámbrico Atornillador\r\nDestornillador Select de 20V 1.5Ah \r\nINCLUYE Estuche y 2 Baterias\r\nGarantia de 1 año ante daños de fabrica', 'No Tenemos', 'Total'),
(6, 'Juego Desarmadores', '$5.00', '10 destornilladores\r\n5 de cada uno\r\nmango antiderrapante\r\nResistente ante impactos', 'No Tenemos', 'Total'),
(7, 'Marco de Sierra', '$7.50', 'Hecha de Acero\r\nResistente a Impactos', 'No Tenemos', 'Total'),
(8, 'Lampara con sensor de Movimiento', '$15.00', 'Luces exteriores con sensor de movimiento\r\nluz solar de inundación\r\n210 LED\r\n2500 lúmenes\r\n6500 K', 'No Tenemos', 'Iml'),
(9, 'Foco Disco', '$10.00', 'FOCO MULTICOLOR FOCO DISCO LED-3CL', 'No Tenemos', 'Iml'),
(10, 'Llaveros porta carnet', '$0.50', 'hecho de cuero\nse puede poner DUI, Carnet de Menoridad\nPermiso para manejar, etc', 'No Tenemos', 'Nulo'),
(11, 'Taladro', '$80.00', 'Taladro de alta durabilidad\nResistente a impactos', 'No Tenemos', 'Truper'),
(12, 'Soldador', '$189.00', '200 Amperios\ncaimanes incluidos', 'No Tenemos', 'Truper'),
(13, 'Destornillador', '$3.00', 'Mango anti derrapante\npunta imantada\nresistente a impactos', 'No Tenemos', 'Total'),
(14, 'Foco Matamosquitos', '$5.00', 'Mata moscas y mosquitos', 'No Tenemos', 'Inversiones Asiaticas'),
(15, 'Foco Ventilador', '$10.00', 'aspas flexibles', 'No Tenemos', 'Inversiones Asiaticas'),
(16, 'Foco Bluetooth', '$8.00', 'Luces LED 48W\nBlanco y RGB\nControl Remoto Incluido\nBluetooth\nHasta 1 año de garantia', 'No Tenemos', 'Inversiones Asiaticas'),
(17, 'Motor Trif. 1.5HP', '$3.00', 'Caballos de fuerza:caballos de fuerza1-1/2\n1.15Factor de Servicio\nRPM:1725 RPM\nVoltaje:208-230/460voltios, trifásico,\n60 Hz,\n(FLA4.4)\nCarcasa:TEFC\nTotalmente Encerrado Enfriado porVentilador\nAPLICACIONES\nDE (LA)Teniendo# 6205\nODE(End DriveFrente)Teniendo#6203', 'No Tenemos', 'Viduc'),
(18, 'Correa con pechera', '$--.--', 'Resistente\nen varios colores\ntallas: pequeño, mediano grando', 'No Tenemos', 'Truper'),
(19, 'Motor Monof. 2HP', '$3.00', 'Caballos de fuerza:2 caballos de fuerza\n1.15Factor de Servicio\nRPM:1725 RPM\nVoltaje:115/230voltios, monofásica,\n60 Hz,\n(FLA10,5)\nCaja:ODP (Abiertoa prueba de goteo)\nAPLICACIONES\nDE (LA)Teniendo# 6205\nODE(End DriveFrente)Teniendo#6203', 'No Tenemos', 'Viduc'),
(20, 'Destorcedor', '$2.00', 'Hecho de acero inoxidable', 'No Tenemos', 'Truper'),
(21, 'Anillos para Llaves', '$0.15', 'Hechas de acero\ntamaño pequeño\n\n--------------------------\npuede llevar una gratis si saca un duplicado', 'No Tenemos', 'Nulo'),
(22, 'Juego de Llaves Allen', '$3.00', 'Juego de 7 Llaves Allen de Acero Inoxiable \n\nPretul', 'No Tenemos', 'Truper'),
(23, 'Serrucho', '$5.00', 'Mango de madera\n\nsirve para cortar madera', 'No Tenemos', 'Truper');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pronombres`
--

CREATE TABLE `pronombres` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `IdProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `pronombres`
--

INSERT INTO `pronombres` (`ID`, `Nombre`, `IdProducto`) VALUES
(1, 'Martillo', 1),
(2, 'Mazo', 1),
(3, 'Masa', 1),
(4, 'Martinete', 1),
(5, 'Amádena', 1),
(6, 'Martillo Truper', 1),
(7, 'Lija', 2),
(8, 'Lija Agua', 2),
(9, 'Lija Media', 2),
(10, 'Lija #100', 2),
(11, '#100', 2),
(12, 'Escualo', 2),
(13, 'Galludo', 2),
(14, 'Cazón', 2),
(15, 'Martillo 16oz', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `User` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Contraseña` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`User`, `Nombre`, `Contraseña`) VALUES
('Betty', 'Ana Ruth Elizabeth Gerrero de Guevara', 'Sacha45'),
('Bryan', 'Bryan Alberto Guevara Guerrero', 'Bryan300'),
('Jaime', 'Jaime Alberto Guevara', 'ElJefe01');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`ID`) USING BTREE;

--
-- Indices de la tabla `pronombres`
--
ALTER TABLE `pronombres`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`User`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulos`
--
ALTER TABLE `articulos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `pronombres`
--
ALTER TABLE `pronombres`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

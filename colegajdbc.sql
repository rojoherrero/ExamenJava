CREATE SCHEMA `colegajdbc` ;

CREATE TABLE `colegajdbc`.`colega` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`id`));
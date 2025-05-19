CREATE DATABASE profeco;

CREATE TABLE `profeco`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL,
  `apellidoPaterno` VARCHAR(45) NULL,
  `apellidoMaterno` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isAdmin` VARCHAR(45) BINARY NULL,
  `idEmpresa` INT NULL DEFAULT 0,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  


CREATE TABLE `profeco`.`empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `tipoNegocio` VARCHAR(45) NULL,
  PRIMARY KEY (`idEmpresa`));

ALTER TABLE `profeco`.`usuario` 
ADD INDEX `fk_usuario_idEmpresa_idx` (`idEmpresa` ASC) VISIBLE;
;
ALTER TABLE `profeco`.`usuario` 
ADD CONSTRAINT `fk_usuario_idEmpresa`
  FOREIGN KEY (`idEmpresa`)
  REFERENCES `profeco`.`empresa` (`idEmpresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `profeco`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(150) NULL,
  `precio` DOUBLE NULL,
  `oferta` TINYINT NULL,
  `etiqueta` VARCHAR(45) NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_producto_idEmpresa_idx` (`idEmpresa` ASC) VISIBLE,
  CONSTRAINT `fk_producto_idEmpresa`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `profeco`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `profeco`.`usuario` 
CHANGE COLUMN `isAdmin` `isAdmin` TINYINT NULL DEFAULT NULL ;


CREATE TABLE `profeco`.`reporte` (
  `idReporte` INT NOT NULL AUTO_INCREMENT,
  `fechaCreacion` DATE NULL,
  `idEmpresa` INT NULL,
  `idUsuario` INT NULL,
  `descripcion` VARCHAR(300) NULL,
  `estado` VARCHAR(45) NULL DEFAULT 'Sin procesar',
  PRIMARY KEY (`idReporte`),
  INDEX `fk_reporte_idEmpresa_idx` (`idEmpresa` ASC) VISIBLE,
  INDEX `fk_reporte_idUsuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_reporte_idEmpresa`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `profeco`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reporte_idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `profeco`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `profeco`.`usuario` 
CHANGE COLUMN `nombres` `nombre` VARCHAR(45) NULL DEFAULT NULL ;

INSERT INTO `profeco`.`empresa` (`idEmpresa`) VALUES ('0');

ALTER TABLE `profeco`.`usuario` 
DROP FOREIGN KEY `fk_usuario_idEmpresa`;
ALTER TABLE `profeco`.`usuario` 
CHANGE COLUMN `idEmpresa` `idEmpresa` INT NULL ;
ALTER TABLE `profeco`.`usuario` 
ADD CONSTRAINT `fk_usuario_idEmpresa`
  FOREIGN KEY (`idEmpresa`)
  REFERENCES `profeco`.`empresa` (`idEmpresa`);

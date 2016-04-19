-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema controleestoque
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema controleestoque
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controleestoque` DEFAULT CHARACTER SET utf8 ;
USE `controleestoque` ;

-- -----------------------------------------------------
-- Table `controleestoque`.`tb_construtora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controleestoque`.`tb_construtora` ;

CREATE TABLE IF NOT EXISTS `controleestoque`.`tb_construtora` (
  `cd_construtora` INT NOT NULL AUTO_INCREMENT,
  `nm_construtora` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cd_construtora`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controleestoque`.`tb_obra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controleestoque`.`tb_obra` ;

CREATE TABLE IF NOT EXISTS `controleestoque`.`tb_obra` (
  `cd_obra` INT NOT NULL AUTO_INCREMENT,
  `nm_obra` VARCHAR(45) NOT NULL,
  `ds_endereco` VARCHAR(50) NOT NULL,
  `numero` DECIMAL(6) NOT NULL,
  `cd_construtora` INT NOT NULL,
  PRIMARY KEY (`cd_obra`),
  INDEX `fk_tb_obra_tb_construtora1_idx` (`cd_construtora` ASC),
  CONSTRAINT `fk_tb_obra_tb_construtora1`
    FOREIGN KEY (`cd_construtora`)
    REFERENCES `controleestoque`.`tb_construtora` (`cd_construtora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controleestoque`.`tb_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controleestoque`.`tb_material` ;

CREATE TABLE IF NOT EXISTS `controleestoque`.`tb_material` (
  `cd_material` INT NOT NULL AUTO_INCREMENT,
  `nm_material` VARCHAR(45) NOT NULL,
  `qt_estoque` SMALLINT(6) NOT NULL,
  PRIMARY KEY (`cd_material`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controleestoque`.`almoxarifado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controleestoque`.`almoxarifado` ;

CREATE TABLE IF NOT EXISTS `controleestoque`.`almoxarifado` (
  `cd_almoxarifado` INT NOT NULL AUTO_INCREMENT,
  `resp_almoxarifado` VARCHAR(45) NOT NULL,
  `cd_obra` INT NOT NULL,
  PRIMARY KEY (`cd_almoxarifado`),
  INDEX `fk_almoxarifado_tb_obra1_idx` (`cd_obra` ASC),
  CONSTRAINT `fk_almoxarifado_tb_obra1`
    FOREIGN KEY (`cd_obra`)
    REFERENCES `controleestoque`.`tb_obra` (`cd_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controleestoque`.`alocacao_de_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controleestoque`.`alocacao_de_material` ;

CREATE TABLE IF NOT EXISTS `controleestoque`.`alocacao_de_material` (
  `qtd_solicitada` INT NOT NULL,
  `dt_solicitacao` DATE NOT NULL,
  `nm_solicitante` VARCHAR(45) NOT NULL,
  `cd_material` INT NOT NULL,
  `cd_almoxarifado` INT NOT NULL,
  INDEX `fk_alocacao_de_material_tb_material1_idx` (`cd_material` ASC),
  INDEX `fk_alocacao_de_material_almoxarifado1_idx` (`cd_almoxarifado` ASC),
  PRIMARY KEY (`cd_almoxarifado`, `cd_material`),
  CONSTRAINT `fk_alocacao_de_material_tb_material1`
    FOREIGN KEY (`cd_material`)
    REFERENCES `controleestoque`.`tb_material` (`cd_material`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alocacao_de_material_almoxarifado1`
    FOREIGN KEY (`cd_almoxarifado`)
    REFERENCES `controleestoque`.`almoxarifado` (`cd_almoxarifado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

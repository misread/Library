CREATE DATABASE `library`;

DROP TABLE IF EXISTS `library`.`book`;
CREATE TABLE  `library`.`book` (
  `id` BIGINT (10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `publication_year` INT(4),
  PRIMARY KEY (`id`)
) CHARSET=utf8;

DROP TABLE IF EXISTS `library`.`visitor`;
CREATE TABLE  `library`.`visitor` (
  `id` BIGINT (10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `age` INT(3),
  PRIMARY KEY (`id`)
) CHARSET=utf8;

DROP TABLE IF EXISTS `library`.`librarian`;
CREATE TABLE  `library`.`librarian` (
  `id` BIGINT (10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) CHARSET=utf8;

DROP TABLE IF EXISTS `library`.`order`;
CREATE TABLE  `library`.`order` (
  `id` BIGINT (10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP,
  `book_id` BIGINT (10) UNSIGNED NOT NULL,
  `visitor_id` BIGINT (10) UNSIGNED NOT NULL,
  `status` VARCHAR(20),
  PRIMARY KEY (`id`),
CONSTRAINT `order_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT `order_visitor` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
) CHARSET=utf8;


CREATE DATABASE `ecommkw`;

CREATE TABLE realm_users (
	user_email varchar(45) NOT NULL PRIMARY KEY,
	password varchar(45) NOT NULL
);

CREATE TABLE realm_roles (
	role_name varchar(20) NOT NULL PRIMARY KEY
);

CREATE TABLE realm_users_roles (
	user_email varchar(45) NOT NULL,
	role_name varchar(20) NOT NULL,
	PRIMARY KEY (user_email, role_name),
	CONSTRAINT realm_users_roles_foreign_key_1 FOREIGN KEY (user_email) REFERENCES realm_users (user_email),
	CONSTRAINT realm_users_roles_foreign_key_2 FOREIGN KEY (role_name) REFERENCES realm_roles (role_name)
);

INSERT INTO realm_users(user_email,password) VALUES ('admin@email.com.br','admin'); -- Administrator
INSERT INTO realm_users(user_email,password) VALUES ('custo@email.com.br','custo'); -- Customer
INSERT INTO realm_users(user_email,password) VALUES ('guest@email.com.br','guest'); -- Guest

INSERT INTO realm_roles(role_name) VALUES ('ADMINISTRATORS'); -- Administrator
INSERT INTO realm_roles(role_name) VALUES ('CUSTOMERS'); -- Customer
INSERT INTO realm_roles(role_name) VALUES ('GUESTS'); -- Guest

INSERT INTO realm_users_roles(user_email,role_name) VALUES ('admin@email.com.br','ADMINISTRATORS'); -- Administrator
INSERT INTO realm_users_roles(user_email,role_name) VALUES ('custo@email.com.br','CUSTOMERS'); -- Customer
INSERT INTO realm_users_roles(user_email,role_name) VALUES ('guest@email.com.br','GUESTS'); -- Guest

CREATE  TABLE IF NOT EXISTS `customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NOT NULL ,
  `city_region` VARCHAR(2) NOT NULL ,
  `cpf_number` VARCHAR(19) NOT NULL ,
  `password` VARCHAR(19) NOT NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = 'maintains customer details';

INSERT INTO customer(name,email,phone,address,city_region,cpf_number,password) VALUES ('customer1','custo@email.com.br','(11)999999999','address1','r1','89743778703','custo'); -- Customer

CREATE  TABLE IF NOT EXISTS `category` (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = 'contains product categories';

INSERT INTO `category` (name) VALUES ('Categoria 1'),('Categoria 2'),('Categoria 3'),('Categoria 4');

CREATE  TABLE IF NOT EXISTS `product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `price` DECIMAL(8,2) NOT NULL ,  
  `description` TINYTEXT NULL ,
  `picture` TINYTEXT NULL ,
  `category_id` TINYINT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_product_category` (`category_id` ASC) ,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id` )
    REFERENCES `category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'contains product details';

INSERT INTO `product` (`name`, price, description, picture, category_id) VALUES ('Produto 1', 1.00, 'Descrição 1', 'argiano.jpg', 1);
INSERT INTO `product` (`name`, price, description, picture, category_id) VALUES ('Produto 2', 2.00, 'Descrição 2', 'block_nine.jpg', 1);
INSERT INTO `product` (`name`, price, description, picture, category_id) VALUES ('Produto 3', 3.00, 'Descrição 3', 'bouscat.jpg', 1);
INSERT INTO `product` (`name`, price, description, picture, category_id) VALUES ('Produto 4', 4.00, 'Descrição 4', 'caronne.jpg', 1);

DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS cart_product;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS product_details;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS store_product;

CREATE TABLE brand(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE product_details(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    link VARCHAR(300),
    safety_data VARCHAR(300),
    brand_id BIGINT NOT NULL,
    gama VARCHAR(100),
    code VARCHAR(100)
);

CREATE TABLE employee(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(200) NOT NULL,
    store_id BIGINT NOT NULL
);

CREATE TABLE employee_role(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name varchar(100)                      NOT NULL
);

CREATE TABLE employee_roles(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (role_id) REFERENCES employee_role(id)
);

CREATE TABLE cart(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    employee_id BIGINT NOT NULL
);

CREATE TABLE cart_product(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_quantity BIGINT NOT NULL,
    product_details_id BIGINT NOT NULL,
    cart_id BIGINT NOT NULL
);

CREATE TABLE `order`(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    status VARCHAR(100) NOT NULL,
    date_of_order DATE NOT NULL,
    employee_id BIGINT NOT NULL,
    store_id BIGINT NOT NULL
);

CREATE TABLE order_product(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    product_details_id BIGINT NOT NULL,
    product_quantity BIGINT NOT NULL
);

CREATE TABLE store(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE store_product(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    store_id BIGINT NOT NULL,
    product_details_id BIGINT NOT NULL,
    product_quantity BIGINT NOT NULL
);




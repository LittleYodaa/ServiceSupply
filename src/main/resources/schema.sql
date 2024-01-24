CREATE TABLE brand(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100)
);

CREATE TABLE cart(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    employee_id BIGINT
);

CREATE TABLE cart_product(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_quantity BIGINT,
    product_details_id BIGINT,
    cart_id BIGINT
);

CREATE TABLE employee(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(200),
    store_id BIGINT
);

CREATE TABLE `order`(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    status VARCHAR(100),
    date_of_order DATE,
    employee_id BIGINT,
    store_id BIGINT
);

CREATE TABLE order_product(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    order_id BIGINT,
    product_details_id BIGINT,
    product_quantity BIGINT
);

CREATE TABLE product_details(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    link VARCHAR(300),
    brand_id BIGINT
);

CREATE TABLE store(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(100)
);

CREATE TABLE store_product(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    store_id BIGINT,
    product_details_id BIGINT,
    product_quantity BIGINT
);


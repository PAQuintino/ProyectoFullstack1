-- liquibase formatted sql

-- changeset andree:1
CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- changeset andree:2
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10,2),
    categoria_id BIGINT
);

-- changeset andree:3
INSERT INTO categorias (nombre) VALUES ('Electrónica');
INSERT INTO categorias (nombre) VALUES ('Ropa');
INSERT INTO categorias (nombre) VALUES ('Hogar');
INSERT INTO categorias (nombre) VALUES ('Deportes');
INSERT INTO categorias (nombre) VALUES ('Libros');

-- changeset andree:4
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Laptop HP', 899.99, 1);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Mouse Logitech', 29.99, 1);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Teclado Mecánico', 79.99, 1);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Polera Nike', 35.00, 2);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Zapatillas Adidas', 120.00, 2);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Silla Gamer', 250.00, 3);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Escritorio', 180.00, 3);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Balón de Fútbol', 25.00, 4);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Raqueta de Tenis', 90.00, 4);
INSERT INTO productos (nombre, precio, categoria_id) VALUES ('Cien Años de Soledad', 15.00, 5);
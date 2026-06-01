-- liquibase formatted sql

-- changeset andree:1
CREATE TABLE almacenes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ubicacion VARCHAR(255) NOT NULL
);

-- changeset andree:2
CREATE TABLE stock (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    producto_id BIGINT,
    cantidad INT DEFAULT 0,
    almacen_id BIGINT,
    CONSTRAINT fk_stock_almacen FOREIGN KEY (almacen_id) REFERENCES almacenes(id)
);
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

-- changeset andree:3
INSERT INTO almacenes (ubicacion) VALUES ('Bodega Central Santiago');
INSERT INTO almacenes (ubicacion) VALUES ('Bodega Norte Antofagasta');
INSERT INTO almacenes (ubicacion) VALUES ('Bodega Sur Concepción');

-- changeset andree:4
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (1, 50, 1);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (2, 200, 1);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (3, 100, 1);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (4, 75, 2);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (5, 30, 2);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (6, 20, 3);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (7, 15, 3);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (8, 60, 1);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (9, 25, 2);
INSERT INTO stock (producto_id, cantidad, almacen_id) VALUES (10, 40, 3);
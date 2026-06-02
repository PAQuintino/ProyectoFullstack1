-- liquibase formatted sql

-- changeset andree:1
CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(255) NOT NULL
);

-- changeset andree:2
CREATE TABLE perfiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    bio TEXT,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- changeset andree:3
INSERT INTO clientes (nombre, email, telefono) VALUES ('Pablo Quintino', 'pablo@test.com', '+56912345678');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Juan García', 'juan@test.com', '+56912345679');
INSERT INTO clientes (nombre, email, telefono) VALUES ('María López', 'maria@test.com', '+56912345680');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Carlos Rodríguez', 'carlos@test.com', '+56912345681');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Ana Martínez', 'ana@test.com', '+56912345682');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Fernando Pérez', 'fernando@test.com', '+56912345683');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Laura Sánchez', 'laura@test.com', '+56912345684');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Diego Flores', 'diego@test.com', '+56912345685');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Sofía Torres', 'sofia@test.com', '+56912345686');
INSERT INTO clientes (nombre, email, telefono) VALUES ('Roberto Ávila', 'roberto@test.com', '+56912345687');

-- changeset andree:4
INSERT INTO perfiles (cliente_id, bio) VALUES (1, 'Cliente VIP desde 2020');
INSERT INTO perfiles (cliente_id, bio) VALUES (2, 'Comprador frecuente');
INSERT INTO perfiles (cliente_id, bio) VALUES (3, 'Cliente nuevo');
INSERT INTO perfiles (cliente_id, bio) VALUES (4, 'Preferente');
INSERT INTO perfiles (cliente_id, bio) VALUES (5, 'Cliente premium');
INSERT INTO perfiles (cliente_id, bio) VALUES (6, 'Comprador ocasional');
INSERT INTO perfiles (cliente_id, bio) VALUES (7, 'Cliente activo');
INSERT INTO perfiles (cliente_id, bio) VALUES (8, 'Referenciado');
INSERT INTO perfiles (cliente_id, bio) VALUES (9, 'Cliente corporativo');
INSERT INTO perfiles (cliente_id, bio) VALUES (10, 'Cliente leal');
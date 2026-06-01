-- liquibase formatted sql

-- changeset andree:1
CREATE TABLE pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    cantidad INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha DATETIME
);

-- changeset andree:2
CREATE TABLE items_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    producto_id BIGINT,
    cantidad INT,
    CONSTRAINT fk_items_ped FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);
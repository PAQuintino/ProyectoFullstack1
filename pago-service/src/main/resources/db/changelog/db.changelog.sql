-- liquibase formatted sql

-- changeset andree:1
CREATE TABLE metodos_pago (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    monto DECIMAL NOT NULL,
    metodo_pago VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL
);

-- changeset andree:2
CREATE TABLE transacciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    monto DECIMAL(10,2),
    estado VARCHAR(50),
    metodo_id BIGINT,
    CONSTRAINT fk_pago_metodo FOREIGN KEY (metodo_id) REFERENCES metodos_pago(id)


);
-- liquibase formatted sql

-- changeset andree:1
CREATE TABLE metodos_pago (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
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

-- changeset andree:3
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (1, 899.99, 'tarjeta', 'PAGADO', 'crédito');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (2, 159.98, 'tarjeta', 'PENDIENTE', 'débito');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (3, 120.00, 'transferencia', 'PAGADO', 'bancaria');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (4, 89.97, 'tarjeta', 'PAGADO', 'crédito');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (5, 180.00, 'efectivo', 'PENDIENTE', 'efectivo');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (6, 70.00, 'tarjeta', 'PAGADO', 'débito');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (7, 250.00, 'transferencia', 'CANCELADO', 'bancaria');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (8, 100.00, 'tarjeta', 'PAGADO', 'crédito');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (9, 90.00, 'efectivo', 'PENDIENTE', 'efectivo');
INSERT INTO metodos_pago (pedido_id, monto, metodo_pago, estado, tipo) VALUES (10, 30.00, 'tarjeta', 'PAGADO', 'débito');

-- changeset andree:4
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (1, 899.99, 'APROBADA', 1);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (2, 159.98, 'PENDIENTE', 2);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (3, 120.00, 'APROBADA', 3);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (4, 89.97, 'APROBADA', 4);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (5, 180.00, 'PENDIENTE', 5);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (6, 70.00, 'APROBADA', 6);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (7, 250.00, 'RECHAZADA', 7);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (8, 100.00, 'APROBADA', 8);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (9, 90.00, 'PENDIENTE', 9);
INSERT INTO transacciones (pedido_id, monto, estado, metodo_id) VALUES (10, 30.00, 'APROBADA', 10);
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

-- changeset andree:3
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (1, 1, 1, 'COMPLETADO', '2026-01-15 10:30:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (2, 3, 2, 'PENDIENTE', '2026-02-20 14:00:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (3, 5, 1, 'COMPLETADO', '2026-03-10 09:15:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (1, 2, 3, 'ENVIADO', '2026-03-25 16:45:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (4, 7, 1, 'PENDIENTE', '2026-04-01 11:00:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (5, 4, 2, 'COMPLETADO', '2026-04-10 08:30:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (2, 6, 1, 'CANCELADO', '2026-04-15 13:20:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (6, 8, 4, 'ENVIADO', '2026-05-01 10:00:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (3, 9, 1, 'PENDIENTE', '2026-05-10 15:30:00');
INSERT INTO pedidos (cliente_id, producto_id, cantidad, estado, fecha) VALUES (7, 10, 2, 'COMPLETADO', '2026-05-20 12:00:00');

-- changeset andree:4
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (1, 1, 1);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (2, 3, 2);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (3, 5, 1);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (4, 2, 3);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (5, 7, 1);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (6, 4, 2);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (7, 6, 1);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (8, 8, 4);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (9, 9, 1);
INSERT INTO items_pedido (pedido_id, producto_id, cantidad) VALUES (10, 10, 2);
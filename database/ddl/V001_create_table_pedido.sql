CREATE DATABASE IF NOT EXISTS pedidos_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE pedidos_db;

CREATE TABLE pedido (
                        id BIGINT NOT NULL AUTO_INCREMENT,

                        cliente VARCHAR(150) NOT NULL,

                        sku VARCHAR(50) NOT NULL,

                        produto VARCHAR(150) NOT NULL,

                        quantidade INT NOT NULL,

                        valor DECIMAL(10, 2) NOT NULL,

                        status VARCHAR(30) NOT NULL DEFAULT 'CRIADO',

                        CONSTRAINT pk_pedido
                            PRIMARY KEY (id),

                        CONSTRAINT ck_pedido_quantidade
                            CHECK (quantidade > 0),

                        CONSTRAINT ck_pedido_valor
                            CHECK (valor > 0),

                        CONSTRAINT ck_pedido_status
                            CHECK (
                                status IN (
                                           'CRIADO',
                                           'RESERVADO',
                                           'CONFIRMADO',
                                           'CANCELADO',
                                           'PENDENTE_ESTOQUE'
                                    )
                                )
);
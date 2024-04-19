CREATE TABLE IF NOT EXISTS products
(
    id          CHAR(36)       NOT NULL,
    name        VARCHAR(255)   NOT NULL,
    description VARCHAR(255)   NULL,
    price       DECIMAL(10, 2) NOT NULL,
    weight      double         NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

INSERT IGNORE INTO products (id, name, description, price, weight)
VALUES ('a7b5d52f-5f3b-4b6e-9d3b-3f6a6b6f1f1a', 'Product 1', 'Description 1', 100.00, 1.0);

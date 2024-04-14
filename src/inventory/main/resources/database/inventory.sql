CREATE TABLE IF NOT EXISTS products (
    id CHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

INSERT IGNORE INTO products (id, name, price)
    VALUES ('efbaff16-8fcd-4689-9fc9-ec545d641c46', 'Product 1', 100.00);

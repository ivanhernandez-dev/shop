CREATE TABLE IF NOT EXISTS products
(
    id          CHAR(36)       NOT NULL,
    name        VARCHAR(255)   NOT NULL,
    description VARCHAR(255)   NULL,
    price       DECIMAL(10, 2) NOT NULL,
    weight      double         NOT NULL,
    color       VARCHAR(255)   NULL,
    material    VARCHAR(255)   NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

INSERT IGNORE INTO products (id, name, description, price, weight, color, material)
VALUES ('a7b5d52f-5f3b-4b6e-9d3b-3f6a6b6f1f1a', 'Product 1', 'Description 1', 100.00, 1.0, 'red', 'plastic');

CREATE TABLE IF NOT EXISTS categories
(
    id   CHAR(36)     NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

INSERT IGNORE INTO categories (id, name)
VALUES ('8b3342ed-6544-4abe-8a94-76b530f37a42', 'Category 1');

CREATE TABLE IF NOT EXISTS shelves
(
    id         CHAR(36) NOT NULL,
    length     double   NOT NULL,
    width      double   NOT NULL,
    max_weight double   NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

INSERT IGNORE INTO shelves (id, length, width, max_weight)
VALUES ('f7b5d52f-5f3b-4b6e-9d3b-3f6a6b6f1f1a', 10.0, 10.0, 100.0);

CREATE TABLE IF NOT EXISTS stocks
(
    product_id CHAR(36) NOT NULL,
    shelf_id   CHAR(36) NOT NULL,
    amount   INT      NOT NULL,
    PRIMARY KEY (product_id, shelf_id),
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (shelf_id) REFERENCES shelves (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

INSERT IGNORE INTO stocks (product_id, shelf_id, amount)
VALUES ('a7b5d52f-5f3b-4b6e-9d3b-3f6a6b6f1f1a', 'f7b5d52f-5f3b-4b6e-9d3b-3f6a6b6f1f1a', 10);

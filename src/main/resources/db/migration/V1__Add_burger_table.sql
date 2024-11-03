CREATE TABLE burger
(
    id                  UUID PRIMARY KEY,
    name                TEXT           NOT NULL,
    description         TEXT,
    image               TEXT,
    price               DECIMAL(10, 2) NOT NULL,
    weight              DECIMAL(10, 2),
    vegetarian          BOOLEAN DEFAULT FALSE,
    available           BOOLEAN DEFAULT TRUE,
    special_ingredients TEXT [],
    allergens           TEXT []
);
CREATE TABLE drink
(
    id          UUID PRIMARY KEY,
    name        TEXT           NOT NULL,
    description TEXT,
    image       TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    available   BOOLEAN DEFAULT TRUE
);
